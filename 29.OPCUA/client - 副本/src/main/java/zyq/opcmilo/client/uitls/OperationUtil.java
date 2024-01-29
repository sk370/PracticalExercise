package zyq.opcmilo.client.uitls;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OperationUtil {

	private static Logger operationLog = LoggerFactory.getLogger(OperationUtil.class);

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
//		ATHandler atHandler = FUNCTION.createATHandler("OM_Operation_Log");
//		ATRow atRow = atHandler.createATRow();
//		atRow.setValue("host",host);
//	    atRow.setValue("level",level);
//	    atRow.setValue("entry_time",FUNCTION.getDBTime());
//	    atRow.setValue("source",className);
//	    atRow.setValue("trx_name",FunctionName);
//	    atRow.setValue("user",userName);
//	    atRow.setValue("content",message);
//	    atRow.save(null,null,null);
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
//		ATHandler atHandler = FUNCTION.createATHandler("OM_Log");
//		ATRow atRow = atHandler.createATRow();
//		atRow.setValue("source",className); //日志主体：界面、类等
//		atRow.setValue("trx_name",functionName); //对应的事务、功能
//		atRow.setValue("user",userName); //作业员
//		atRow.setValue("level",level); //日志等级
//		atRow.setValue("entry_time",FUNCTION.getDBTime()); //日志时间
//		atRow.setValue("host",hostIp);  //主机IP
//	    atRow.setValue("content",message); //日志内容
//	    atRow.save(null,null,null);
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
}
