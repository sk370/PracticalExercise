package zyq.opcmilo.client.pojo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
//@Table(name = "VirtualMachine")
public class VirtualMachine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String EquipNo;
    private String EquipName;
    private Integer RotateSpeed;
    private Float Temperature;
    private Timestamp CreatedTime;
    private String CreatedBy;
    private Timestamp UpdatedTime;
    private String UpdatedBy;
}
