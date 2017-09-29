package com.cachexic.cloud.provider.msg.config.mq.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 封装一个rocket客户端连接的bean
 * @date 2017-09-09 10:23:57
 */
@Component
@Configuration
public class RocketmqClientFactoryBean implements FactoryBean<DefaultMQProducer>, InitializingBean,
    DisposableBean {

  private static Logger logger = LoggerFactory.getLogger(RocketmqClientFactoryBean.class);

  private DefaultMQProducer producer;

  @Value("${rocketmq.group}")
  private String group;
  @Value("${rocketmq.namesrv}")
  private String namesrvAddr;

  @Override
  public void destroy() throws Exception {
    try {
      logger.info("Closing rocketmq producer client");
      if (producer != null) {
        producer.shutdown();
      }
    } catch (final Exception e) {
      logger.error("Error closing rocketmq producer client: ", e);
    }
  }

  @Override
  public DefaultMQProducer getObject() throws Exception {
    return producer;
  }

  @Override
  public Class<?> getObjectType() {
    return DefaultMQProducer.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    producer = new DefaultMQProducer();
    producer.setProducerGroup(group);
    producer.setNamesrvAddr(namesrvAddr);
    producer.start();
  }
}
