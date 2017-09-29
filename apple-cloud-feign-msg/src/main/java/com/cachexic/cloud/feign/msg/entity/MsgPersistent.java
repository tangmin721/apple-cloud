package com.cachexic.cloud.feign.msg.entity;

import com.cachexic.cloud.common.base.annotations.Entity;
import com.cachexic.cloud.common.base.entity.BaseEntity;
import com.cachexic.cloud.common.base.validator.annotations.Insert;
import com.cachexic.cloud.common.enums.YesOrNoEnum;
import com.cachexic.cloud.feign.msg.enums.MsgStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author tangmin
 * @version V1.0
 */
@Entity("t_msg_persistent")
public class MsgPersistent extends BaseEntity {

  private static final long serialVersionUID = -5497996812028362407L;

  @ApiModelProperty(value = "消费对应的队列", notes = "对应RocketmqMsgQueueEnum")
  @NotBlank(message = "消费队列名称不能为空", groups = Insert.class)
  private String consumerQueue;

  @ApiModelProperty(value = "消息topic", notes = "冗余MsgConsumerQueueEnum的topic查询")
  @NotBlank(message = "topic不能为空", groups = Insert.class)
  private String topic;

  @ApiModelProperty(value = "rocketMq tag", notes = "冗余MsgConsumerQueueEnum的tag查询")
  private String tag;

  @ApiModelProperty(value = "消息Id", notes = "32UUID作为唯一消息主键")
  @NotBlank(message = "msgId不能为空", groups = Insert.class)
  private String msgId;

  @ApiModelProperty("rocketmq的消息Id")
  private String mqMsgId;

  @ApiModelProperty("消息的数据类型")
  private String msgClassName;

  @ApiModelProperty("消息主体")
  @NotBlank(message = "消息主体不能为空", groups = Insert.class)
  private String msgBody;

  @ApiModelProperty("消息发送次数")
  private Integer msgSendTimes;

  @ApiModelProperty("是否是死亡消息")
  private YesOrNoEnum alreadyDead;

  @ApiModelProperty("消息状态")
  private MsgStatusEnum msgStatus;

  @ApiModelProperty(value = "Long备用字段1", notes = "存储一些业务信息，比如订单号，流水号之类，但是又不能通用的，便于查询")
  private Long fieldLong1;

  @ApiModelProperty(value = "Long备用字段2", notes = "存储一些业务信息，比如订单号，流水号之类，但是又不能通用的，便于查询")
  private Long fieldLong2;

  @ApiModelProperty(value = "String备用字段1", notes = "存储一些业务信息，比如订单号，流水号之类，但是又不能通用的，便于查询")
  private String fieldString1;

  @ApiModelProperty(value = "String备用字段2", notes = "存储一些业务信息，比如订单号，流水号之类，但是又不能通用的，便于查询")
  private String fieldString2;

  public String getConsumerQueue() {
    return consumerQueue;
  }

  public void setConsumerQueue(String consumerQueue) {
    this.consumerQueue = consumerQueue;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getMsgId() {
    return msgId;
  }

  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  public String getMqMsgId() {
    return mqMsgId;
  }

  public void setMqMsgId(String mqMsgId) {
    this.mqMsgId = mqMsgId;
  }

  public String getMsgClassName() {
    return msgClassName;
  }

  public void setMsgClassName(String msgClassName) {
    this.msgClassName = msgClassName;
  }

  public String getMsgBody() {
    return msgBody;
  }

  public void setMsgBody(String msgBody) {
    this.msgBody = msgBody;
  }

  public Integer getMsgSendTimes() {
    return msgSendTimes;
  }

  public void setMsgSendTimes(Integer msgSendTimes) {
    this.msgSendTimes = msgSendTimes;
  }

  public YesOrNoEnum getAlreadyDead() {
    return alreadyDead;
  }

  public void setAlreadyDead(YesOrNoEnum alreadyDead) {
    this.alreadyDead = alreadyDead;
  }

  public MsgStatusEnum getMsgStatus() {
    return msgStatus;
  }

  public void setMsgStatus(MsgStatusEnum msgStatus) {
    this.msgStatus = msgStatus;
  }

  public Long getFieldLong1() {
    return fieldLong1;
  }

  public void setFieldLong1(Long fieldLong1) {
    this.fieldLong1 = fieldLong1;
  }

  public Long getFieldLong2() {
    return fieldLong2;
  }

  public void setFieldLong2(Long fieldLong2) {
    this.fieldLong2 = fieldLong2;
  }

  public String getFieldString1() {
    return fieldString1;
  }

  public void setFieldString1(String fieldString1) {
    this.fieldString1 = fieldString1;
  }

  public String getFieldString2() {
    return fieldString2;
  }

  public void setFieldString2(String fieldString2) {
    this.fieldString2 = fieldString2;
  }
}
