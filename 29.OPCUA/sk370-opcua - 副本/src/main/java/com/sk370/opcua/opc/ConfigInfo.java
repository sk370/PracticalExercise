package com.sk370.opcua.opc;

import java.util.List;

/**
 * @description: 配置信息实体
 */
public class ConfigInfo {
	
	/** 连接端点 **/
	private String endpoint;
	
	/** 用戶 **/
    private List<String> user;
    
    /** 监控参数时间间隔 **/
    private Double samplingInterval;
	
	/** 订阅标签 **/
	private List<ConfigInfoSub> subscription;

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public List<ConfigInfoSub> getSubscription() {
		return subscription;
	}

	public void setSubscription(List<ConfigInfoSub> subscription) {
		this.subscription = subscription;
	}

	public List<String> getUser() {
		return user;
	}

	public void setUser(List<String> user) {
		this.user = user;
	}

	public Double getSamplingInterval() {
		return samplingInterval;
	}

	public void setSamplingInterval(Double samplingInterval) {
		this.samplingInterval = samplingInterval;
	}

}
