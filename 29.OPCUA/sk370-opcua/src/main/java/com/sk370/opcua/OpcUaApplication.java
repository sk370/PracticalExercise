package com.sk370.opcua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 程序入口文件
 *
 * @author sk370
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.sk370.opcua.mapper")
public class OpcUaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpcUaApplication.class, args);
    }
}
