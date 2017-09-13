package com.cachexic.cloud.provider.msg.config.mq.kafka;

import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.provider.msg.config.mq.Producer;

/**
 * Created by tangm on 2017/9/13.
 */
public class KafkaProducer implements Producer {
    @Override
    public String sendSyncMsg(MsgPersistent msgPersistent) {
        return null;
    }
}
