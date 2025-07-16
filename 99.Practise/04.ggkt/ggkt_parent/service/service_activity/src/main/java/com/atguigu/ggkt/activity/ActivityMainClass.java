package com.atguigu.ggkt.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ActivityMainClass
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/16 12:21
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu.ggkt.client.user")
@ComponentScan(basePackages = "com.atguigu.ggkt")//这句是为了加载service_utils包下的swagger程序、配置类等
public class ActivityMainClass {
    public static void main(String[] args) {
        SpringApplication.run(ActivityMainClass.class, args);
    }
}
