package com.xxmes.opcapp.strategy;

import cn.hutool.core.collection.CollUtil;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.xxmes.opcapp.model.opc.LabelDetail;
import com.xxmes.opcapp.config.OpcInitSubscriptionConfig;
import com.xxmes.opcapp.uitls.BasicUtils;
import com.xxmes.opcapp.uitls.CheckUtil;
import com.xxmes.opcapp.uitls.OperationUtil;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 心跳策略
 * @author chenxi21
 *
 */
public class HeartStrategy implements SubscribeService{
	
	//private Logger log = Logger.getLogger(HeartStrategy.class);
	private static Logger log = LoggerFactory.getLogger(HeartStrategy.class);

	/** 心跳读取标签后缀 */
//    public static final String[] HEART_READ = {"NetWork.MES","Run.In_LeftStorage","Run.In_CutLineSN","Run.Out_RollerSN","Run.Out_RollGap","Run.Out_Groover"};
    public static final String[] HEART_READ = {"QPHeartOut_HeartCheckResult"};

	@Override
	public void subscribeHandle(OpcUaClient client, String subLabel, String valueStr) {
		IFunctionsEx FUNCTION = BasicUtils.getFunction();
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
				
				//采集钢线数据
//				HashMap<String, Object> map = new HashMap<>();
//				map.put("spool_no", cutLineSN);
//				map.put("section_upload_flag", deviceNo);
//				Vector vector1 = new Vector<>();
//				vector1 = DBUtils.getObjectVectorFromATTable(FUNCTION, "OM_DiamondLine",map);
//				ATRow atRow = null;
//				if(CollUtil.isNotEmpty(vector1)) {
//					atRow = (ATRow) vector1.get(0);
//					Object lastLeftStorageMinObj = atRow.getValue("present_line_min");
//					float lastLeftStorageMin = (lastLeftStorageMinObj != null ? (float) lastLeftStorageMinObj : Float.parseFloat("0")) * 1000.0f;
//					if(lastLeftStorageMin > leftStorage) {
//						if(leftStorage < 0) {
//							atRow.setValue("present_line_min", 0.0f);	//最小余线量
//						}else {
//							atRow.setValue("present_line_min", leftStorage/1000.0f);	//最小余线量
//						}
//					}
//					//如果左线储量为负数，则钢线余量设置为0
//					if(leftStorage < 0) {
//						atRow.setValue("present_line", 0.0f);	//钢线余量
//					}else {
//						atRow.setValue("present_line", leftStorage/1000.0f);	//钢线余量
//					}
//					atRow.setValue("present_modify_by", "SOS");
//					atRow.setValue("present_modify_time", FUNCTION.getDBTime());
//					Response resp1 = atRow.save(null, null, null);
//				    if(resp1.isOk()) {
//				    	log.info("设备编号："+ deviceNo + "，钢线编码：" + cutLineSN + "，放线轮线量："+leftStorage/1000.0f);
//				    	OperationUtil.LogToOperDB("INFO","lineNo：" + cutLineSN + "，leftLineStorage："+ leftStorage/1000.0f , "opcapp:HeartStrategy", "ALTER_PRESENT_LINE", "opcapp");
//				    }
//				}
				//更新主辊数据
				Map<String, Object> rollerMap = CheckUtil.getRollerInfomationByEquip(deviceNo);
				String rollerSN = (String) rollerMap.get("rollerSN");
				float rollerGap = (float)rollerMap.get("rollerGap");
				String groover = (String) rollerMap.get("rollerGroover");
				boolean isWriteRoll = (!rollerSN.equals(rollerSnFromEq)) || rollerGap != rollerGapFromEq || (!groover.equals(grooverFromEq));
				if(isWriteRoll) {
					//回写
					String outRollerSNLabel = prefix + "Run.Out_RollerSN";
					String outRollerGapLabel = prefix + "Run.Out_RollGap";
					String outRollerGrooverLabel = prefix + "Run.Out_Groover";
					OperationUtil.writeLabel(client, namespace, outRollerSNLabel, rollerSN);
					OperationUtil.writeLabel(client, namespace, outRollerGapLabel, rollerGap);
					OperationUtil.writeLabel(client, namespace, outRollerGrooverLabel, groover);
					log.info("设备编号："+ deviceNo + "，更新主辊信息：" + rollerMap);
				}
				//MES控制激活处理
				String sql = "select case IS_ACTIVE_Y when 1 then 'true' else 'false' end from AT_EM_EQUIP_NETWORK where EQUIP_ID_S = '"+ deviceNo +"'";
				Vector queryRes = FUNCTION.getArrayDataFromActive(sql);
				if(CollUtil.isNotEmpty(queryRes)) {
					Object[] arr = (Object[]) queryRes.get(0);
					//获取数据库活跃状态
					String dbActive = arr[0].toString();
					//校验db状态和读取的状态是否一致
					if(!dbActive.equals(readHeart)) {
						outMes = true;
					}
				}
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
