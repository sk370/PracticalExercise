package com.sk370.opcua.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@ToString(callSuper = true)
@TableName("virtual_machine")
public class VirtualMachine implements Serializable {
    @TableField("id")
    private Integer id;
    @TableField("equip_no")
    private String equipNo;
    @TableField("equip_name")
    private String equipName;
    @TableField("rotate_speed")
    private Integer rotateSpeed;
    @TableField("temperature")
    private Float temperature;
    @TableField("create_time")
    private Timestamp createdTime;
    @TableField("created_by")
    private String createdBy;
    @TableField("updated_time")
    private Timestamp updatedTime;
    @TableField("updated_by")
    private String updatedBy;
}
