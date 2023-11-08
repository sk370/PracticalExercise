package com.xxmes.opcapp.model.opc;

/**
 * @author by CX
 * @Classname LableEntity
 * @Description 标签实体类
 * @Date 2022/9/9 11:09
 */
public class LabelEntity {
	
	/** 标签名 **/
    private String labelName;

    /** 标签值" **/
    private Object labelValue;

    /** 标签数据类型 **/
    private String type;

    /** 命名空间 **/
    private Integer nameSpace;
 
	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Object getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(Object labelValue) {
		this.labelValue = labelValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(Integer nameSpace) {
		this.nameSpace = nameSpace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((labelName == null) ? 0 : labelName.hashCode());
		result = prime * result + ((labelValue == null) ? 0 : labelValue.hashCode());
		result = prime * result + ((nameSpace == null) ? 0 : nameSpace.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LabelEntity other = (LabelEntity) obj;
		if (labelName == null) {
			if (other.labelName != null)
				return false;
		} else if (!labelName.equals(other.labelName))
			return false;
		if (labelValue == null) {
			if (other.labelValue != null)
				return false;
		} else if (!labelValue.equals(other.labelValue))
			return false;
		if (nameSpace == null) {
			if (other.nameSpace != null)
				return false;
		} else if (!nameSpace.equals(other.nameSpace))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
    
    

}
