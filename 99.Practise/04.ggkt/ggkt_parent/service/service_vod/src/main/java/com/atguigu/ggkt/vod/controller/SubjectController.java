package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
@RestController
@Api(tags = "课程分类接口")
@RequestMapping("/admin/vod/subject")
//@CrossOrigin//与网关跨域同时使用会导致失效
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 课程页面上部搜索栏下拉列表使用
     * @param id
     * @return
     */
    @ApiOperation("课程分类列表")
    @GetMapping("getChildSubject/{id}")
    public Result getChildSubject(@PathVariable Long id){
        List<Subject> list = subjectService.selecetSubjectList(id);
        return Result.ok(list);
    }

    @ApiOperation(value="导出")
    @GetMapping(value = "/exportData")
    public void exportData(HttpServletResponse response) {
        subjectService.exportData(response);
    }

    @ApiOperation(value="导入")
    @PostMapping(value = "/importData")
    public void importData(MultipartFile file) {
        subjectService.importData(file);
    }
}

