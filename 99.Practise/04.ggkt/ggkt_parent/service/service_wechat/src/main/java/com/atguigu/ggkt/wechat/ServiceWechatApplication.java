package com.atguigu.ggkt.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ServiceWechatApplication
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/16 16:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.ggkt.wechat.mapper")
@EnableFeignClients("com.atguigu.ggkt")
@ComponentScan(basePackages = "com.atguigu.ggkt")//这句是为了加载service_utils包下的swagger程序、配置类等
public class ServiceWechatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceWechatApplication.class, args);
    }
}
