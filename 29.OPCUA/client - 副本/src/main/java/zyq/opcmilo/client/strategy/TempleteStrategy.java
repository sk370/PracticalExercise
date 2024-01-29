package zyq.opcmilo.client.strategy;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zyq.opcmilo.client.config.OpcInitSubscriptionConfig;
import zyq.opcmilo.client.model.opc.LabelDetail;
import zyq.opcmilo.client.uitls.OperationUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 策略模板
 * @author chenxi21
 *
 */
public class TempleteStrategy implements SubscribeService {
	private static Logger log = LoggerFactory.getLogger(TempleteStrategy.class);

	/** 标签后缀 */
    public static final String[] ARRAY_READ = {"GroupName.tagName01","GroupName.tagName02","GroupName.tagName03"};

	@Override
	public void subscribeHandle(OpcUaClient client, String subLabel, String valueStr) {
		
		log.info("》》》开始处理标签 :" + subLabel);

		//分割标签
		String prefix = subLabel.split("GroupName")[0];
		LabelDetail detail = OpcInitSubscriptionConfig.labelInfos.get(subLabel);
		
		Integer namespace = OpcInitSubscriptionConfig.labelInfos.get(subLabel).getNameSpace();
		List<NodeId> nodeIds = Arrays.stream(ARRAY_READ).map(item -> new NodeId(namespace, prefix + item)).collect(Collectors.toList());
		client.readValues(0.0, TimestampsToReturn.Both, nodeIds).thenAccept(values -> {		
			
			//拼接要回写的标签
			String outEqIdLabel = prefix + "Run.In_EQ_ID";
			String outEqId = null;
			
			//业务逻辑
			try {
				//取出ARRAY_READ中的数据，values是对应的值的数组
				String readHeart = values.get(1).getValue().getValue().toString();
				
				//写数据
				OperationUtil.writeLabel(client, namespace, outEqIdLabel, outEqId);
				
			}catch(Exception ex) {
				//处理异常
				ex.printStackTrace();
				log.info(OperationUtil.getExceptionAllinformation(ex));
			}
			
			OperationUtil.writeLabel(client, namespace, outEqIdLabel, outEqId);
			log.info("结束处理标签 :" + subLabel);
		});
	}
}
