package com.cachexic.cloud.feign.msg.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;
import com.cachexic.cloud.common.base.entity.query.PojoBaseQuery;
import com.cachexic.cloud.feign.msg.enums.MsgStatusEnum;

/**
 * 持久化消息管理
 * @author tangmin
 * @date 2017-09-12 19:01:50
 */
public class MsgPersistentQuery extends BaseQuery{
    private static final long serialVersionUID = 1L;

    private String topic;
    private Boolean topicLike = false;

    private String tags;
    private Boolean tagsLike = false;

    private String msgDataType;
    private Boolean msgDataTypeLike = false;

    private String msgBody;
    private Boolean msgBodyLike = false;

    private Integer msgSendTimes;

    private MsgStatusEnum msgStatus;

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
    public String getTags() {
        return tags;
    }

    public MsgPersistentQuery setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public Boolean getTagsLike() {
        return tagsLike;
    }

    public MsgPersistentQuery setTagsLike(Boolean tagsLike) {
        this.tagsLike = tagsLike;
        return this;
    }
    public String getMsgDataType() {
        return msgDataType;
    }

    public MsgPersistentQuery setMsgDataType(String msgDataType) {
        this.msgDataType = msgDataType;
        return this;
    }

    public Boolean getMsgDataTypeLike() {
        return msgDataTypeLike;
    }

    public MsgPersistentQuery setMsgDataTypeLike(Boolean msgDataTypeLike) {
        this.msgDataTypeLike = msgDataTypeLike;
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

    public MsgStatusEnum getMsgStatus() {
        return msgStatus;
    }

    public MsgPersistentQuery setMsgStatus(MsgStatusEnum msgStatus) {
        this.msgStatus = msgStatus;
        return this;
    }

    /**
     * 覆写最大页
     * @param pageSize
     * @return
     */
    private static final long my_max_page_size = 1000L;
    @Override
    public PojoBaseQuery setPageSize(Long pageSize) {
        if (pageSize.longValue() > my_max_page_size) {
            this.pageSize = my_max_page_size;
        }
        if (pageSize.longValue() > 0 && pageSize.longValue() <= my_max_page_size) {
            this.pageSize = pageSize;
        }

        this.startRow = (this.currentPage - 1) * this.pageSize;
        return this;
    }

}