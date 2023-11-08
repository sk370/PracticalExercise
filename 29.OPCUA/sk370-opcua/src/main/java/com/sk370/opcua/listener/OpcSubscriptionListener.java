package zyq.opcmilo.client.context;

import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscription;
import org.eclipse.milo.opcua.sdk.client.api.subscriptions.UaSubscriptionManager.SubscriptionListener;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpcSubscriptionListener implements SubscriptionListener{

	private static Logger log = LoggerFactory.getLogger(OpcSubscriptionListener.class);

	private volatile static OpcSubscriptionListener listener;
	
	private OpcSubscriptionListener(){};
	
	public static OpcSubscriptionListener getListener() {
		if (listener == null) {
			synchronized (OpcSubscriptionListener.class) {
				if (listener == null) {
					listener = new OpcSubscriptionListener();
				}
			}
		}
		return listener;
	}

//	@Override
//	public void onKeepAlive(UaSubscription subscription, DateTime publishTime) {
//		log.info("opcUa监听：onKeepAlive（连接存活中）");
//	}

	@Override
	public void onNotificationDataLost(UaSubscription subscription) {
		log.info("opcUa监听：onNotificationDataLost（数据丢失）");
	}

	@Override
	public void onPublishFailure(UaException exception) {
		log.info("opcUa监听：onPublishFailure（连接断开）");
	}

	@Override
	public void onStatusChanged(UaSubscription subscription, StatusCode status) {
		log.info("opcUa监听：onStatusChanged（连接状态改变）");
	}

	@Override
	public void onSubscriptionTransferFailed(UaSubscription subscription, StatusCode statusCode) {
		log.info("opcUa监听：onSubscriptionTransferFailed（恢复订阅失败 需要重新订阅）");
	}
	
}
