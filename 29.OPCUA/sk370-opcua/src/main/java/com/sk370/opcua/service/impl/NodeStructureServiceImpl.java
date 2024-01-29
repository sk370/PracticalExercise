package com.sk370.opcua.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sk370.opcua.entity.NodeStructure;
import com.sk370.opcua.mapper.NodeStructureMapper;
import com.sk370.opcua.service.NodeStructureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author yugo
 * 2019-07-03
 */
@Service
@AllArgsConstructor
public class NodeStructureServiceImpl extends ServiceImpl<NodeStructureMapper, NodeStructure> implements NodeStructureService {


}
