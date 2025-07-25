package com.sk370.opcua.controller;

import com.sk370.opcua.dto.ResponseDTO;
import com.sk370.opcua.websocket.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/websocket")
public class WebSocketController {

    @GetMapping("/index")
    public ModelAndView socket() {
        return new ModelAndView("/index");
    }
    @ResponseBody
    @RequestMapping("/push")
    public ResponseDTO pushToWeb(String message) {
        try {
            WebSocketServer.sendInfo(message);
            return ResponseDTO.ok("推送成功");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseDTO.failed(e.getMessage());
        }
    }
}
