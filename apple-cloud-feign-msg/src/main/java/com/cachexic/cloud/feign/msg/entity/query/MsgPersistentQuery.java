package com.cachexic.cloud.feign.msg.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;
import com.cachexic.cloud.common.enums.YesOrNoEnum;
import com.cachexic.cloud.feign.msg.enums.MsgStatusEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息持久化管理
 * @author tangmin
 * @date 2017-09-28 13:23:00
 */
public class MsgPersistentQuery extends BaseQuery{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("消费对应的队列")
    private String consumerQueue;
    private Boolean consumerQueueLike = false;

    @ApiModelProperty("消息topic")
    private String topic;
    private Boolean topicLike = false;

    @ApiModelProperty("rocketMq tag")
    private String tag;
    private Boolean tagLike = false;

    @ApiModelProperty("消息Id")
    private String msgId;
    private Boolean msgIdLike = false;

    @ApiModelProperty("rocketmq的消息Id")
    private String mqMsgId;
    private Boolean mqMsgIdLike = false;

    @ApiModelProperty("消息的数据类型")
    private String msgClassName;
    private Boolean msgClassNameLike = false;

    @ApiModelProperty("消息主体")
    private String msgBody;
    private Boolean msgBodyLike = false;

    @ApiModelProperty("消息发送次数")
    private Integer msgSendTimes;

    @ApiModelProperty("是否是死亡消息")
    private YesOrNoEnum alreadyDead;

    @ApiModelProperty("消息状态")
    private MsgStatusEnum msgStatus;

    @ApiModelProperty("Long备用字段1")
    private Long fieldLong1;

    @ApiModelProperty("Long备用字段2")
    private Long fieldLong2;

    @ApiModelProperty("String备用字段1")
    private String fieldString1;
    private Boolean fieldString1Like = false;

    @ApiModelProperty("String备用字段2")
    private String fieldString2;
    private Boolean fieldString2Like = false;

    public String getConsumerQueue() {
        return consumerQueue;
    }

    public MsgPersistentQuery setConsumerQueue(String consumerQueue) {
        this.consumerQueue = consumerQueue;
        return this;
    }

    public Boolean getConsumerQueueLike() {
        return consumerQueueLike;
    }

    public MsgPersistentQuery setConsumerQueueLike(Boolean consumerQueueLike) {
        this.consumerQueueLike = consumerQueueLike;
        return this;
    }
    public String getTopic() {
        return topic;
    }

    public MsgPersistentQuery setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public Boolean getTopicLike() {
        return topicLike;
    }

    public MsgPersistentQuery setTopicLike(Boolean topicLike) {
        this.topicLike = topicLike;
        return this;
    }
    public String getTag() {
        return tag;
    }

    public MsgPersistentQuery setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Boolean getTagLike() {
        return tagLike;
    }

    public MsgPersistentQuery setTagLike(Boolean tagLike) {
        this.tagLike = tagLike;
        return this;
    }
    public String getMsgId() {
        return msgId;
    }

    public MsgPersistentQuery setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public Boolean getMsgIdLike() {
        return msgIdLike;
    }

    public MsgPersistentQuery setMsgIdLike(Boolean msgIdLike) {
        this.msgIdLike = msgIdLike;
        return this;
    }
    public String getMqMsgId() {
        return mqMsgId;
    }

    public MsgPersistentQuery setMqMsgId(String mqMsgId) {
        this.mqMsgId = mqMsgId;
        return this;
    }

    public Boolean getMqMsgIdLike() {
        return mqMsgIdLike;
    }

    public MsgPersistentQuery setMqMsgIdLike(Boolean mqMsgIdLike) {
        this.mqMsgIdLike = mqMsgIdLike;
        return this;
    }
    public String getMsgClassName() {
        return msgClassName;
    }

    public MsgPersistentQuery setMsgClassName(String msgClassName) {
        this.msgClassName = msgClassName;
        return this;
    }

    public Boolean getMsgClassNameLike() {
        return msgClassNameLike;
    }

    public MsgPersistentQuery setMsgClassNameLike(Boolean msgClassNameLike) {
        this.msgClassNameLike = msgClassNameLike;
        return this;
    }
    public String getMsgBody() {
        return msgBody;
    }

    public MsgPersistentQuery setMsgBody(String msgBody) {
        this.msgBody = msgBody;
        return this;
    }

    public Boolean getMsgBodyLike() {
        return msgBodyLike;
    }

    public MsgPersistentQuery setMsgBodyLike(Boolean msgBodyLike) {
        this.msgBodyLike = msgBodyLike;
        return this;
    }
    public Integer getMsgSendTimes() {
        return msgSendTimes;
    }

    public MsgPersistentQuery setMsgSendTimes(Integer msgSendTimes) {
        this.msgSendTimes = msgSendTimes;
        return this;
    }

    public YesOrNoEnum getAlreadyDead() {
        return alreadyDead;
    }

    public MsgPersistentQuery setAlreadyDead(YesOrNoEnum alreadyDead) {
        this.alreadyDead = alreadyDead;
        return this;
    }

    public MsgStatusEnum getMsgStatus() {
        return msgStatus;
    }

    public MsgPersistentQuery setMsgStatus(MsgStatusEnum msgStatus) {
        this.msgStatus = msgStatus;
        return this;
    }

    public Long getFieldLong1() {
        return fieldLong1;
    }

    public MsgPersistentQuery setFieldLong1(Long fieldLong1) {
        this.fieldLong1 = fieldLong1;
        return this;
    }

    public Long getFieldLong2() {
        return fieldLong2;
    }

    public MsgPersistentQuery setFieldLong2(Long fieldLong2) {
        this.fieldLong2 = fieldLong2;
        return this;
    }

    public String getFieldString1() {
        return fieldString1;
    }

    public MsgPersistentQuery setFieldString1(String fieldString1) {
        this.fieldString1 = fieldString1;
        return this;
    }

    public Boolean getFieldString1Like() {
        return fieldString1Like;
    }

    public MsgPersistentQuery setFieldString1Like(Boolean fieldString1Like) {
        this.fieldString1Like = fieldString1Like;
        return this;
    }
    public String getFieldString2() {
        return fieldString2;
    }

    public MsgPersistentQuery setFieldString2(String fieldString2) {
        this.fieldString2 = fieldString2;
        return this;
    }

    public Boolean getFieldString2Like() {
        return fieldString2Like;
    }

    public MsgPersistentQuery setFieldString2Like(Boolean fieldString2Like) {
        this.fieldString2Like = fieldString2Like;
        return this;
    }

}