package com.cachexic.cloud.provider.order.listener;

import com.cachexic.cloud.provider.order.listener.rocketmq.OrderCreateRocketmqConsumer;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: spring容器启动后，再启动@PostConstruct里的语句
 * @date 2017-06-19 19:32:42
 */
@Component
public class InitListener{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(InitListener.class);

    @Autowired
    private OrderCreateRocketmqConsumer orderCreateRocketmqConsumer;

    @PostConstruct
    public void contextInitialized() {
        log.info("======================contextInitialized===========================");
        orderCreateRocketmqConsumer.start();
    }

    @PreDestroy
    public void contextDestroyed() {
        orderCreateRocketmqConsumer.stop();
        log.info("======================contextDestroyed===========================");
    }
}
