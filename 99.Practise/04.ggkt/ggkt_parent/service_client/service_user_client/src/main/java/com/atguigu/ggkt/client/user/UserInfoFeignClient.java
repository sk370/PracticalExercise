package com.atguigu.ggkt.client.user;

import com.atguigu.ggkt.model.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className UserInfoFeignClient
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/16 14:04
 */
@FeignClient(value = "service-user")//服务者模块名
public interface UserInfoFeignClient {
    @GetMapping("admin/user/user-info/inner/getById/{id}")
    public UserInfo getById(@PathVariable Long id);
}
