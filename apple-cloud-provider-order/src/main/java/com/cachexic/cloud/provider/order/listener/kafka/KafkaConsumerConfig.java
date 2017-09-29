package com.cachexic.cloud.provider.order.listener.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * @author tangmin
 * @Description: Kafka生产者配置
 * @date 2017-09-15 23:03:50
 */
//@Component
//@Configuration
//@EnableKafka
public class KafkaConsumerConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  /**
   * 解决随机配置groupId的问题
   * 1、如果所有实例只有一个消费者可用，则指定group：fixedGroup。
   * kafka消费者的负载均衡是通过配置多partition来实现的，比如同一个消费组，有2个消费者实例监听，partition为2，则可实现负载消费；
   * 2、如果所有实例都需要消费（比如更新本地缓存）则用随机group：randomGroup
   *
   * 但是2者只能存在一个，所以，在消费的时候，需要确定好到底是什么模式。
   * 一般来说，缓存更新，如果没有做nginx+lua分发路由，则每个cache服务都需要更新的，用随机group，都去消费；
   * 如果只需要消费一次，比如监听订单创建，则必须用同一个group。
   */
  @Value("${spring.kafka.consumer.group-id.fixedGroup}")
  //@Value("${spring.kafka.consumer.group-id.randomGroup}")
  private String groupIdConfig;

  @Bean
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    factory.setConcurrency(3);//设置多线程消费，提升吞吐量
    factory.getContainerProperties().setPollTimeout(3000);
    return factory;
  }

  public ConsumerFactory<String, String> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs());
  }

  public Map<String, Object> consumerConfigs() {
    Map<String, Object> propsMap = new HashMap<>();
    propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
    propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
    propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
    propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdConfig);
    propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
    return propsMap;
  }

  @Bean
  public KafkaProperties.Listener listener() {
    return new KafkaProperties.Listener();
  }

}
