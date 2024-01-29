package com.sk370.opcua.controller;

import com.sk370.opcua.dto.ResponseDTO;
import com.sk370.opcua.dto.ServerStatusDTO;
import com.sk370.opcua.dto.SimulationDTO;
import com.sk370.opcua.service.ReadDeviceService;
import com.sk370.opcua.support.OpcUaOperationSupport;
import com.sk370.opcua.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yugo
 */
@RestController
@RequestMapping("/opc-ua")
@Api(value = "opcua 协议接口", tags = "opcua 信息模型查看接口")
@AllArgsConstructor
public class OpcUaController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private OpcUaOperationSupport opcUaOperationSupport;

    private final ReadDeviceService readDeviceService;

    @GetMapping("/get/server/status")
    @ApiOperation(value = "获取服务节点状态", notes = "获取服务节点状态")
    public ServerStatusDTO getServerStatus() {
        return JsonUtils.jsonToBean(redisTemplate.opsForValue().get("SERVER_NODE").toString(), ServerStatusDTO.class);
    }

    @GetMapping("/get/simulation/list")
    @ApiOperation(value = "获取服务节点状态", notes = "获取服务节点状态")
    public List<SimulationDTO> getSimulationList() {
        return JsonUtils.jsonToList(redisTemplate.opsForValue().get("SIMULATION").toString(), SimulationDTO.class);
    }

    @GetMapping("/write/node/value")
    @ApiOperation(value = "写入数据", notes = "写入数据")
    public String writeValue() {
        try {
            opcUaOperationSupport.writeNodeValue();
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @GetMapping("/browse/node")
    public String browseNode() {
        try {
            opcUaOperationSupport.browseNode();
            return "success";
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/subscription")
    public String createSubscription() {
        try {
            opcUaOperationSupport.createSubscription();
            return "success";
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/history")
    public List historyRead() {
        try {
            return opcUaOperationSupport.historyRead();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/device")
    public ResponseDTO getDevice(String name) {
        try {
            return ResponseDTO.ok(readDeviceService.getNodeStructure(name));
        } catch (Exception e) {
            return ResponseDTO.failed();
        }
    }
}
