package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.VideoVisitor;
import com.atguigu.ggkt.vo.vod.VideoVisitorCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 视频来访者记录表 Mapper 接口
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-09-15
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {
    /**
     * 自定义方法1L：查询固定期限的视频观看人数
     * @param courseId
     * @param startDate
     * @param endDate
     * @return
     */
    List<VideoVisitorCountVo> findCount(@Param("courseId") Long courseId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
