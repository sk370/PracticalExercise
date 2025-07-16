package com.atguigu.ggkt.vod.service;

import java.util.Map;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className VodService
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/15 17:22
 */
public interface VodService {
    String uploadVideo();

    void removeVideo(String fileId);

    Map<String, Object> getPlayAuth(Long courseId, Long videoId);
}
