package com.atguigu.ggkt.wechat.service;

import java.util.Map;

/**
 * @author zhuyuqi
 * @version v2.0
 * @interfaceName MessageService
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/17 20:05
 */
public interface MessageService {
    String receiveMessage(Map<String, String> param);

    void pushPayMessage(long l);
}
