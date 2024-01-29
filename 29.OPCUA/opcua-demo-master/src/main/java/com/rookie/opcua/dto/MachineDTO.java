package com.rookie.opcua.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MachineDTO implements Serializable {
    private String EquipmentName;
    private String EquipmentNo;
    private String Operator;
    private Long RotateSpeed;
    private Float Temperature;
}
