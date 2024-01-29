package com.sk370.opcua.opc;

import java.util.List;

public class LabelDetail {
	
	/** 设备号 **/
	private String device;
	
	/** 读标签集合 **/
	private List<String> readLabels;
	
	/** 写标签集合 **/
	private List<LabelEntity> writeLabels;
	
	/** 标签所属种类（0：心跳） **/
    private Integer labelType;
    
    /** 命名空间 **/
    private Integer nameSpace;
    
    /** 监控参数时间间隔 **/
    private Double interval;

	public List<String> getReadLabels() {
		return readLabels;
	}

	public void setReadLabels(List<String> readLabels) {
		this.readLabels = readLabels;
	}

	public List<LabelEntity> getWriteLabels() {
		return writeLabels;
	}

	public void setWriteLabels(List<LabelEntity> writeLabels) {
		this.writeLabels = writeLabels;
	}

	public Integer getLabelType() {
		return labelType;
	}

	public void setLabelType(Integer labelType) {
		this.labelType = labelType;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Integer getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(Integer nameSpace) {
		this.nameSpace = nameSpace;
	}

	public Double getInterval() {
		return interval;
	}

	public void setInterval(Double interval) {
		this.interval = interval;
	}
    
    

}
