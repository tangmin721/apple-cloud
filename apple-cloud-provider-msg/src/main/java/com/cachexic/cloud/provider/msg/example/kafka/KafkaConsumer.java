package com.cachexic.cloud.provider.msg.example.kafka;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by tangm on 2017/9/14.
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic4")
    public void processMessage(String message) {
        MsgPersistent persistent = JsonUtil.toEntity(message, MsgPersistent.class);
        System.out.println("====>KafkaConsumer:"+message);
        System.out.println("====>getConsumerQueue:"+persistent.getConsumerQueue());
        System.out.println("====>getMsgBody:"+persistent.getMsgBody());
        System.out.println("====>getMsgId:"+persistent.getMsgId());
    }

}
