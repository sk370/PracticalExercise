package com.xxmes.opcapp.model.opc;

import java.util.List;


/**
 * 配置信息子类
 * @author chenxi21
 *
 */
public class ConfigInfoSub {

	/** 通道 **/
	private String channel;
	
	/** 设备编号集合 **/
	private String device;
	
	/** 命名空间 **/
	private Integer namespace;
	
	/** 后缀 **/
	private List<String> suffixs;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public List<String> getSuffixs() {
		return suffixs;
	}

	public void setSuffixs(List<String> suffixs) {
		this.suffixs = suffixs;
	}

	public Integer getNamespace() {
		return namespace;
	}

	public void setNamespace(Integer namespace) {
		this.namespace = namespace;
	}

	
}
