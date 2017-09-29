package com.cachexic.cloud.provider.order.listener.kafka;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.constants.KafkaMsgQueueConts;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.provider.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author tangmin
 * @Description: kafka监听消费队列
 * @date 2017-09-15 10:22:37
 */
//@Component
public class OrderCreateKafkaConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = KafkaMsgQueueConts.TEST_TOPIC,group = "group")
    //@KafkaListener(topics = KafkaMsgQueueConts.TEST_TOPIC,containerFactory = "myKafkaListenerContainerFactory")
    public void processMessage(String message) {
        MsgPersistent persistent = JsonUtil.toEntity(message, MsgPersistent.class);
        System.out.println("====>topic:"+ KafkaMsgQueueConts.TEST_TOPIC);
        System.out.println("====>order service pagination:"+JsonUtil.toJson(orderService.selectList(new OrderQuery())));
        System.out.println("====>order:KafkaConsumer:"+message);
        System.out.println("====>order:getConsumerQueue:"+persistent.getConsumerQueue());
        System.out.println("====>order:getMsgBody:"+persistent.getMsgBody());
        System.out.println("====>order:getMsgId:"+persistent.getMsgId());
    }

}
