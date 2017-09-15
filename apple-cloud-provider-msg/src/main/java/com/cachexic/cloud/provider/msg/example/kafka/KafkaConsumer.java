package com.cachexic.cloud.provider.msg.example.kafka;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.constants.KafkaMsgQueueConts;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by tangm on 2017/9/14.
 */
@Component
public class KafkaConsumer {

    @Autowired
    private OrderFeign orderFeign;

    @KafkaListener(topics = KafkaMsgQueueConts.TEST_TOPIC)
    public void processMessage(String message) {
        MsgPersistent persistent = JsonUtil.toEntity(message, MsgPersistent.class);
        System.out.println("====>topic:"+ KafkaMsgQueueConts.TEST_TOPIC);
        System.out.println("====>order feign pagination:"+JsonUtil.toJson(orderFeign.pagination(new OrderQuery())));
        System.out.println("====>KafkaConsumer:"+message);
        System.out.println("====>getConsumerQueue:"+persistent.getConsumerQueue());
        System.out.println("====>getMsgBody:"+persistent.getMsgBody());
        System.out.println("====>getMsgId:"+persistent.getMsgId());
    }

}
