package com.cachexic.cloud.provider.rocketmq.service;

import com.cachexic.cloud.feign.msg.entity.MsgPersistent;

/**
 * Created by tangm on 2017/9/9.
 */
public interface ProducerService {

    /** 直接发送消息 */
    void directSendMsg(MsgPersistent msgPersistent);
}
