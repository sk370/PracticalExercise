package zyq.opcmilo.client.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zyq.opcmilo.client.context.OpcInitContextRefreshedListener;
import zyq.opcmilo.client.repository.VirtualMachineRepository;

@Configuration
public class OpcConfig {
    @Bean
    public OpcInitContextRefreshedListener myContextRefreshedListener() {
        return new OpcInitContextRefreshedListener();
    }
}
