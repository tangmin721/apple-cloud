package com.cachexic.cloud.provider.msg.service;

import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by tangm on 2017/9/9.
 */
public interface ProducerService {

  /**
   * 预存储消息
   */
  void saveMsgWaitingConfirm(MsgPersistent msgPersistent);

  /**
   * 确认并发送消息
   */
  void confirmAndSendMsg(String msgId);

  /**
   * 存储并发送消息
   */
  void saveAndSendMsg(MsgPersistent msgPersistent);

  /**
   * 直接发送消息
   */
  void directSendMsg(MsgPersistent msgPersistent);

  /**
   * 重发消息
   */
  void reSendMsg(@RequestBody MsgPersistent msgPersistent);

  /**
   * 根据msgId重发某条消息
   */
  void reSendMsgByMsgId(String msgId);

  /**
   * 将消息标记为死亡消息
   */
  void setMsgToDead(String msgId);

  /**
   * 根据消息ID获取消息.
   */
  MsgPersistent getMsgByMsgId(String msgId);

  /**
   * 根据消息ID删除消息
   */
  void deleteMsgByMsgId(String msgId);

  /**
   * 重发某个消息队列中的全部已死亡的消息.
   */
  void reSendAllDeadMsgByTopic();

}
