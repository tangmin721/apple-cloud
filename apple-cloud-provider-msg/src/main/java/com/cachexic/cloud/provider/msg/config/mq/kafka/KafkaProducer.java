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
