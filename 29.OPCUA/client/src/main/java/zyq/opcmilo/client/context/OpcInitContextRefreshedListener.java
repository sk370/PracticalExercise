package com.xxmes.opcapp.context;

import com.xxmes.opcapp.config.OpcInitSubscriptionConfig;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class OpcInitContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            new OpcInitSubscriptionConfig().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}