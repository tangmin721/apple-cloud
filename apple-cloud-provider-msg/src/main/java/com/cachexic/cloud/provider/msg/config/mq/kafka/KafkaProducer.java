package com.cachexic.cloud.provider.msg.config.mq.kafka;

import com.cachexic.cloud.common.utils.id.UUIDUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.provider.msg.config.mq.Producer;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 *  Kafka生产者实现类
 * /mydisk/kafka_2.11-0.11.0.1/bin/zookeeper-server-start.sh /mydisk/kafka_2.11-0.11.0.1/config/zookeeper.properties &
 * /mydisk/kafka_2.11-0.11.0.1/bin/kafka-server-start.sh /mydisk/kafka_2.11-0.11.0.1/config/server.properties &
 * Created by tangm on 2017/9/13.
 */
@Service("kafkaProducer")
public class KafkaProducer implements Producer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public String send(MsgPersistent msgPersistent) {
        //异步调用
        CompletableFuture.runAsync(()->kafkaTemplate.send(msgPersistent.getTopic(), JsonUtil.toJson(msgPersistent)));
        //同步调用kafkaTemplate.send(msgPersistent.getTopic(), JsonUtil.toJson(msgPersistent));
        return UUIDUtil.get32UUID();
    }
}
