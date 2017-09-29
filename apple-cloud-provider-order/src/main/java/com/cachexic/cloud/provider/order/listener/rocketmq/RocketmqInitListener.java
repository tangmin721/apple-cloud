package com.cachexic.cloud.provider.order.listener.rocketmq;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tangmin
 * @Description: 启动监听方式1:spring容器启动后，再启动@PostConstruct里的语句,
 * 启动监听的方式2参见:QueueListener
 * @date 2017-06-19 19:32:42
 */
//@Component
public class RocketmqInitListener {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RocketmqInitListener.class);

    @Autowired
    private OrderCreateRocketmqConsumer orderCreateRocketmqConsumer;

//    @Autowired
//    private QueueListener queueListener;

    @PostConstruct
    public void contextInitialized() {
        log.info("======================contextInitialized===========================");
        orderCreateRocketmqConsumer.start();
        //queueListener.start();
    }

    @PreDestroy
    public void contextDestroyed() {
        orderCreateRocketmqConsumer.stop();
        log.info("======================contextDestroyed===========================");
    }
}
