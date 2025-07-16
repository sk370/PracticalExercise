package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.VideoVisitor;
import com.atguigu.ggkt.vo.vod.VideoVisitorCountVo;
import com.atguigu.ggkt.vo.vod.VideoVisitorVo;
import com.atguigu.ggkt.vod.mapper.VideoVisitorMapper;
import com.atguigu.ggkt.vod.service.VideoVisitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 视频来访者记录表 服务实现类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-09-15
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService {

    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        List<VideoVisitorCountVo> videoVisitorVoList = baseMapper.findCount(courseId, startDate, endDate);
        System.out.println(videoVisitorVoList.toString());
        // 1. 保存日期
        List<String> dateList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getJoinTime).collect(Collectors.toList());//取出videoVisitorVoList中的所有joinTime，放入dateList
        // 2. 保存日期对应的视频播放数
        List<Integer> countList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getUserCount).collect(Collectors.toList());//取出videoVisitorVoList中的所有userCount，countList
        // 3. 将dateList、countList按照Echarts.js要求的数据格式放入map
        Map<String, Object> map = new HashMap<>();
        map.put("xData", dateList);//x轴
        map.put("yData", countList);//y轴

        return map;
    }
}
