package com.cachexic.cloud.provider.msg.config.mq.rocketmq;

import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.provider.msg.config.mq.Producer;

/**
 * @author tangmin
 * @Description: Rocketmq实现
 * @date 2017-09-13 22:23:20
 */
public class RocketmqProducer implements Producer {
    @Override
    public String sendSyncMsg(MsgPersistent msgPersistent) {
        return null;
    }
}
