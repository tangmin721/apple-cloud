package com.cachexic.cloud.provider.order.listener.kafka;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by tangm on 2017/9/14.
 */
@Component
public class OrderCreateKafkaConsumer {


    @KafkaListener(topics = "my-topic4")
    public void processMessage(String message) {
        MsgPersistent persistent = JsonUtil.toEntity(message, MsgPersistent.class);
        System.out.println("====>order:KafkaConsumer:"+message);
        System.out.println("====>order:getConsumerQueue:"+persistent.getConsumerQueue());
        System.out.println("====>order:getMsgBody:"+persistent.getMsgBody());
        System.out.println("====>order:getMsgId:"+persistent.getMsgId());
    }

}
