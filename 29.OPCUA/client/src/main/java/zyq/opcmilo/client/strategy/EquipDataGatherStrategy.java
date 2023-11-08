package zyq.opcmilo.client.strategy;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zyq.opcmilo.client.config.OpcInitSubscriptionConfig;
import zyq.opcmilo.client.model.opc.LabelDetail;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 钢线下机策略
 *
 * @author chenxi21
 */
public class CleanEquipDataGatherStrategy implements SubscribeService {

//	private static Logger log = Logger.getLogger(CleanEquipDataGatherStrategy.class);//log4j配置文件用这个
	private static Logger log = LoggerFactory.getLogger(CleanEquipDataGatherStrategy.class);

	public static final String[] DATA_IN_LABEL = {
			"Equip.CPEqIn_Await_Full_Basket_UseTime",
			"Equip.CPEqIn_AwaitEmptyBasket_Time",
			"Equip.CPEqIn_BigReturnBasket_ProductChage_LostTime",
			"Equip.CPEqIn_BigReturnBasket_ProductJam_LostTime",
			"Equip.CPEqIn_BigReturnBasket_ProductJam_Times",
			"Equip.CPEqIn_BigReturnBasket_SerialChange_AwaitTime",
			"Equip.CPEqIn_ChangeWater_LostTime",
			"Equip.CPEqIn_Clean_ProductBlocked_LostTime",
			"Equip.CPEqIn_CleanEmptySlot_Timing",
			"Equip.CPEqIn_LostTime_Total",
			"Equip.CPEqIn_LostTime_Total_Hour",
			"Equip.CPEqIn_LostTime_Total_Minute",
			"Equip.CPEqIn_LostTime_Total_Second",
			"Equip.CPEqIn_Machine_Block_UseTime",
//			"Equip.CPEqIn_Machine_Maintenance_UseTime",
			"Equip.CPEqIn_WaitMaterialLost",
			"Equip.CPEqIn_SmallReturnBasket_ProductChage_LostTime",
			"Equip.CPEqIn_SmallReturnBasket_ProductJam_LostTime",
			"Equip.CPEqIn_SmallReturnBasket_ProductJam_Times",
			"Equip.CPEqIn_SmallReturnBasket_SerialChange_AwaitTime",
			"Equip.CPUpIn_EquipName",
			"Equip.CPEqIn_InsertNumber_0_1",
			"Equip.CPEqIn_InsertNumber_1_2",
			"Equip.CPEqIn_InsertNumber_2_3",
			"Equip.CPEqIn_InsertNumber_3_4",
			"Equip.CPEqIn_InsertNumber_4_5",
			"Equip.CPEqIn_InsertNumber_5_6",
			"Equip.CPEqIn_InsertNumber_6_7",
			"Equip.CPEqIn_InsertNumber_7_8",
			"Equip.CPEqIn_InsertNumber_8_9",
			"Equip.CPEqIn_InsertNumber_9_10",
			"Equip.CPEqIn_InsertNumber_10_11",
			"Equip.CPEqIn_InsertNumber_11_12",
			"Equip.CPEqIn_InsertNumber_12_13",
			"Equip.CPEqIn_InsertNumber_13_14",
			"Equip.CPEqIn_InsertNumber_14_15",
			"Equip.CPEqIn_InsertNumber_15_16",
			"Equip.CPEqIn_InsertNumber_16_17",
			"Equip.CPEqIn_InsertNumber_17_18",
			"Equip.CPEqIn_InsertNumber_18_19",
			"Equip.CPEqIn_InsertNumber_19_20",
			"Equip.CPEqIn_InsertNumber_20_21",
			"Equip.CPEqIn_InsertNumber_21_22",
			"Equip.CPEqIn_InsertNumber_22_23",
			"Equip.CPEqIn_InsertNumber_23_24",
			"Equip.CPEqIn_InsertNumber_Current"
	};//读数据标签
	public static final String[] DATA_FEEDBACK_LABEL = {"Equip.CPEqOut_SaveStatusCheckResult"};//反馈码标签


	@Override
	public void subscribeHandle(OpcUaClient client, String subLabel, String valueStr) {
		String prefix = subLabel.split("Equip")[0];
		String suffix = subLabel.split("Equip")[1];

		Integer namespace = OpcInitSubscriptionConfig.labelInfos.get(subLabel).getNameSpace();

		String feedbackLabel = prefix + DATA_FEEDBACK_LABEL[0];

		String from = suffix.substring(1);

		if ("false".equals(valueStr)) {
			log.info("订阅标签值" + valueStr + "，复位握手信号：" + subLabel);
			return;
		}

		log.info(">>>开始处理插片机工时标签 :" + subLabel);
		LabelDetail detail = OpcInitSubscriptionConfig.labelInfos.get(subLabel);

		List<NodeId> inNodeIds = Arrays.stream(DATA_IN_LABEL).map(item -> new NodeId(namespace, prefix + item)).collect(Collectors.toList());//读数据标签
		String deviceNo = detail.getDevice();
		client.readValues(0.0, TimestampsToReturn.Both, inNodeIds).thenAccept(values -> {
			try {
				// 满蓝去0槽等待
				Integer awaitFullBasket = (Integer) Optional.ofNullable(values.get(0).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 等待空花篮计时
				Integer awaitEmptyBasket = (Integer) Optional.ofNullable(values.get(1).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 大回篮换料损失计时
				Integer bbProductChange = (Integer) Optional.ofNullable(values.get(2).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 大回篮卡片损失计时
				Integer bbStuck = (Integer) Optional.ofNullable(values.get(3).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 大回篮卡片次数统计
				Short bbStuckTimes = (Short) Optional.ofNullable(values.get(4).getValue().getValue()).orElseGet(() -> Short.valueOf("0"));
				// 大回篮换随工单等待时间
				Integer bbSerialChange = (Integer) Optional.ofNullable(values.get(5).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 换水损失计时
				Integer waterChange = (Integer) Optional.ofNullable(values.get(6).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 清洗堵料计时
				Integer blockClean = (Integer) Optional.ofNullable(values.get(7).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 清洗空槽计时
				Integer cleanEmptyslot = (Integer) Optional.ofNullable(values.get(8).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 浪费总时间
				Integer lostTime = (Integer) Optional.ofNullable(values.get(9).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 浪费总时间_小时
				Integer lostTimeHour = (Integer) Optional.ofNullable(values.get(10).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 浪费总时间_分钟
				Integer lostTimeMinutes = (Integer) Optional.ofNullable(values.get(11).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 浪费总时间_秒钟
				Integer lostTimeSecod = (Integer) Optional.ofNullable(values.get(12).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 插片清洗机故障时长
				Integer equipBlock = (Integer) Optional.ofNullable(values.get(13).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 插片清洗机保养时长
//				Integer equipMaintenance = (Integer) Optional.ofNullable(values.get(14).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 插片机待料损失
				Integer waitMaterialLost = (Integer) Optional.ofNullable(values.get(14).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 小回篮换料损失计时
				Integer sbProductChange = (Integer) Optional.ofNullable(values.get(15).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 小回篮卡片损失计时
				Integer sbStuck = (Integer) Optional.ofNullable(values.get(16).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 小回篮卡片次数统计
				Short sbStuckTimes = (Short) Optional.ofNullable(values.get(17).getValue().getValue()).orElseGet(() -> Short.valueOf("0"));
				// 小回篮换随工单等待计时
				Integer sbSerialChange = (Integer) Optional.ofNullable(values.get(18).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 设备编号
				String equipName = ((String) Optional.ofNullable(values.get(19).getValue().getValue()).orElseGet(() -> "")).trim();
				// 0-1 时插片数量
				Integer insertNumber_0_1 = (Integer) Optional.ofNullable(values.get(20).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 1-2 时插片数量
				Integer insertNumber_1_2 = (Integer) Optional.ofNullable(values.get(21).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 2-3 时插片数量
				Integer insertNumber_2_3 = (Integer) Optional.ofNullable(values.get(22).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 3-4 时插片数量
				Integer insertNumber_3_4 = (Integer) Optional.ofNullable(values.get(23).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 4-5 时插片数量
				Integer insertNumber_4_5 = (Integer) Optional.ofNullable(values.get(24).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 5-6 时插片数量
				Integer insertNumber_5_6 = (Integer) Optional.ofNullable(values.get(25).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 6-7 时插片数量
				Integer insertNumber_6_7 = (Integer) Optional.ofNullable(values.get(26).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 7-8 时插片数量
				Integer insertNumber_7_8 = (Integer) Optional.ofNullable(values.get(27).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 8-9 时插片数量
				Integer insertNumber_8_9 = (Integer) Optional.ofNullable(values.get(28).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 9-10 时插片数量
				Integer insertNumber_9_10 = (Integer) Optional.ofNullable(values.get(29).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 10-11 时插片数量
				Integer insertNumber_10_11 = (Integer) Optional.ofNullable(values.get(30).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 11-12 时插片数量
				Integer insertNumber_11_12 = (Integer) Optional.ofNullable(values.get(31).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 12-13 时插片数量
				Integer insertNumber_12_13 = (Integer) Optional.ofNullable(values.get(32).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 13-14 时插片数量
				Integer insertNumber_13_14 = (Integer) Optional.ofNullable(values.get(33).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 14-15 时插片数量
				Integer insertNumber_14_15 = (Integer) Optional.ofNullable(values.get(34).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 15-16 时插片数量
				Integer insertNumber_15_16 = (Integer) Optional.ofNullable(values.get(35).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 16-17 时插片数量
				Integer insertNumber_16_17 = (Integer) Optional.ofNullable(values.get(36).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 17-18 时插片数量
				Integer insertNumber_17_18 = (Integer) Optional.ofNullable(values.get(37).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 18-19 时插片数量
				Integer insertNumber_18_19 = (Integer) Optional.ofNullable(values.get(38).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 19-20 时插片数量
				Integer insertNumber_19_20 = (Integer) Optional.ofNullable(values.get(39).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 20-21 时插片数量
				Integer insertNumber_20_21 = (Integer) Optional.ofNullable(values.get(40).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 21-22 时插片数量
				Integer insertNumber_21_22 = (Integer) Optional.ofNullable(values.get(41).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 22-23 时插片数量
				Integer insertNumber_22_23 = (Integer) Optional.ofNullable(values.get(42).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 23-24 时插片数量
				Integer insertNumber_23_24 = (Integer) Optional.ofNullable(values.get(43).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 实时插片数量
				Integer currentInsertNumber = (Integer) Optional.ofNullable(values.get(44).getValue().getValue()).orElseGet(() -> Integer.valueOf("0"));
				// 信号来源
				Integer singleSource = null;
				// 是否最终数据
				Integer lastData = null;
				// 浪费总时长
				String totalTime = lostTimeHour + "小时" + lostTimeMinutes + "分钟" + lostTimeSecod + "秒";

//				log.info(">>>读取" + equipName + "信号来源：MySubscription.BTNHANDSHARK.getLabelType()：" + MySubscription.BTNHANDSHARK.getLabelType() + "，来源" + from);
				log.info(">>>读取" + equipName + "机台标签数据成功！" + subLabel);


			} catch (Exception e) {
				e.printStackTrace();
				log.info(">>>处理插片机工时标签 :" + subLabel + "发生异常：");
			} finally {
				log.info(">>>结束处理插片机工时标签 :" + subLabel);
			}
		});
	}
}
