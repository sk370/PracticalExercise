package com.atguigu.ggkt.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className com.atguigu.ggkt.order.controller.ServiceOrderApplication
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/16 10:01
 */
@SpringBootApplication
@EnableDiscoveryClient
//@MapperScan("com.atguigu.ggkt.order.mapper")//规范写法写到分页的配置类上去
@ComponentScan(basePackages = "com.atguigu.ggkt")//这句是为了加载service_utils包下的swagger程序、配置类等
@EnableFeignClients(basePackages = "com.atguigu.ggkt")
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}
