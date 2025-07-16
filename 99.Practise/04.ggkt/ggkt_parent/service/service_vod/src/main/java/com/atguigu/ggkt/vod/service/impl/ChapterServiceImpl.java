package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vo.vod.VideoVo;
import com.atguigu.ggkt.vod.mapper.ChapterMapper;
import com.atguigu.ggkt.vod.mapper.VideoMapper;
import com.atguigu.ggkt.vod.service.ChapterService;
import com.atguigu.ggkt.vod.service.VideoService;
import com.atguigu.ggkt.vod.service.VodService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Autowired
    private VideoService videoService;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VodService vodService;

    @Override
    public List<ChapterVo> getTreeList(Long courseId) {
        List<ChapterVo> finalChapterList = new ArrayList<>();//定义大纲
        // 1. 获取所有章节
        QueryWrapper<Chapter> wrapperChapter = new QueryWrapper<>();
        wrapperChapter.eq("course_id", courseId);
        List<Chapter> chapterList = baseMapper.selectList(wrapperChapter);

        // 2. 获取所有小节
        LambdaQueryWrapper<Video> wrapperVideo = new LambdaQueryWrapper<>();
        wrapperVideo.eq(Video::getCourseId, courseId);
        List<Video> videoList = videoService.list(wrapperVideo);

        // 3. 将小节纳入章节，将章节纳入大纲
        for (int i = 0; i < chapterList.size(); i++) {
            // 3.1 大纲中封装章节
            Chapter chapter = chapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            finalChapterList.add(chapterVo);

            // 3.2 章节中封装小节
            List<VideoVo> videos = new ArrayList<>();
            for(Video video : videoList){
                if(chapter.getId().equals(video.getChapterId())){
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videos.add(videoVo);
                }
            }
            chapterVo.setChildren(videos);
        }

        return finalChapterList;
    }

    @Override
    public void removeChapterByCourseId(Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("course_id", id);
        baseMapper.delete(queryWrapper);
    }

    @Override
    public void removeChapterById(Long id) {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chapter_id", id);
        List<Video> videos = videoMapper.selectList(queryWrapper);//获取章节下所有小节
        if(videos != null && videos.size() != 0) {
            for (Video video : videos) {
                String videoSourceId = video.getVideoSourceId();//获取小节的视频名
                if (!StringUtils.isEmpty(videoSourceId)) {//有的小节没有视频，所以要判断
                    vodService.removeVideo(videoSourceId);//删除视频
                }
            }
            videoMapper.delete(queryWrapper);//删除所有小节
        }

        baseMapper.deleteById(id);//删除该章节
    }
}
