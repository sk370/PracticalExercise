package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VideoVisitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 视频来访者记录表 前端控制器
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-09-15
 */
@RestController
@RequestMapping("/admin/vod/videoVisitor")
//@CrossOrigin//与网关跨域同时使用会导致失效
@Api(tags = "观看人数接口")
public class VideoVisitorController {
    @Autowired
    private VideoVisitorService videoVisitorService;

    @ApiOperation("观看人数统计")
    @GetMapping("findCount/{courseId}/{startDate}/{endDate}")
    public Result findCount(@PathVariable Long courseId,@PathVariable String startDate, @PathVariable String endDate){
        Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
        System.out.println(map.toString());
        return Result.ok(map);
    }
}

