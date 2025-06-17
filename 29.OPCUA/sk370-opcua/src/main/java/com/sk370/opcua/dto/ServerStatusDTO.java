package com.sk370.opcua.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * OPCUA协议数据节点的状态实体
 *
 * @author sk370
 */
@Data
public class ServerStatusDTO implements Serializable {

    private String serverArray;

    private Date startTime;

    private Date currentTime;

    private String state;
}
