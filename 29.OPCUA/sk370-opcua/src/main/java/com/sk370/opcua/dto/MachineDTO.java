package com.sk370.opcua.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用于kepserverex的序列化实体类。生产环境中，可根据业务场景的访问内容进行修改。
 *
 * @author sk370
 */
@Data
public class MachineDTO implements Serializable {
    /**
     * 设备名称
     */
    private String EquipmentName;
    /**
     * 设备编号
     */
    private String EquipmentNo;
    /**
     * 操作者
     */
    private String Operator;
    /**
     * 转速
     */
    private Long RotateSpeed;
    /**
     * 温度
     */
    private Float Temperature;
}
