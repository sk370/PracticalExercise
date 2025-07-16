package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.model.vod.CourseDescription;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vo.vod.*;
import com.atguigu.ggkt.vod.mapper.CourseMapper;
import com.atguigu.ggkt.vod.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private CourseDescriptionService descriptionService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private VideoService videoService;

    @Override
    public Map<String, Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo) {
        String title = courseQueryVo.getTitle();
        Long subjectId = courseQueryVo.getSubjectId();
        Long subjectParentId = courseQueryVo.getSubjectParentId();
        Long teacherId = courseQueryVo.getTeacherId();
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(title)) {
            wrapper.like("title", title);
        }
        if(!StringUtils.isEmpty(subjectId)) {
            wrapper.eq("subject_id",subjectId);
        }
        if(!StringUtils.isEmpty(subjectParentId)) {
            wrapper.eq("subject_parent_id",subjectParentId);
        }
        if(!StringUtils.isEmpty(teacherId)) {
            wrapper.eq("teacher_id",teacherId);
        }
        Page<Course> coursePage = baseMapper.selectPage(pageParam, wrapper);//获得course表中的数据
        long totalCount = coursePage.getTotal();
        long totalPage = coursePage.getPages();

        List<Course> list = coursePage.getRecords();
        list.stream().forEach(item -> {
            this.getNameById(item);
        });
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount",totalCount);
        map.put("totalPage",totalPage);
        map.put("records",list);
        return map;
    }

    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo) {
        // 1. 添加课程基本信息：操作course表
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);
        // 2. 添加课程描述信息：操作course_description表
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());
        courseDescription.setCourseId(course.getId());
        courseDescription.setId(course.getId());//手动设置主键，将两个表的主键设置成一样
        descriptionService.save(courseDescription);

        return course.getId();
    }

    @Override
    public CourseFormVo getCourseInfoById(Long id) {
        Course course = baseMapper.selectById(id);//课程基本信息
        if(course == null){
            return null;
        }
        CourseFormVo courseFormVo = new CourseFormVo();// 封装courseFormVO用于数据回显
        BeanUtils.copyProperties(course, courseFormVo);

        CourseDescription courseDescription = descriptionService.getById(id);//课程描述信息
        if(courseDescription != null){
            courseFormVo.setDescription(courseDescription.getDescription());
        }

        return courseFormVo;
    }

    @Override
    public Long updateCourseId(CourseFormVo courseFormVo) {
        // 1. 修改课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo,course);
        baseMapper.updateById(course);
        Long courseId = course.getId();

        // 2. 修改课程的描述信息
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());
        courseDescription.setId(courseId);
        descriptionService.updateById(courseDescription);

        return courseId;
    }

    @Override
    public CoursePublishVo getCoursePublishVo(Long id) {
        return baseMapper.selectCoursePublishVoById(id);
    }

    @Override
    public void publishCourse(Long id) {
        Course course = baseMapper.selectById(id);
        course.setStatus(1);// 修改课程的状态
        course.setPublishTime(new Date());
        baseMapper.updateById(course);
    }

    @Override
    public void removeCourseById(Long id) {
        // 1. 根据课程id删除小节
        videoService.removeVideoByCourseId(id);
        // 2. 根据课程id删除章节
        chapterService.removeChapterByCourseId(id);
        // 3. 根据课程id删除课程描述
        descriptionService.removeById(id);//课程描述的id和课程的id一样
        // 4. 根据课程id删除课程
        baseMapper.deleteById(id);
    }

    @Override
    public Map<String, Object> findPageWechat(Page<Course> pageParam, CourseQueryVo courseQueryVo) {
        //获取条件值
        String title = courseQueryVo.getTitle();//名称
        Long subjectId = courseQueryVo.getSubjectId();//二级分类
        Long subjectParentId = courseQueryVo.getSubjectParentId();//一级分类
        Long teacherId = courseQueryVo.getTeacherId();//讲师
        //封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(title)) {
            wrapper.like("title",title);
        }
        if(!StringUtils.isEmpty(subjectId)) {
            wrapper.eq("subject_id",subjectId);
        }
        if(!StringUtils.isEmpty(subjectParentId)) {
            wrapper.eq("subject_parent_id",subjectParentId);
        }
        if(!StringUtils.isEmpty(teacherId)) {
            wrapper.eq("teacher_id",teacherId);
        }
        //调用方法查询
        Page<Course> pages = baseMapper.selectPage(pageParam, wrapper);

        long totalCount = pages.getTotal();//总记录数
        long totalPage = pages.getPages();//总页数
        long currentPage = pages.getCurrent();//当前页
        long size = pages.getSize();//每页记录数
        //每页数据集合
        List<Course> records = pages.getRecords();
        records.stream().forEach(item -> {
            this.getTeacherOrSubjectName(item);
        });

        Map<String,Object> map = new HashMap<>();
        map.put("totalCount",totalCount);
        map.put("totalPage",totalPage);
        map.put("records",records);

        return map;
    }

    /**
     * 获取讲师和课程名称
     * @param course
     */
    private Course getTeacherOrSubjectName(Course course) {
        Teacher teacher = teacherService.getById(course.getTeacherId());
        if(teacher != null) {
            course.getParam().put("teacherName",teacher.getName());
        }

        Subject subjectOne = subjectService.getById(course.getSubjectParentId());
        if(subjectOne != null) {
            course.getParam().put("subjectParentTitle",subjectOne.getTitle());
        }
        Subject subjectTwo = subjectService.getById(course.getSubjectId());
        if(subjectTwo != null) {
            course.getParam().put("subjectTitle",subjectTwo.getTitle());
        }
        return course;
    }

    @Override
    public Map<String, Object> getInfoById(Long courseId) {
        //更新浏览量
        Course course = baseMapper.selectById(courseId);
        course.setViewCount(course.getViewCount() + 1);
        baseMapper.updateById(course);

        CourseVo courseVo = baseMapper.selectCourseVoById(courseId);//自定义方法：课程详情
        List<ChapterVo> chapterVoList = chapterService.getTreeList(courseId);//自定义方法：课程章节、小节信息
        CourseDescription courseDescription = descriptionService.getById(courseId);//课程描述信息
        Teacher teacher = teacherService.getById(course.getTeacherId());//课程教师信息

        // TODO 后续完善
        Boolean isBuy = false;

        Map<String, Object> map = new HashMap<>();
        map.put("courseVo", courseVo);
        map.put("chapterVoList", chapterVoList);
        map.put("description", null != courseDescription ?
                courseDescription.getDescription() : "");
        map.put("teacher", teacher);
        map.put("isBuy", isBuy);//是否购买
        return map;
    }

    /**
     * 为了满足前台显示的数据类型，定义一个方法
     * @param item
     * @return
     */
    private Course getNameById(Course item) {
        Teacher teacher = teacherService.getById(item.getTeacherId());
        if(teacher != null){
            String name = teacher.getName();
            item.getParam().put("teacherName", name);//param属性是baseEntity定义的map类型的属性
        }
        Subject subjectOne = subjectService.getById(item.getSubjectParentId());
        if(subjectOne != null){
            item.getParam().put("subjectParentTitle", subjectOne.getTitle());
        }
        Subject subjectTwo = subjectService.getById(item.getSubjectId());
        if(subjectTwo != null) {
            item.getParam().put("subjectTitle",subjectTwo.getTitle());
        }
        return item;
    }
}
