package com.cachexic.cloud.provider.msg.config.mq;

import com.cachexic.cloud.feign.msg.entity.MsgPersistent;

/**
 * @author tangmin
 * @Description: 消息中间件的producer
 * @date 2017-09-13 22:09:19
 */
public interface Producer {

  /**
   * 发送消息实体，返回mqMsgId
   */
  String send(MsgPersistent msgPersistent);
}
