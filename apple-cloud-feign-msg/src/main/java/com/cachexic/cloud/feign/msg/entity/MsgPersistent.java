package com.cachexic.cloud.feign.msg.entity;

import com.cachexic.cloud.common.base.entity.BaseEntity;

/**
 * @author tangmin
 * @version V1.0
 * @Title: MsgPersistent.java
 * @Package com.cachexic.cloud.feign.msg.entity
 * @Description: 持久化消息实体类
 * @date 2017-09-09 16:55:20
 */
public class MsgPersistent extends BaseEntity{
    private static final long serialVersionUID = -5497996812028362407L;

    private String group;

    private String topic;

    private String tags;

    /** 消息的数据类型 */
    private String msgDataType;

    /** 消息主体 */
    private String msgBody;

    /** 消息发送次数 */
    private Integer msgSendTimes;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMsgDataType() {
        return msgDataType;
    }

    public void setMsgDataType(String msgDataType) {
        this.msgDataType = msgDataType;
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

    public void addSendTimes() {
        msgSendTimes++;
    }



}
