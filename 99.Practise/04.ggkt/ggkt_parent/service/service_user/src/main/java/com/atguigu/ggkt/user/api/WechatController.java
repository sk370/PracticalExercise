package com.atguigu.ggkt.user.api;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.utils.JwtHelper;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.ggkt.user.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;

/**
 * 请求vue-mobile的地址，跳转到后端进行授权
 * @author zhuyuqi
 * @version v0.0.1
 * @className WechatController
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/18 09:40
 */
@Controller//不能写rest，因为这里要跳转到vue-mobile
@Api(tags = "微信授权登录")
@RequestMapping("/api/user/wechat")//与前端的授权访问路径一致
public class WechatController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private WxMpService wxMpService;
    @Value("${wechat.userInfoUrl}")
    private String userInfoUrl;

    @ApiOperation("授权提交")
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl, HttpServletRequest request) {
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(userInfoUrl,//后台的授权地址（从哪获取用户信息）
                WxConsts.OAUTH2_SCOPE_USER_INFO,//授权范围（固定写法）//即snsapi_userinfo
                URLEncoder.encode(returnUrl.replace("guiguketan", "#")));//跳转地址//处理vue项目的路径中的#号进行返回
        return "redirect:" + redirectURL;
    }

    /**
     *
     * @param code 微信返回，相当于临时票据
     * @param returnUrl 授权后的状态信息，包含跳转地址
     * @return
     * @throws Exception
     */
    @ApiOperation("获取用户信息授权")
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) throws Exception {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = this.wxMpService.oauth2getAccessToken(code);
        String openId = wxMpOAuth2AccessToken.getOpenId();

        System.out.println("【微信网页授权】openId={}"+openId);

        WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);//当前微信账户信息
        System.out.println("【微信网页授权】wxMpUser={}"+ JSON.toJSONString(wxMpUser));
        // 将用户信息添加到数据库
        UserInfo userInfo = userInfoService.getUserInfoByOpenid(openId);//getUserInfoByOpenid判断是否已经是已授权账户
        if(null == userInfo) {
            userInfo = new UserInfo();
            userInfo.setOpenId(openId);
            userInfo.setUnionId(wxMpUser.getUnionId());
            userInfo.setNickName(wxMpUser.getNickname());
            userInfo.setAvatar(wxMpUser.getHeadImgUrl());
            userInfo.setSex(wxMpUser.getSexId());
            userInfo.setProvince(wxMpUser.getProvince());

            userInfoService.save(userInfo);
        }
        //授权完成跳转到功能页面
        String token = JwtHelper.createToken(userInfo.getId(), userInfo.getNickName());//生成token
        if(returnUrl.indexOf("?") == -1) {//路径是否包含？
            return "redirect:" + returnUrl + "?token=" + token;
        } else {
            return "redirect:" + returnUrl + "&token=" + token;
        }
    }
}
