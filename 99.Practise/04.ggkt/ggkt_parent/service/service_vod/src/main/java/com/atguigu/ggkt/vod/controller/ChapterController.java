package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vod.service.ChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程大纲(章节、小节) 前端控制器
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
@RestController
@RequestMapping("/admin/vod/chapter")
//@CrossOrigin//与网关跨域同时使用会导致失效
@Api(tags = "课程大纲接口")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @ApiOperation("大纲列表")
    @GetMapping("getNestedTreeList/{courseId}")
    public Result getTreeList(@PathVariable Long courseId){
        List<ChapterVo> list = chapterService.getTreeList(courseId);
        return Result.ok(list);
    }

    @ApiOperation(("添加章节"))
    @PostMapping("save")
    public Result save(@RequestBody Chapter chapter){
        chapterService.save(chapter);
        return Result.ok(null);
    }

    @ApiOperation("根据ID查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Chapter chapter = chapterService.getById(id);
        return Result.ok(chapter);
    }

    @ApiOperation("根据ID修改")
    @PostMapping("update")
    public Result update(@RequestBody Chapter chapter){
        chapterService.updateById(chapter);
        return Result.ok(null);
    }
    // 老师的这个方法不完善，删除章节的时候没有删除视频
//    @ApiOperation("根据ID删除")
//    @DeleteMapping("remove/{id}")
//    public Result remove(@PathVariable Long id){
//        chapterService.removeById(id);
//        return Result.ok(null);
//    }

    /**
     * 删除章节：删除章节、删除小节、删除视频
     * @param id
     * @return
     */
    @ApiOperation("根据ID删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        chapterService.removeChapterById(id);
        return Result.ok(null);
    }
}

