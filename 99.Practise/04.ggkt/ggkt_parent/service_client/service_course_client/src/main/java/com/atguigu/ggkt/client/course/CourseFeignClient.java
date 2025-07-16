package com.atguigu.ggkt.client.course;

import com.atguigu.ggkt.model.vod.Course;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zhuyuqi
 * @version v2.0
 * @interfaceName CourseFeignClient
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/17 20:00
 */
@FeignClient(value = "service-vod")
public interface CourseFeignClient {
    @ApiOperation("根据关键字查询课程")
    @GetMapping("api/vod/course/inner/findByKeyword/{keyword}")
    public List<Course> findByKeyword(
            @ApiParam(value = "关键字", required = true)
            @PathVariable String keyword);

    @ApiOperation("根据ID查询课程")
    @GetMapping("inner/getById/{courseId}")
    public Course getById(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long courseId);
}
