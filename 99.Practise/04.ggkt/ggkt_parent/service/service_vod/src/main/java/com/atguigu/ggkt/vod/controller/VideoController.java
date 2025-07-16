package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
@RestController
@RequestMapping("/admin/vod/video")
//@CrossOrigin//与网关跨域同时使用会导致失效
@Api(tags = "小节接口")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @ApiOperation("获取课程")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Video video = videoService.getById(id);
        return Result.ok(video);
    }

    @ApiOperation("新增课程")
    @PostMapping("save")
    public Result save(@RequestBody Video video){
        videoService.save(video);
        return Result.ok(null);
    }

    @ApiOperation("修改课程")
    @PutMapping("update")
    public Result update(@RequestBody Video video){
        videoService.updateById(video);
        return Result.ok(null);
    }

    @ApiOperation("删除课程")
    @DeleteMapping("remove/{id}")
    public Result update(@PathVariable Long id){
        videoService.removeVideoById(id);//删除小节同时删除视频
        return Result.ok(null);
    }
}

