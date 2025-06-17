package com.sk370.opcua.controller;

import com.sk370.opcua.dto.ResponseDTO;
import com.sk370.opcua.service.ReadDeviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read")
@AllArgsConstructor
public class ReadNodeController {

    private final ReadDeviceService readDeviceService;

    @GetMapping("/init")
    public void init() {
        readDeviceService.initNode();
    }

    @GetMapping("/node")
    public ResponseDTO getNode(String groupName) {
        return readDeviceService.getNodeStructure(groupName);
    }
}
