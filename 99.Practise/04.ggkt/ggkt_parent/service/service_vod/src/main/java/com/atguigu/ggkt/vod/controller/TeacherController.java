package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-12
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping(value = "/admin/vod/teacher")
//@CrossOrigin//与网关跨域同时使用会导致失效
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public Result findAllTeacher() {
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(@ApiParam(name = "id", value = "ID", required = true)
                                @PathVariable("id") long id) {
        boolean isSuccess = teacherService.removeById(id);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    /**
     * @param current
     * @param limit
     * @param teacherQueryVo 查询条件，null表示没有条件，即查询所有
     * @return
     */
    @ApiOperation("条件查询分页")
    @GetMapping("findQueryPage/{current}/{limit}")
    public Result findPage(@PathVariable Long current,
                           @PathVariable Long limit,
                           TeacherQueryVo teacherQueryVo) {//@RequestBody(required = false) TeacherQueryVo teacherQueryVo)接收json数据格式，封装成java实体；false表示条件值可以为空；@RequestBody要配合post提交使用,即@PostMapping
//        System.out.println(teacherQueryVo);
        Page<Teacher> pageParam = new Page<>(current, limit);
        if (teacherQueryVo == null) {
            IPage<Teacher> page = teacherService.page(pageParam, null);
            return Result.ok(page);
        } else {
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();
            // 通过查询条件构造条件查询器
            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!StringUtils.isEmpty(level)) {
                wrapper.eq("level", level);//等于
            }
            if (!StringUtils.isEmpty(joinDateBegin)) {
                wrapper.ge("joinDateBegin", joinDateBegin);//大于等于
            }
            if (!StringUtils.isEmpty(joinDateEnd)) {
                wrapper.le("joinDateEnd", joinDateEnd);//小于等于
            }

            IPage<Teacher> page = teacherService.page(pageParam, wrapper);
            return Result.ok(page);
        }
    }

    @ApiOperation("添加讲师")
    @PostMapping("saveTeacher")
    public Result saveTeacher(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.save(teacher);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation("查询讲师")
    @GetMapping("getTeacher/{id}")
    public Result getTeacher(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    @ApiOperation("修改讲师")
    @PostMapping("updateTeacher")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    /**
     * 课程页面搜索栏下列列表使用
     * @param idList
     * @return
     */
    @ApiOperation("批量删除讲师")
    @DeleteMapping("removeBatch")
    public Result removeBatch(@RequestBody List<Long> idList){//RequestBody将前端发送的数组形式json数据进行转换
        boolean isSuccess = teacherService.removeByIds(idList);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }
}

