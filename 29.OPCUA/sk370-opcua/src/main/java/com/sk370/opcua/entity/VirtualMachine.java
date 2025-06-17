package com.sk370.opcua.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用于kepserverex的对象访问实体类。生产环境中，可根据业务场景的访问内容进行修改。
 *
 * @author sk370
 */
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
    private Timestamp createTime;
    @TableField("created_by")
    private String createdBy;
    @TableField("updated_time")
    private Timestamp updatedTime;
    @TableField("updated_by")
    private String updatedBy;
}
