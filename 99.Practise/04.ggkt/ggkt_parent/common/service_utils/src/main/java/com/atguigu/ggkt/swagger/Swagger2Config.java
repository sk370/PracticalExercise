package com.atguigu.ggkt.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2接口测试类
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/12 16:01
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ggkt")
//                .apiInfo(webApiInfo())
                .select()
                //.paths(Predicates.and(PathSelectors.regex("/api/.*")))//只显示api路径下的页面
                .build();
    }

//    private ApiInfo webApiInfo() {
//        return new ApiInfoBuilder()
//                .title("网站-API文档")
//                .description("本文档描述了网站微服务接口定义")
//                .version("1.0")
//                .contact(new Contact("atguigu", "http://atguigu.com", "atguigu.com"))
//                .build();
//    }
}