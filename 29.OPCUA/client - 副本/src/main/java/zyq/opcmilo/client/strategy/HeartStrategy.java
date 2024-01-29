package com.xxmes.opcapp.strategy;

import cn.hutool.core.collection.CollUtil;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zyq.opcmilo.client.config.OpcInitSubscriptionConfig;
import zyq.opcmilo.client.model.opc.LabelDetail;
import zyq.opcmilo.client.strategy.SubscribeService;
import zyq.opcmilo.client.uitls.OperationUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 心跳策略
 * @author chenxi21
 *
 */
public class HeartStrategy implements SubscribeService {
	private static Logger log = LoggerFactory.getLogger(HeartStrategy.class);

	/** 心跳读取标签后缀 */
//    public static final String[] HEART_READ = {"NetWork.MES","Run.In_LeftStorage","Run.In_CutLineSN","Run.Out_RollerSN","Run.Out_RollGap","Run.Out_Groover"};
    public static final String[] HEART_READ = {"QPHeartOut_HeartCheckResult"};

	@Override
	public void subscribeHandle(OpcUaClient client, String subLabel, String valueStr) {
		log.info("》》》开始处理心跳标签 :" + subLabel);
		String prefix = subLabel.split("NetWork")[0];
		LabelDetail detail = OpcInitSubscriptionConfig.labelInfos.get(subLabel);
		String deviceNo = detail.getDevice();
		Integer namespace = OpcInitSubscriptionConfig.labelInfos.get(subLabel).getNameSpace();
		List<NodeId> nodeIds = Arrays.stream(HEART_READ).map(item -> new NodeId(namespace, prefix + item)).collect(Collectors.toList());
		client.readValues(0.0, TimestampsToReturn.Both, nodeIds).thenAccept(values -> {

			//标签拼接
			String outHeartLabel = prefix + "NetWork.Out_Heart";
			String outMesLabel = prefix + "NetWork.Out_MES";
			String outEqIdLabel = prefix + "NetWork.Out_EQ_ID";
			String outErrorLabel = prefix + "NetWork.Out_ErrIP";
			//MES反馈
			boolean outMes = false;
			boolean outHeart = true;
			Short outError = 0;

			try {
				//MES激活状态
				String readHeart = "false";
				Object obj =  values.get(0).getValue().getValue();
				readHeart = obj == null ? "true" : obj.toString() ;
				//左线储量
				float leftStorage = (float)Optional.ofNullable(values.get(1).getValue().getValue()).orElseGet(() -> 0.0f);
				//钢线编码
				String cutLineSN = ((String)Optional.ofNullable(values.get(2).getValue().getValue()).orElseGet(() -> "")).trim();
				//主辊编码
				String rollerSnFromEq = ((String)Optional.ofNullable(values.get(3).getValue().getValue()).orElseGet(() -> "")).trim();
				//主辊槽距
				float  rollerGapFromEq = (float)Optional.ofNullable(values.get(4).getValue().getValue()).orElseGet(() -> 0.0f);
				//刻槽机编号
				String grooverFromEq = ((String)Optional.ofNullable(values.get(5).getValue().getValue()).orElseGet(() -> "")).trim();
			}catch(Exception ex) {
				ex.printStackTrace();
				log.info(OperationUtil.getExceptionAllinformation(ex));
				outError = 99;
			}finally {
				//opc回写
				OperationUtil.writeLabel(client, namespace, outHeartLabel, outHeart);
				OperationUtil.writeLabel(client, namespace, outMesLabel, outMes);
				OperationUtil.writeLabel(client, namespace, outEqIdLabel, deviceNo);
				OperationUtil.writeLabel(client, namespace, outErrorLabel, outError);
				log.info("结束处理心跳标签 :" + subLabel);
			}
		});

	}

}
