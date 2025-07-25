package com.sk370.opcua.service;

import com.sk370.opcua.dto.ResponseDTO;

/**
 * @author yugo
 */
public interface ReadDeviceService {
    /**
     * 初始化节点
     */
    void initNode();

    /**
     * 获取节点结构
     *
     * @param groupName 分组名称
     * @return ResponseDTO
     */
    ResponseDTO getNodeStructure(String groupName);
}
