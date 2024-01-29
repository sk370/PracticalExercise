package zyq.opcmilo.client.context;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import zyq.opcmilo.client.config.OpcInitSubscriptionConfig;

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
