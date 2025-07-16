package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据vue-admin-template创建登录接口
 * vue-admin-template原本使用mock-server.js创建的虚拟后台服务器
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/15 17:54
 */
@RestController
@RequestMapping("admin/vod/user")
//@CrossOrigin//与网关跨域同时使用会导致失效
@Api(tags = "用户登录接口")
public class UserLoginController {
    @PostMapping("login")
    public Result login(){
        //vue-admin-template的返回json数据：{"code":20000,"data":{"token":"admin-token"}},
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }

    @GetMapping("info")
    public Result info(){
        //vue-admin-template的返回json数据：{"code":20000,"data":{"roles":["admin"],"introduction":"I am a super administrator","avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif","name":"Super Admin"}}
        Map<String, Object> map = new HashMap<>();
        map.put("roles","admin");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        return Result.ok(map);

    }

}
