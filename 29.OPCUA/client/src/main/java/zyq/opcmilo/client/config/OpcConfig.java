package com.xxmes.opcapp.config;

import cn.hutool.core.io.resource.ClassPathResource;
import com.xxmes.opcapp.context.OpcInitContextRefreshedListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class OpcConfig {
    @Bean
    public OpcInitContextRefreshedListener myContextRefreshedListener() {
        return new OpcInitContextRefreshedListener();
    }
}
