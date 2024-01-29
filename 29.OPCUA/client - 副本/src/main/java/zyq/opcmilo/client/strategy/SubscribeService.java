package zyq.opcmilo.client.strategy;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;

/**
 * 订阅接口
 * @author chenxi21
 *
 */
public interface SubscribeService {
	
	//订阅处理
	void subscribeHandle(OpcUaClient client, String subLabel, String valueStr);

}
