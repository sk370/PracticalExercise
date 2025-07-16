package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.utils.ConstantPropertiesUtil;
import com.atguigu.ggkt.utils.VodSignature;
import com.atguigu.ggkt.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * 腾讯云视频点播
 *
 * @author zhuyuqi
 * @version v0.0.1
 * @className VodController
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/15 17:20
 */
@RestController
@Api(tags = "腾讯云点播")
@RequestMapping("admin/vod")
//@CrossOrigin//与网关跨域同时使用会导致失效
public class VodController {
    @Autowired
    private VodService vodService;

    @ApiOperation("客户端上传视频：获取签名")
    @GetMapping("sign")
    public Result sign() {
        VodSignature sign = new VodSignature();//工具类
        // 设置 App 的云 API 密钥
        sign.setSecretId(ConstantPropertiesUtil.ACCESS_KEY_ID);
        sign.setSecretKey(ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
        sign.setSignValidDuration(3600 * 24 * 2); // 签名有效期：2天
        try {
            String signature = sign.getUploadSignature();
            System.out.println("signature : " + signature);
            return Result.ok(signature);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GgktException(20001,"获取签名失败");
        }
    }

    @ApiOperation("服务端上传视频（视频路径只能在代码中写死）")
    @PostMapping("upload")
    public Result upload() {
        String fileId = vodService.uploadVideo();
        return Result.ok(fileId);
    }

    @ApiOperation("删除腾讯云中的视频")
    @DeleteMapping("remove/{fileId}")
    public Result remove(@PathVariable String fileId) {
        vodService.removeVideo(fileId);
        return Result.ok(null);
    }
}
