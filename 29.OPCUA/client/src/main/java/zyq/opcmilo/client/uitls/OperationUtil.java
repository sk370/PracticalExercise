package com.xxmes.opcapp.uitls;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.datasweep.compatibility.client.*;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.xxmes.opcapp.pojo.enums.RouteStep;
import org.apache.log4j.Logger;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class OperationUtil {

	private static Logger operationLog = Logger.getLogger(OperationUtil.class);

	private static final IFunctionsEx FUNCTION = BasicUtils.getFunction();

	/**
	 * 保存过站信息
	 * @param serialNo 随工单号
	 * @param equipNo  设备编号
	 * @param creator  创建人
	 * @param remark   备注
	 * @param sign     标志位（0：上料，1：下料）
	 */
	public static void saveLotHistory(String serialNo, String equipNo, String creator, String remark, int sign) {
		Vector vectorStartLot = new Vector();
        vectorStartLot.add(serialNo);
        vectorStartLot.add(equipNo);
        vectorStartLot.add(creator);
        vectorStartLot.add(FUNCTION.getDBTime());
        vectorStartLot.add(remark);
        String method = "START_LOT_SUBROUTINE";
        if(sign == 1) {
        	vectorStartLot.add(remark);
        	method = "COMPLETE_LOT_SUBROUTINE";
        }
        FUNCTION.subroutine(method, vectorStartLot);
	}

	/**
	 * 过站上料公共方法：clean清洗-deguming脱胶-inspect外观检 -joint拼棒-reinspect返检-section切片-sort分选-viscose粘胶
	 * @param serialNumber
	 * @param
	 * @param userName
	 * @param currTime
	 * @param remark
	 * @param op_name
	 * @return
	 * @throws DatasweepException
	 */
	public static boolean saveUploadTransit(String serialNumber, String equipName, String userName, Time currTime,
                                            String remark, String op_name) throws DatasweepException {
		//返回值
		boolean flag = false;
		//处理班次
		String Shift = formatShift(currTime);
		//获取设备所在车间、片区、工作中心
		Equipment equipObj = FUNCTION.getEquipmentByName(equipName);
		String workShop = (String) equipObj.getUDA("area");
		String productionLine = (String) equipObj.getUDA("product_line");
		String workCenter = equipObj.getWorkCenterName();
		//用户描述
		String userNameDescript = FUNCTION.getUser(userName).getName();
		//获取工序代码
		String route_step_name = RouteStep.getRouteStepByName(op_name);

		//处理数据
		Map<String, Object> lotHistortMap = new HashMap<String, Object>();
		lotHistortMap.put("serial_number", serialNumber);
		lotHistortMap.put("op_name", op_name);
    	Vector vectorLotHistory = DBUtils.getObjectVectorFromATTable(FUNCTION, "OM_LotHistory",lotHistortMap);
    	ATRow atRowLotHistory = null;
    	if(vectorLotHistory.size() > 0) {
    		atRowLotHistory = (ATRow) vectorLotHistory.get(0);
    	}else {
    		//获取工单数据
    		Lot lotObj = FUNCTION.getLotByName(serialNumber);
    		String rountName = lotObj.getRouteName();
    		Long orderItemKey = lotObj.getOrderItemKey();
    		String partNumber = lotObj.getPartNumber();
    		//存过站
    		ATHandler atHandlerLotHistory = FUNCTION.createATHandler("OM_LotHistory");
    		atRowLotHistory = atHandlerLotHistory.createATRow();
    		atRowLotHistory.setValue("serial_number", serialNumber); //随工单流水码
    		atRowLotHistory.setValue("route_name", rountName);//工艺路线名称
    		atRowLotHistory.setValue("order_item_key", orderItemKey);//订单项Key
    		atRowLotHistory.setValue("part_number", partNumber);//物料号
    	}
		atRowLotHistory.setValue("shop_name", workShop); //车间名称
		atRowLotHistory.setValue("pline_name", productionLine);//片区
		atRowLotHistory.setValue("wc_name", workCenter); //工作中心名称
		atRowLotHistory.setValue("op_name", op_name );//工序名称
		atRowLotHistory.setValue("route_step_name", route_step_name);//工序代码
		atRowLotHistory.setValue("start_shift_name", Shift); // 开始班次
		atRowLotHistory.setValue("equip_name", equipName);//设备名称
		atRowLotHistory.setValue("start_user_name", userName); //开始人员
		atRowLotHistory.setValue("start_time", currTime); //开始时间
		atRowLotHistory.setValue("start_comment", remark); //开始备注
		Response resLotHistory =  atRowLotHistory.save(null, null, null);
		if(resLotHistory.isOk()) {
			flag = true;
			LogToDB("INFO", "OperationUtil", "功能 saveUploadTransit-startLotOnEquip", "opcapp", "工序开始作业:随工单:"+serialNumber+"机台:"+equipName+",用户:"+userName);
		}
    	if(flag) {
			//更新LotWip
    		Lot lotObj = FUNCTION.getLotByName(serialNumber);
    		Long lotStatus = Long.parseLong(lotObj.getUDA("status")+"");
			Map<String, Object> lotWipMap = new HashMap<String, Object>();
			lotWipMap.put("serial_number", serialNumber);
        	Vector vectorLotWip = DBUtils.getObjectVectorFromATTable(FUNCTION, "OM_LotWIP",lotWipMap);
        	ATRow atRowLotWip = null;
        	if(vectorLotWip.size() > 0) {
        		atRowLotWip = (ATRow) vectorLotWip.get(0);
        	}else {
        		//获取工单数据项
        		Long orderItemKey = lotObj.getOrderItemKey();
        		String partNumber = lotObj.getPartNumber();
        		//保存数据
        		ATHandler atHandler = FUNCTION.createATHandler("OM_LotWIP");
        		atRowLotWip = atHandler.createATRow();
        		atRowLotWip.setValue("order_item_key",orderItemKey);	//物料号
        		atRowLotWip.setValue("part_number",partNumber);	//工序代码
        		atRowLotWip.setValue("serial_number",serialNumber);	//随工单
        	}
        	atRowLotWip.setValue("lot_status",lotStatus);	//工单状态
        	atRowLotWip.setValue("shop_name",workShop);	//车间
        	atRowLotWip.setValue("pline_name",productionLine);	//片区
        	atRowLotWip.setValue("op_name",op_name);	//工序名称
        	atRowLotWip.setValue("wc_name",workCenter);	//工作中心
        	atRowLotWip.setValue("route_step_name",route_step_name);	//工序代码
        	atRowLotWip.setValue("pdt_status","started");	//在线状态
        	atRowLotWip.setValue("wip_time",currTime);	//过点时间
        	atRowLotWip.setValue("created_by",userName);	//创建人工号
        	atRowLotWip.setValue("created_by_desc",userNameDescript);	//创建人描述
        	atRowLotWip.setValue("last_modified_by",userName);	//最后修改人
        	atRowLotWip.setValue("last_modified_by_desc",userNameDescript);	//最后修改人描述
        	atRowLotWip.setValue("equip_name",equipName);	//设备编号
    		Response resLotWip = atRowLotWip.save(null, null, null);
    		if(resLotWip.isOk()) {
    			flag = true;
    			LogToDB("INFO", "OperationUtil", "功能 saveUploadTransit-updateLotWip", "opcapp", "随工单:"+serialNumber+"机台:"+equipName+",用户:"+userName);
        	}else {
        		flag = false;
        	}
		}
    	return flag;
	}

	/**
	 * 过站下料公共方法
	 * @param serialNumber
	 * @param userName
	 * @param currTime
	 * @param remark
	 * @param op_name
	 * @return
	 * @throws DatasweepException
	 */
	public static boolean saveDownTransit(String serialNumber, String equipName, String userName, Time currTime,
                                          String remark, String op_name) throws DatasweepException {

		//返回值
		boolean flag = false;
		//处理班次
		String shift = formatShift(currTime);

		//获取设备所在车间、片区、工作中心
		Equipment equipObj = FUNCTION.getEquipmentByName(equipName);
		String workShop = (String) equipObj.getUDA("area");
		String productionLine = (String) equipObj.getUDA("product_line");
		String workCenter = equipObj.getWorkCenterName();
		//用户描述
		String userNameDescript = FUNCTION.getUser(userName).getName();
		//获取工步名称
		String route_step_name = RouteStep.getRouteStepByName(op_name);

		//保存数据
		Map<String, Object> mapListData = new HashMap<String, Object>();
		mapListData.put("serial_number", serialNumber);
		mapListData.put("op_name", op_name);
    	Vector vectorLotHistory = DBUtils.getObjectVectorFromATTable(FUNCTION, "OM_LotHistory",mapListData);
    	ATRow atRowLotHistory = null;
    	if(vectorLotHistory.size() > 0) {
    		atRowLotHistory = (ATRow) vectorLotHistory.get(0);
    	}else {
    		//获取工单数据
    		Lot lotObj = FUNCTION.getLotByName(serialNumber);
    		String rountName = lotObj.getRouteName();
    		Long orderItemKey = lotObj.getOrderItemKey();
    		String partNumber = lotObj.getPartNumber();
    		//存过站
    		ATHandler atRowHandlerLotHistory = FUNCTION.createATHandler("OM_LotHistory");
    		atRowLotHistory = atRowHandlerLotHistory.createATRow();
    		atRowLotHistory.setValue("serial_number", serialNumber); //随工单流水码
    		atRowLotHistory.setValue("shop_name", workShop); //车间名称
    		atRowLotHistory.setValue("pline_name", productionLine);//片区
    		atRowLotHistory.setValue("route_name", rountName);//工艺路线名称
    		atRowLotHistory.setValue("route_step_name", route_step_name);//工步名称
    		atRowLotHistory.setValue("order_item_key", orderItemKey);//订单项Key
    		atRowLotHistory.setValue("part_number", partNumber);//物料号
    		atRowLotHistory.setValue("wc_name", workCenter); //工作中心名称
    		atRowLotHistory.setValue("op_name", op_name );//工序名称
    		atRowLotHistory.setValue("equip_name",equipName);  //完成设备
    	}
		atRowLotHistory.setValue("complete_comment",remark);  //完成备注
		atRowLotHistory.setValue("complete_reason",remark);  //完成原因
		atRowLotHistory.setValue("complete_time",currTime);  //完成时间
		atRowLotHistory.setValue("complete_shift_name",shift);  //完成班次
		atRowLotHistory.setValue("complete_user_name",userName);  //完成操作人
		Response resLotHistory =  atRowLotHistory.save(null, null, null);
		if(resLotHistory.isOk()) {
			flag = true;
			LogToDB("INFO", "OperationUtil", "功能 saveDownTransit-startLotOnEquip", "opcapp", "工序完成作业随工单:"+serialNumber+"机台:"+equipName+",用户:"+userName);
    	}
    	//更新lotWip
    	if(flag) {
    		//更新LotWip
			Map<String, Object> lotWipMap = new HashMap<String, Object>();
			lotWipMap.put("serial_number", serialNumber);
        	Vector vectorLotWip = DBUtils.getObjectVectorFromATTable(FUNCTION, "OM_LotWIP",lotWipMap);
        	ATRow atRowLotWip = null;
        	Lot lotObj = FUNCTION.getLotByName(serialNumber);
    		Long lotStatus = Long.parseLong(lotObj.getUDA("status")+"");	//工单状态
        	if(vectorLotWip.size() > 0) {
        		atRowLotWip = (ATRow) vectorLotWip.get(0);
        	}else {
        		//获取工单数据项
        		Long orderItemKey = lotObj.getOrderItemKey();
        		String partNumber = lotObj.getPartNumber();
        		//保存数据
        		ATHandler atHandler = FUNCTION.createATHandler("OM_LotWIP");
        		atRowLotWip = atHandler.createATRow();
        		atRowLotWip.setValue("order_item_key",orderItemKey);	//物料号
        		atRowLotWip.setValue("part_number",partNumber);	//工序代码
        		atRowLotWip.setValue("serial_number",serialNumber);	//随工单
        	}
        	atRowLotWip.setValue("lot_status",lotStatus);	//工单状态
        	atRowLotWip.setValue("shop_name",workShop);	//车间
        	atRowLotWip.setValue("pline_name",productionLine);	//片区
        	atRowLotWip.setValue("op_name",op_name);	//工序名称
        	atRowLotWip.setValue("wc_name",workCenter);	//工作中心
        	atRowLotWip.setValue("route_step_name",route_step_name);	//工序代码
        	atRowLotWip.setValue("pdt_status","completed");	//在线状态
        	atRowLotWip.setValue("wip_time",currTime);	//过点时间
        	atRowLotWip.setValue("created_by",userName);	//创建人工号
        	atRowLotWip.setValue("created_by_desc",userNameDescript);	//创建人描述
        	atRowLotWip.setValue("last_modified_by",userName);	//最后修改人
        	atRowLotWip.setValue("last_modified_by_desc",userNameDescript);	//最后修改人描述
        	atRowLotWip.setValue("equip_name",equipName);	//设备编号
    		Response resLotWip = atRowLotWip.save(null, null, null);
    		if(resLotWip.isOk()) {
    			LogToDB("INFO", "OperationUtil", "功能 saveDownTransit-updateLotWip", "opcapp", "随工单:"+serialNumber+"机台:"+equipName+",用户:"+userName);
        	}else {
        		flag = false;
        	}
    	}
    	return flag;
	}

	/**
	 * 班次处理
	 * @param getDBTime
	 * @return 白、夜班
	 */
	//处理班次
	public static String formatShift(Time getDBTime) {
		Calendar calendar = getDBTime.getCalendar();
		int HH = calendar.get(Calendar.HOUR_OF_DAY);
		int mm = calendar.get(Calendar.MINUTE);
		String shift = "";
		if(HH >= 20 || HH <= 8 ) {
			 shift = "夜班";
			if( HH == 8 ) {
				if(mm >= 30 ) {
   				 	shift = "白班";
				}
			}
			if(HH == 20) {
				if(mm <= 30 ) {
   				 	shift = "白班";
				}
			}
		}else {
			 shift = "白班";
		}
		return shift;
	}

	//写标签
	public static void writeLabel(OpcUaClient client, Integer namespace, String label, Object value) {
		if(ObjectUtil.isEmpty(value)) {
			return;
		}
		if (value.getClass().getSimpleName().equals("Float")) {
			value = NumberUtil.roundDown(Float.parseFloat(value.toString()), 5).floatValue();
		}
		NodeId nodeId = new NodeId(namespace, label);
		DataValue dataValue = new DataValue(new Variant(value), null, null);
		client.writeValue(nodeId, dataValue);
	}

	//记录操作日志(OM_Operation_Log)
	public static void LogToOperDB(String level,String message,String className,String FunctionName,String userName) {
		InetAddress hostObj;
		String hostIp = null;
		String hostName = null;
		try {
			hostObj = InetAddress.getLocalHost();
			hostIp = hostObj.getHostAddress();
			hostName = hostObj.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String host = hostName + ":" + hostIp;
		ATHandler atHandler = FUNCTION.createATHandler("OM_Operation_Log");
		ATRow atRow = atHandler.createATRow();
		atRow.setValue("host",host);
	    atRow.setValue("level",level);
	    atRow.setValue("entry_time",FUNCTION.getDBTime());
	    atRow.setValue("source",className);
	    atRow.setValue("trx_name",FunctionName);
	    atRow.setValue("user",userName);
	    atRow.setValue("content",message);
	    atRow.save(null,null,null);
	}

	/**
	 * 日志存到数据库
	 * @param level 日志等级: TRACE,DEBUG,INFO,WARN,ERROR,FATAL
	 * @param className 日志主体：界面、类等
	 * @param functionName 对应的事务、功能
	 * @param userName 作业员
	 * @param message 日志内容
	 */
	//记录操作日志(OM_Log)
	public static void LogToDB(String level,String className,String functionName,String userName,String message) {
		InetAddress hostObj;
		String hostIp = null;
		String hostName = null;
		try {
			hostObj = InetAddress.getLocalHost();
			hostIp = hostObj.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		message = className + "-[" + functionName + "]:" + message;
		ATHandler atHandler = FUNCTION.createATHandler("OM_Log");
		ATRow atRow = atHandler.createATRow();
		atRow.setValue("source",className); //日志主体：界面、类等
		atRow.setValue("trx_name",functionName); //对应的事务、功能
		atRow.setValue("user",userName); //作业员
		atRow.setValue("level",level); //日志等级
		atRow.setValue("entry_time",FUNCTION.getDBTime()); //日志时间
		atRow.setValue("host",hostIp);  //主机IP
	    atRow.setValue("content",message); //日志内容
	    atRow.save(null,null,null);
	}

	//获取异常详细信息，知道出了什么错，错在哪个类的第几行 
	public static String getExceptionAllinformation(Exception ex) {
		ByteArrayOutputStream out = null;
        PrintStream pout = null;
        String ret = "";
        try {
        	out = new ByteArrayOutputStream();
        	pout = new PrintStream(out);
        	ex.printStackTrace(pout);
        	ret = new String(out.toByteArray());
        	out.close();
        }catch(Exception e){
        	//return ex.getMessage();
        }finally{
        	if(pout!=null){
        		pout.close();
        	}
        }
        return ret.toString();
	}


	/**
	 * 从数据字典中取值
	 * @param
	 * @param
	 * @return
	 */
	public static Float getValueFromDataDictionary(String name, String code) {
		Float factor = null;
		String sql = "select VALUE_S from at_sm_datadictionar p left join at_sm_datadictionaryitem s "
				+ "on p.atr_key = s.parent_key where p.NAME_S = '" + name + "' and s.code_s ='" + code + "'";
		Vector vector = FUNCTION.getArrayDataFromActive(sql);
		if(CollUtil.isNotEmpty(vector)) {
			Object[] arr = (Object[]) vector.get(0);
			factor = Float.parseFloat(arr[0].toString());
		}
		return factor;
	}
	
	
	/**
	 * 插片上料获取清洗所需数据，不计算清洗碎
	 * @param serialNo
	 * @return
	 * @throws DatasweepException
	 */
	public static Map<String, Object> getCleanNeedData(String serialNo) throws DatasweepException {
		Map<String, Object> map = new HashMap<>();
		Lot lot = FUNCTION.getLotByName(serialNo);
		if(lot == null) {
			operationLog.info("随工单：" + serialNo + " 错误");
			return map;
		}
		Float thryClnQty = 0.0f; //清洗理论进料数
		Float rollGap = 0.0f; //槽距
		Float dpFgmtWt = 0.0f; //掉片(切片碎)
		Float bpFgmtWt = 0.0f; //边皮
		Float lossLength = 0.0f; //舍弃长度
		Float tjFgmtWt = 0.0f;  //脱胶碎
		Short reasonCode = 0; //断线原因
		Float joinCrevice = 0.0f; //拼接缝
		
		Float theoryQty = 0.0f; //理论片
		Float joinLength = 0.0f; //拼棒长度
		Float qxFgmtWt = 0.0f; //清洗碎
		Float knockLoss = 0.0f; //切片信息维护-损耗长度
		Float qualityLoss = 0.0f; //质量扣减
		Float lossTotal = 0.0f; //总舍弃
		Float kchpFgmtWt = 0.0f;  //空槽厚片
		Float rodFgmtWt = 0.0f; //硅棒来料隐裂碎
		
		long serialType = (long) lot.getUDA("serial_type");
		//反洗工单
		if(serialType == 20L) {
			double theoryQtyXx = (long) lot.getUDA("qty");
			double thryClnQtyXx = (long) lot.getUDA("qty");
			theoryQty = Convert.toFloat(theoryQtyXx) ;
			thryClnQty =  Convert.toFloat(thryClnQtyXx);
			//保存插片理论进料数
			saveTheoryQty(serialNo, thryClnQty);
			map.put("thryClnQty", (short)Math.round(thryClnQty));
			map.put("rollGap", rollGap);
			map.put("dpFgmtWt", dpFgmtWt);
			map.put("bpFgmtWt", bpFgmtWt);
			map.put("lossLength", lossLength);
			map.put("tjFgmtWt", tjFgmtWt);
			map.put("reasonCode", reasonCode);
			return map;
		}
		//刻痕验证工单
		if(CheckUtil.checkLotKhyz(serialNo)) {
			theoryQty = 1.0f;
			thryClnQty = 1.0f;
			//保存插片理论进料数
			saveTheoryQty(serialNo, thryClnQty);
			map.put("thryClnQty", (short)Math.round(thryClnQty));
			map.put("rollGap", rollGap);
			map.put("dpFgmtWt", dpFgmtWt);
			map.put("bpFgmtWt", bpFgmtWt);
			map.put("lossLength", lossLength);
			map.put("tjFgmtWt", tjFgmtWt);
			map.put("reasonCode", reasonCode);
			return map;
		}

		//region 获取硅片折算系数，产品别代码修改前
		//查询产品类型
		Part part = lot.getPart();
		long partItemId = (long)part.getUDA("item_id");
		String sql1 = "select product_type_new_s from at_om_productcategory where inventory_item_id_i = '"+ partItemId +"'";
		Vector vector1 = FUNCTION.getArrayDataFromActive(sql1);
		String productType = "";
		if(CollUtil.isNotEmpty(vector1)) {
			Object[] arr = (Object[]) vector1.get(0);
			productType = arr[0].toString();
		}
		//长度转重量系数
		Float calRatio = OperationUtil.getValueFromDataDictionary(productType,"calculate_ratio");
		if(calRatio == null) {
			calRatio = 17.57f;
		}
		//单片重量
		Float wtPerPiece = OperationUtil.getValueFromDataDictionary(productType,"weight_per_piece");
		if(wtPerPiece == null) {
			wtPerPiece = 11.0f * 17.57f / calRatio;
		}
		//endregion

		//region 获取硅片折算系数，产品别代码修改后
//		HashMap<String, Float> ratioOrWeightMap = getRatioOrWeightBy(serialNo);
//		Float calRatio = ratioOrWeightMap.get("calRatio");
//		Float wtPerPiece = ratioOrWeightMap.get("weightPiece");
		//endregion

		//查询脱胶碎、掉片、边皮、清洗碎、空槽厚片
		String sql2 = "select "
				+ " max(decode(fragment_number_s,'S3',debris_weigh_f,0.0)) tj_fragment, "
				+ " max(decode(fragment_number_s,'S9',debris_weigh_f,0.0)) dp_fragment, "
				+ " max(decode(fragment_number_s,'S2',debris_weigh_f,0.0)) bp_fragment, "
				+ " max(decode(fragment_number_s,'S7',debris_weigh_f,0.0)) qx_fragment, "
				+ " max(decode(fragment_number_s,'S10',debris_weigh_f,0.0)) kchp_fragment,"
				+ " max(decode(fragment_number_s,'S11',debris_weigh_f,0.0)) rod_fragment"
				+ " from At_OM_DEBRISWEIGH where  serial_number_s = '"+serialNo+"' group by serial_number_s";
		Vector vector2 = FUNCTION.getArrayDataFromActive(sql2);
		if(CollUtil.isNotEmpty(vector2)) {
			Object[] arr = (Object[]) vector2.get(0);
			tjFgmtWt = Float.valueOf(Optional.ofNullable(arr[0]).orElseGet(() -> 0.0f).toString());//脱胶碎
			dpFgmtWt = Float.valueOf(Optional.ofNullable(arr[1]).orElseGet(() -> 0.0f).toString());//掉片
			bpFgmtWt = Float.valueOf(Optional.ofNullable(arr[2]).orElseGet(() -> 0.0f).toString());//边皮
			qxFgmtWt = Float.valueOf(Optional.ofNullable(arr[3]).orElseGet(() -> 0.0f).toString());//清洗
			kchpFgmtWt = Float.valueOf(Optional.ofNullable(arr[4]).orElseGet(() -> 0.0f).toString());//空槽厚片
			rodFgmtWt =  Float.valueOf(Optional.ofNullable(arr[5]).orElseGet(() -> 0.0f).toString());//来料隐裂碎
		}
		//清洗碎片总重量
		Float qxDebris = tjFgmtWt + dpFgmtWt + kchpFgmtWt + rodFgmtWt;
		//切片信息维护-损耗长度
		String sql3 = "select joint_length_f,home_roll_gap_f,nvl(knock_loss_f, 0) from lot_uv l "
				+ "left join at_om_datacollection dc on l.lot_name = dc.serial_number_s "
				+ "where l.lot_name = '" + serialNo + "'";
		Vector vector3 = FUNCTION.getArrayDataFromActive(sql3);
		if(CollUtil.isNotEmpty(vector3)) {
			Object[] arr = (Object[]) vector3.get(0);
			joinLength = Float.valueOf(Optional.ofNullable(arr[0]).orElseGet(() -> 0.0f).toString());
			rollGap = Float.valueOf(Optional.ofNullable(arr[1]).orElseGet(() -> 0.0f).toString());
			knockLoss = Float.valueOf(Optional.ofNullable(arr[2]).orElseGet(() -> 0.0f).toString());
		}
		//质量扣减
		String sql4 = "select sum(nvl(lv.subtract_length_F,0)+nvl(j.subtract_length1_f,0)+nvl(j.subtract_length2_f,0)) "
				+ "from lot_uv lv left join at_om_joint j on lv.LOT_NAME=j.serial_number_s where lv.LOT_NAME='" + serialNo + "'";
		Vector vector4 = FUNCTION.getArrayDataFromActive(sql4);
		if(CollUtil.isNotEmpty(vector4)) {
			Object[] arr = (Object[]) vector4.get(0);
			qualityLoss = Float.valueOf(Optional.ofNullable(arr[0]).orElseGet(() -> 0.0f).toString());
		}
		//舍弃长度
		String sql5 = "select nvl(abandon_length_f,0),broken_reason_s from at_om_boltsave where serial_number_s = '" + serialNo + "'";
		Vector vector5 = FUNCTION.getArrayDataFromActive(sql5);
		if(CollUtil.isNotEmpty(vector5)) {
			Object[] arr = (Object[]) vector5.get(0);
			lossLength = Float.valueOf(Optional.ofNullable(arr[0]).orElseGet(() -> 0.0f).toString());
			reasonCode = Short.valueOf(Optional.ofNullable(arr[1]).orElseGet(() -> 0).toString());
		}
		//拼接缝长度
		String sql6 = "SELECT nvl(joint_crevice_f,0) FROM lot_uv l LEFT JOIN at_om_joint j ON l.lot_name=j.serial_number_s " + 
				" LEFT JOIN at_om_siliconrod s ON s.rods_num_s=l.rods_num_s WHERE l.lot_name= '" + serialNo + "'";
		Vector vector6 = FUNCTION.getArrayDataFromActive(sql6);
		if(CollUtil.isNotEmpty(vector6)) {
			Object[] arr = (Object[]) vector6.get(0);
			joinCrevice = Float.valueOf(Optional.ofNullable(arr[0]).orElseGet(() -> 0.0f).toString());
		}
		//槽距
		if(rollGap > 0) {
			theoryQty = joinLength / rollGap;	//理论片
		}else {
			operationLog.info("随工单：" + serialNo + "，槽距：" + rollGap + "， 槽距有误");
			return map;
		}
		//总舍弃 = 断线舍弃 + 切片信息维护损耗长度 + 质量扣减 + 拼接缝
	    lossTotal = lossLength + knockLoss + qualityLoss + joinCrevice;
	    //边皮重量转长度
	    float bpFgmtWtToLength = bpFgmtWt / 1000.0f * calRatio;
	    //理论进料数
	    thryClnQty = theoryQty - qxDebris / wtPerPiece; //先扣除所有碎片
		float thryClnQtyxx = thryClnQty - bpFgmtWtToLength / rollGap - lossTotal / rollGap; // 扣除边皮&总舍弃长度
		short thryClnQtyInt = (short) Math.round(thryClnQtyxx);
		saveTheoryQty(serialNo, thryClnQtyxx); // 数据库存float
		map.put("thryClnQty", thryClnQtyInt);
		map.put("rollGap", rollGap);
		map.put("dpFgmtWt", dpFgmtWt);
		map.put("bpFgmtWt", bpFgmtWt);
		map.put("lossLength", lossLength);
		map.put("tjFgmtWt", tjFgmtWt);
		map.put("reasonCode", reasonCode);
		map.put("lossTotal", lossTotal);
		return map;
	}
	
	
	/**
	 * 保存理论进料数
	 * @param serialNo
	 * @param thryClnQty
	 * @throws DatasweepException
	 */
	public static void saveTheoryQty(String serialNo, Float thryClnQty) throws DatasweepException {
		HashMap<String, Object> map = new HashMap<>();
		map.put("serial_number", serialNo);
		Vector vector = DBUtils.getObjectVectorFromATTable(FUNCTION, "OM_DataCollection",map);
		ATRow row = null;
		if(CollUtil.isNotEmpty(vector)) {
			row = (ATRow) vector.get(0);
		}else {
			ATHandler singleData = FUNCTION.createATHandler("OM_DataCollection");
    		row = singleData.createATRow();
    		row.setValue("serial_number", serialNo);
		}
		row.setValue("clean_thry_qty", thryClnQty);
		Response resp = row.save(null, null, null);
		if(resp.isOk()) {
			operationLog.info("随工单：" + serialNo + "，理论进料数：" + thryClnQty + "，理论进料数保存成功!");
		}else {
			operationLog.info("随工单：" + serialNo + "，理论进料数：" + thryClnQty + "，理论进料数保存失败!");
		}
	}
	
	//创建维修工单
	public static HashMap<String, Object> createRepairOrderByEquip(String equipName, String firstCodeStr,
				String secondCodeStr, String thirdCodeStr, String userName, String cleanCycleNo) throws DatasweepException {
		String sql = "SELECT A.ORDER_ID_S,A.ORDER_STATUS_I FROM AT_EM_EquipReportAbnormal A WHERE A.EQUIP_ID_S='"
				+ equipName + "' AND A.ORDER_STATUS_I<40";
		Vector vector = FUNCTION.getArrayDataFromActive(sql);
		// 变量
		String orderId = null;
		Long status = null;
		Integer sign = 0;
		// 是否有满足条件记录
		if (vector.size() > 0) {
			String[] arr = (String[]) vector.get(0);
			orderId = arr[0];
			status = Long.valueOf((arr[1].isEmpty() != true ? arr[1] : "0"));
		} else {
			Equipment equipObj = FUNCTION.getEquipmentByName(equipName);
			String equipNameDes = equipObj.getDescription();
			// 处理车间片区描述
			String area = (String) equipObj.getUDA("area");
			String pline = (String) equipObj.getUDA("product_line");
			String areaDes = FUNCTION.getAreaByName(area).getDescription();
			String plineDes = FUNCTION.getProductionLineByName(pline).getDescription();
			// 没有SOS已创建的待执行记录，那么创建一条
			ATHandler atHandler = FUNCTION.createATHandler("EM_EquipReportAbnormal");
			ATRow atRow = atHandler.createATRow();
			orderId = autoMakeOrderId(); // 生成维修工单
			status = 10L;
			atRow.setValue("equip_id", equipName); // 保存设备编号
			atRow.setValue("equip_name", equipNameDes); // 保存设备名称
			atRow.setValue("area", areaDes); // 保存车间
			atRow.setValue("pline", plineDes); // 保存片区
			atRow.setValue("order_id", orderId); // 保存工单号
			atRow.setValue("order_status", status); // SOS创建的工单状态为10
			atRow.setValue("first_type_code", firstCodeStr); // 一级故障代码
			atRow.setValue("second_type_code", secondCodeStr); // 一级故障代码
			atRow.setValue("third_type_code", thirdCodeStr); // 一级故障代码
			atRow.setValue("first_type_str", getFaultBycode(firstCodeStr)); // 一级故障分类描述
			atRow.setValue("second_type_str", getFaultBycode(secondCodeStr)); // 二级故障分类描述
			atRow.setValue("third_type_str", getFaultBycode(thirdCodeStr)); // 三级故障分类描述
			atRow.setValue("created_by", userName);
			atRow.setValue("created_time", FUNCTION.getDBTime());
			if (StrUtil.isNotEmpty(cleanCycleNo)) {
				atRow.setValue("clean_cycle_no", cleanCycleNo);
			}
			Response resp = atRow.save(null, null, null);
			if (resp.isOk()) {
				sign = 1;
			}
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", orderId);
		map.put("status", status);
		map.put("sign", sign);
		return map;
	}
	
	// 根据代码获取描述
	public static String getFaultBycode(String faultCode) {
		String sql = "SELECT A.FAULT_DESCRIBE_S FROM AT_EM_EQUIPREPORTABNORML_ITEM A WHERE A.FAULT_CODE_S='" + faultCode
				+ "'";
		Vector vector = FUNCTION.getArrayDataFromActive(sql);
		String faultCodeDescription = null;
		if (vector.size() > 0) {
			faultCodeDescription = ((String[]) vector.get(0))[0];
		}
		return faultCodeDescription;
	}
	
	// 自动生成维修工单号
	public static String autoMakeOrderId() throws DatasweepException {
		// 处理时间
		Time today = FUNCTION.getDBTime();
		int year = today.getYear();
		int month = today.getMonth();
		int day = today.getDay();
		Time todayTime = FUNCTION.createTime(year, month, day);
		// 查询今天有几个工单号
		ATRowFilter filter = FUNCTION.createATRowFilter("EM_EquipReportAbnormal");
		filter.forColumnNameGreaterThanOrEqualTo("created_time", todayTime);
		long count = filter.getCount() + 1;
		// 拼接工单号字符串
		String orderID = "WX" + year + month + day;
		if (count < 10) {
			orderID = orderID + "00" + count;
		} else if (count < 100 && count >= 10) {
			orderID = orderID + "0" + count;
		} else {
			orderID = orderID + count;
		}
		return orderID;
	}


    /**
     * 获取硅片长度转重量系数
     * @param serialNo
     * @return
     */
    public static HashMap<String, Float> getRatioOrWeightBy(String serialNo){
        Lot lot = FUNCTION.getLotByName(serialNo);
        String partNumber = lot.getPartNumber();
        String sql = "SELECT p1.weight_piece_S AS length_ratio FROM part_uv p WHERE p.PART_NUMBER='"+partNumber+"' and p.WEIGHT_PIECE_S is not null";
        Vector vector = FUNCTION.getArrayDataFromActive(sql);
        float calRatio = 17.57f;
        if(vector.size()>0){
            Object[] arr = (Object[])vector.get(0);
			calRatio = Float.parseFloat((arr[0]).toString());
        }
		String sql1 = "SELECT p.weight_piece_S FROM part_uv p  LEFT JOIN part_uv p1 ON p.rod_partnum_S = p1.PART_NUMBER " +
				"WHERE p.PART_NUMBER = '"+partNumber+"' and p.WEIGHT_PIECE_S is not null";
		Vector vector1 = FUNCTION.getArrayDataFromActive(sql1);
		float weightPiece = 11.0f * 17.57f / calRatio;
		if(vector1.size()>0){
			Object[] arr = (Object[])vector1.get(0);
			calRatio = Float.parseFloat((arr[0]).toString());
		}
		HashMap<String,Float> map=new HashMap<String, Float>();
		map.put("weightPiece",weightPiece);
		map.put("calRatio",calRatio);
		return map;
    }
}
