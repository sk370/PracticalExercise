package com.atguigu.ggkt.vod.api;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className VodApiController
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/18 16:54
 */
@Api(tags = "腾讯视频点播")
@RestController
@RequestMapping("/api/vod")
public class VodApiController {

    @Autowired
    private VodService vodService;

    @GetMapping("getPlayAuth/{courseId}/{videoId}")
    public Result getPlayAuth(
            @ApiParam(value = "课程id", required = true)
            @PathVariable Long courseId,
            @ApiParam(value = "小节id", required = true)
            @PathVariable Long videoId) {
        Map<String, Object> map = vodService.getPlayAuth(courseId, videoId);//获取视频播放凭证
        return  Result.ok(map);
    }
}
