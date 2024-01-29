package zyq.opcmilo.client.strategy;

import jakarta.annotation.Resource;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zyq.opcmilo.client.config.OpcInitSubscriptionConfig;
import zyq.opcmilo.client.model.opc.LabelDetail;
import zyq.opcmilo.client.pojo.entity.VirtualMachine;
import zyq.opcmilo.client.repository.VirtualMachineRepository;
import zyq.opcmilo.client.uitls.GetBeanUtil;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class EquipDataGatherStrategy implements SubscribeService {

	private static Logger log = LoggerFactory.getLogger(EquipDataGatherStrategy.class);
	private VirtualMachineRepository virtualMachineRepository = GetBeanUtil.getBean(VirtualMachineRepository.class);
	public static final String[] DATA_IN_LABEL = {
			"EquipNo",
			"EquipName",
			"RotateSpeed",
			"Temperature",
			"Operator"
	};//读数据标签
	public static final String[] DATA_FEEDBACK_LABEL = {""};//反馈码标签


	@Override
	public void subscribeHandle(OpcUaClient client, String subLabel, String valueStr) {
		String prefix = subLabel.substring(0,9);

		Integer namespace = OpcInitSubscriptionConfig.labelInfos.get(subLabel).getNameSpace();

		String feedbackLabel = prefix + DATA_FEEDBACK_LABEL[0];

		if ("false".equals(valueStr)) {
			log.info("订阅标签值" + valueStr + "，复位握手信号：" + subLabel);
			return;
		}

		log.info(">>>处理标签开始:" + subLabel);
		LabelDetail detail = OpcInitSubscriptionConfig.labelInfos.get(subLabel);

		List<NodeId> inNodeIds = Arrays.stream(DATA_IN_LABEL).map(item -> new NodeId(namespace, prefix + item)).collect(Collectors.toList());//读数据标签
		String deviceNo = detail.getDevice();
		client.readValues(0.0, TimestampsToReturn.Both, inNodeIds).thenAccept(values -> {
			try {
				// 设备编号
				String equipNo = ((String) Optional.ofNullable(values.get(0).getValue().getValue()).orElseGet(() -> "")).trim();
				// 设备名称
				String equipName = ((String) Optional.ofNullable(values.get(1).getValue().getValue()).orElseGet(() -> "")).trim();
				// 转速
				Integer rotateSpeed = (Integer) Optional.ofNullable(values.get(2).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 温度
				Float temperature = (Float) Optional.ofNullable(values.get(3).getValue().getValue()).orElseGet(() -> Float.valueOf("0"));
				// 操作人
				String operator = ((String) Optional.ofNullable(values.get(4).getValue().getValue()).orElseGet(() -> "")).trim();
				// 当前时间
				Timestamp time= new Timestamp(System.currentTimeMillis());

				System.out.println(equipNo+" " + equipName + " " + operator + " "+ temperature + " " + rotateSpeed);
				VirtualMachine virtualMachine = new VirtualMachine();
				virtualMachine.setEquipNo(equipNo);
				virtualMachine.setEquipName(equipName);
				virtualMachine.setRotateSpeed(rotateSpeed);
				virtualMachine.setTemperature(temperature);
				virtualMachine.setUpdatedBy(operator);
				virtualMachineRepository.save(virtualMachine);
				System.out.println(virtualMachineRepository);
				log.info(">>>读取" + equipName + "机台标签数据成功！" + subLabel);


			} catch (Exception e) {
				e.printStackTrace();
				log.info(">>>处理标签 :" + subLabel + "发生异常：");
			} finally {
				log.info(">>>处理标签结束 :" + subLabel);
			}
		});
	}
}
