package com.yikekong.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("emq")//配置了前缀后，会自动将配置文件中的属性值注入到该类中
@Data
public class EmqConfig {

    private String mqttServerUrl;
}
