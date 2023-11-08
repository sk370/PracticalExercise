package com.xxmes.opcapp.config;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.xxmes.opcapp.pojo.enums.MySubscription;
import com.xxmes.opcapp.model.opc.ConfigInfo;
import com.xxmes.opcapp.model.opc.ConfigInfoSub;
import com.xxmes.opcapp.model.opc.LabelDetail;
import com.xxmes.opcapp.strategy.SubscribeService;
import com.xxmes.opcapp.uitls.BasicUtils;
import com.xxmes.opcapp.context.OpcSubscriptionListener;
import com.xxmes.opcapp.context.OpcUAClientRunner;
import org.apache.commons.io.FileUtils;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaMonitoredItem;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.sdk.client.subscriptions.OpcUaSubscriptionManager;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

@SuppressWarnings("serial")
public class OpcInitSubscriptionConfig extends HttpServlet {
	
	//private Logger log = Logger.getLogger(OpcInitSubscriptionServlet.class);
	private static Logger log = LoggerFactory.getLogger(OpcInitSubscriptionConfig.class);
	
	//装载最终组合的标签
	public static ConcurrentHashMap<String, LabelDetail> labelInfos = new ConcurrentHashMap<>();
	//前缀集合
	public static List<String> prefixList = new ArrayList<>();
	//数据库操作对象
	//private static final IFunctionsEx FUNCTIONS = BasicUtils.getFunction();
	
	@Override
	public void init() throws ServletException {
		//创建客户端
		OpcUAClientRunner runner = new OpcUAClientRunner();
		try {
			runner.createClient();
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
		//读取配置文件
		ConfigInfo info = null;
		try {
			File file = new File(AppConfig.CONFIG_FILE_PATH);
			String fileStr = FileUtils.readFileToString(file, "UTF-8");
			info = JSON.parseObject(fileStr, ConfigInfo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//解析配置实体生成订阅相关标签
		if(ObjectUtil.isNotNull(info)) {
			Double interval = info.getSamplingInterval();
			List<ConfigInfoSub> infoSubs = info.getSubscription();
			//开始解析
			generateLabelInfos(infoSubs, interval);
			if(!labelInfos.isEmpty()) {
				log.info("解析配置文件成功，" + "解析成功后的订阅标签数量为："+ labelInfos.size());
				startSubscribe();
			}else {
				log.info("解析配置文件失败。。。");
			}
		}else {
			log.info("读取配置文件失败。。。");
		}
	}
	
	/**
	 * 解析配置实体生成订阅相关标签
	 * @param
	 * @return
	 */
	public void generateLabelInfos(List<ConfigInfoSub> infoSubs, Double interval){
		infoSubs.stream().forEach(item -> {
			String channel = item.getChannel();
			String device = item.getDevice();
			String prefix = channel + "." + device + ".";
			prefixList.add(prefix);
			Integer namespace = item.getNamespace();
			item.getSuffixs().stream().forEach(elem -> {
				//订阅标签
				String subLabel = prefix + elem;
				generateDetail(device, prefix, subLabel, namespace, interval);
			});
		});
	}
	
	private void generateDetail(String device, String prefix, String subLabel, Integer namespace, Double interval) {
		LabelDetail detail = new LabelDetail();
		detail.setDevice(device);
		detail.setNameSpace(namespace);
		detail.setInterval(interval);
		labelInfos.put(subLabel, detail);
	}
	
	/**
	 * 启动订阅
	 */
	public void startSubscribe() {
		if(labelInfos.size() > 0) {
			OpcUaClient client = OpcUAClientRunner.opcUaClient;
			try {
				client.connect().get();
			} catch (Exception e) {
				e.printStackTrace();
				log.info("客户端获取连接失败。。。");
				return;
			}
			log.info("客户端获取连接成功");
			if(ObjectUtil.isNotNull(client)) {
	            try {
					Set<String> subKeys = labelInfos.keySet();
					log.info("订阅标签数量：" + subKeys.size() + "， 内容：" + subKeys.toString());
					subKeys.stream().forEach(atom -> createSubscribe(atom, client));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 创建标签订阅
	 * @param label
	 * @param client
	 */
	public void createSubscribe(String label, OpcUaClient client) {
		try {
			//创建发布间隔1000ms的订阅对象
			OpcUaSubscriptionManager manager = client.getSubscriptionManager();
            UaSubscription subscription = manager.createSubscription(1000.0).get();
            manager.addSubscriptionListener(OpcSubscriptionListener.getListener());
			NodeId nodeId = new NodeId(labelInfos.get(label).getNameSpace(), label);
			ReadValueId readValueId = new ReadValueId(nodeId, AttributeId.Value.uid(), null, null);
			//创建监控的参数
			Double interval = labelInfos.get(label).getInterval();
			MonitoringParameters parameters = new MonitoringParameters(
			        uint(1),
			        interval,
			        null,
			        uint(10),
			        true
			);
			//创建监控项请求
			//该请求最后用于创建订阅。
			MonitoredItemCreateRequest request = new MonitoredItemCreateRequest(readValueId, MonitoringMode.Reporting, parameters);
			List<MonitoredItemCreateRequest> requests = new ArrayList<>();
			requests.add(request);
			//创建监控项，并且注册变量值改变时候的回调函数。
			List<UaMonitoredItem> items = subscription.createMonitoredItems(
			        TimestampsToReturn.Both,
			        requests,
			        (item, id) -> {
			            item.setValueConsumer((item1, value) -> {
			            	NodeId subNodeId = item1.getReadValueId().getNodeId();
			            	String subLabel = subNodeId.getIdentifier().toString();
			            	StatusCode code = value.getStatusCode();
			            	log.info("开始监测标签状态");
			                if(code.isGood()) {
			                	String valueStr = value.getValue().getValue().toString();
			                	String labelType = getSuffixBylabel(subLabel);
								SubscribeService handleByType = MySubscription.getHandleByType(labelType);
								handleByType.subscribeHandle(client, subLabel, valueStr);
								log.info("订阅回调标签：" + subLabel + "状态good");
			                }else {
			                	log.info("订阅回调标签：" + subLabel + "状态bad");
			                }
			            });
			        }
			).get();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据订阅标签获取后缀
	 * @param label
	 * @return
	 */
	public String getSuffixBylabel(String label) {
		String[] arr = label.split("\\.");
        String suffix = "";
        for (int i = 2; i < arr.length; i++) {
            if (i == 2) {
                suffix += arr[i];
            }else{
                suffix += "." + arr[i];
            }
        }
		return suffix;
	}
	
}
