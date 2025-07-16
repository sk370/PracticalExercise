package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vod.mapper.VideoMapper;
import com.atguigu.ggkt.vod.service.VideoService;
import com.atguigu.ggkt.vod.service.VodService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
    @Autowired
    private VodService vodService;

    /**
     * 删除课程：删除视频、删除小节、删除课程
     * @param id 课程id
     */
    @Override
    public void removeVideoByCourseId(Long id) {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", id);
        List<Video> videoList = baseMapper.selectList(queryWrapper);//查到该课程下所有小节
        for (Video video : videoList ){
            String videoSourceId = video.getVideoSourceId();//获取小节的视频名
            if(!StringUtils.isEmpty(videoSourceId)){//有的小节没有视频，所以要判断
                vodService.removeVideo(videoSourceId);//删除视频
            }
        }

        baseMapper.delete(queryWrapper);//删除所有小节
    }

    /**
     * 删除小节：删除视频、删除小节
     * @param id 小节id
     */
    @Override
    public void removeVideoById(Long id) {
        Video video = baseMapper.selectById(id);
        String videoSourceId = video.getVideoSourceId();//获取视频名
        if(!StringUtils.isEmpty(videoSourceId)){//有的小节没有视频，所以要判断
            vodService.removeVideo(videoSourceId);//删除视频
        }
        baseMapper.deleteById(id);//删除小节
    }
}
