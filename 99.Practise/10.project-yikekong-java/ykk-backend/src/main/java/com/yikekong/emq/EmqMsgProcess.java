package com.yikekong.emq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yikekong.dto.DeviceInfoDTO;
import com.yikekong.dto.DeviceLocation;
import com.yikekong.es.ESRepository;
import com.yikekong.service.*;
import com.yikekong.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息回调类
 */
@Component
@Slf4j
public class EmqMsgProcess implements MqttCallback {

    @Autowired
    private EmqClient emqClient;


    @Autowired
    private QuotaService quotaService;

    @Autowired
    private AlarmService alarmService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private GpsService gpsService;

    @Autowired
    private ESRepository esRepository;

    @Autowired
    private NoticeService noticeService;

    /**
     * 接收到消息时自动执行
     * @param topic
     * @param mqttMessage
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        //接收到消息
        String payload=new String(mqttMessage.getPayload());
        System.out.println("接收到数据："+payload);
        ObjectMapper mapper=new ObjectMapper();
        Map payloadMap = mapper.readValue(payload, Map.class);

        //解析指标
        DeviceInfoDTO deviceInfoDTO = quotaService.analysis(topic, payloadMap);
        if(deviceInfoDTO!=null){
            //告警判断
            deviceInfoDTO= alarmService.verifyDeviceInfo(deviceInfoDTO);
            //保存设备信息
            deviceService.saveDeviceInfo(deviceInfoDTO.getDevice());
            //保存指标数据
            quotaService.saveQuotaToInflux(deviceInfoDTO.getQuotaList());
            //指标透传
            noticeService.quotaTransfer(deviceInfoDTO.getQuotaList());

        }

        //解析gps
        DeviceLocation deviceLocation = gpsService.analysis(topic, payloadMap);
        if(deviceLocation!=null){
            System.out.println("gps解析结果："+ JsonUtil.serialize(deviceLocation));
            esRepository.saveLocation(deviceLocation);
            noticeService.gpsTransfer( deviceLocation );
        }
    }

    /**
     * 丢失连接时自动执行（同Monitor的init())
     * @param throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.info("emq connect lost");
        //重新连接
        emqClient.connect();
        // 重新订阅
        quotaService.getAllSubject().forEach(s -> {
            //共享订阅模式
            try {
                emqClient.subscribe("$queue/"+s);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
