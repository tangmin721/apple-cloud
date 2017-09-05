package com.cachexic.cloud.common.base.entity.query;

import com.cachexic.cloud.common.base.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author tangmin
 * @version V1.0
 * @Title: BaseQuery.java
 * @Package com.gasq.cloud.provider.customer.core.query
 * @Description:
 * @date 2017-04-26 11:05:19
 */
public class BaseQuery extends PojoBaseQuery {
    private static final long serialVersionUID = -1385062464518193766L;

    /** 删除标记 */
    protected StatusEnum status = StatusEnum.normal;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date startCreateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date endCreateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date startUpdateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date endUpdateTime;

    /** 如果 uuid改为Long 需要变更为Long */
    protected Long createUserId;

    /** 如果 uuid改为Long 需要变更为Long */
    protected Long updateUserId;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public BaseQuery setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
        return this;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public BaseQuery setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
        return this;
    }

    public Date getStartUpdateTime() {
        return startUpdateTime;
    }

    public BaseQuery setStartUpdateTime(Date startUpdateTime) {
        this.startUpdateTime = startUpdateTime;
        return this;
    }

    public Date getEndUpdateTime() {
        return endUpdateTime;
    }

    public BaseQuery setEndUpdateTime(Date endUpdateTime) {
        this.endUpdateTime = endUpdateTime;
        return this;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
}
