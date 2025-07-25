package com.atguigu.ggkt.user.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ConstantPropertiesUtil
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/18 09:35
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {
    @Value("${wechat.mpAppId}")
    private String appid;

    @Value("${wechat.mpAppSecret}")
    private String appsecret;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID = appid;
        ACCESS_KEY_SECRET = appsecret;
    }
}
