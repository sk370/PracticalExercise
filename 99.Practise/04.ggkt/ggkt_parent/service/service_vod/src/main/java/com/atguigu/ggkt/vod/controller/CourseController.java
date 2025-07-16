package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.CourseFormVo;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.atguigu.ggkt.vo.vod.CourseQueryVo;
import com.atguigu.ggkt.vod.service.CourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.statement.select.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
@RestController
@RequestMapping("admin/vod/course")
//@CrossOrigin//与网关跨域同时使用会导致失效
@Api(tags = "点播管理接口")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @ApiOperation("根据ID获取课程信息")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        CourseFormVo courseFormVo = courseService.getCourseInfoById(id);
        return Result.ok(courseFormVo);
    }

    @ApiOperation("修改指定课程信息")
    @PostMapping("update")
    public Result update(@RequestBody CourseFormVo courseFormVo){
        Long courseId = courseService.updateCourseId(courseFormVo);
        return Result.ok(courseId);
    }

    @ApiOperation("添加课程基本信息")
    @PostMapping("save")
    public  Result save(@RequestBody CourseFormVo courseFormVo){
        Long courseId = courseService.saveCourseInfo(courseFormVo);//操作comment、course_collect、course_description都需要这个id
        return Result.ok(courseId);
    }

    @ApiOperation("点播课程列表")
    @GetMapping("{page}/{limit}")
    public Result courseList(@PathVariable Long page,
                             @PathVariable Long limit,
                            CourseQueryVo courseQueryVo){
        Page<Course> pageParam = new Page<>(page,limit);
        Map<String,Object> map = courseService.findPage(pageParam, courseQueryVo);
        return Result.ok(map);
    }

    @ApiOperation("根据课程id查询发布课程信息（发布前确认信息）")
    @GetMapping("getCoursePublishVo/{id}")
    public Result getCoursePublishVo(@PathVariable Long id){
        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);//自定义查询方法
        return Result.ok(coursePublishVo);
    }

    @ApiOperation("课程的最终发布（修改课程状态）")
    @PutMapping("publishCourse/{id}")
    public Result publishCourse(@PathVariable Long id){
        courseService.publishCourse(id);//自定义查询方法
        return Result.ok(null);
    }

    @ApiOperation("删除课程")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        courseService.removeCourseById(id);
        return Result.ok(null);
    }
}

