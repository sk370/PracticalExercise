package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vo.vod.CourseFormVo;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.atguigu.ggkt.vo.vod.CourseQueryVo;
import com.atguigu.ggkt.vo.vod.CourseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
public interface CourseService extends IService<Course> {

    Map<String, Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    Long saveCourseInfo(CourseFormVo courseFormVo);

    CourseFormVo getCourseInfoById(Long id);

    Long updateCourseId(CourseFormVo courseFormVo);

    CoursePublishVo getCoursePublishVo(Long id);

    void publishCourse(Long id);

    void removeCourseById(Long id);

    /**
     * 根据课程分类id查询课程（微信页）
     * @param pageParam
     * @param courseQueryVo
     * @return
     */
    Map<String, Object> findPageWechat(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    /**
     * 根据id查询课程（微信页）
     * @param courseId
     * @return
     */
    Map<String, Object> getInfoById(Long courseId);
}
