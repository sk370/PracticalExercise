package com.sk370.opcua.config;

import com.sk370.opcua.listener.OpcInitContextRefreshedListener;
import lombok.Data;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * @author yugo
 */
@Component
@ConfigurationProperties(prefix = "opcua")
@Data
public class OpcUaConfig {

    private String endpointUrl;

    public Predicate<EndpointDescription> endpointFilter() {
        return e -> true;
    }

    /**
     * 开启多通道/设备点位监控
     * @return
     */
//    @Bean
//    public OpcInitContextRefreshedListener myContextRefreshedListener() {
//        return new OpcInitContextRefreshedListener();
//    }

}
