package com.sk370.opcua.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Prosys OPC UA Simulation Server软件中配置的调试节点实体
 *
 * @author sk370
 */
@Data
public class SimulationDTO implements Serializable {

    private String counter;

    private String expression;

    private String random;

    private String sawtooth;

    private String sinusoid;

    private String square;

    private String triangle;

}
