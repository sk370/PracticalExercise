package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.atguigu.ggkt.vo.vod.CourseVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
public interface CourseMapper extends BaseMapper<Course> {
    /**
     * 自定义查询方法：根据id查询coourse、teacher、chapter三个表
     * @param id
     * @return
     */
    CoursePublishVo selectCoursePublishVoById(Long id);
    /**
     * 自定义查询方法：根据courseId查询coourse、teacher、chapter三个表
     * @param courseId
     * @return
     */
    CourseVo selectCourseVoById(Long courseId);
}
