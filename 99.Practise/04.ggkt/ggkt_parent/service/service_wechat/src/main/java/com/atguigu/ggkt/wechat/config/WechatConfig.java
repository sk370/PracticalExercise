package com.atguigu.ggkt.wechat.config;

import com.atguigu.ggkt.wechat.utils.ConstantPropertiesUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 同步微信菜单：创建service对象
 * @author zhuyuqi
 * @version v0.0.1
 * @className WechatConfig
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/16 17:39
 */
//@Configuration//
@Component
public class WechatConfig {

    @Autowired
    private ConstantPropertiesUtil constantPropertiesUtil;//解决加载顺序的问题。没有写这句时，该组件先创建，工具类后创建

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }
    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(ConstantPropertiesUtil.ACCESS_KEY_ID);//为什么读取不到工具类的常量？-----第25、26行解决
        wxMpConfigStorage.setSecret(ConstantPropertiesUtil.ACCESS_KEY_SECRET);//为什么读取不到工具类的常量？-----第25、26行解决
        return wxMpConfigStorage;
    }
}
