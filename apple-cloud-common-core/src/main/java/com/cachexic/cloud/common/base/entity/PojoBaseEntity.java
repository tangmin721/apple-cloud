package com.cachexic.cloud.common.base.entity;

import com.cachexic.cloud.common.base.annotations.Id;

import java.io.Serializable;

/**
 * @author tangmin
 * @version V1.0
 * @Title: PojoBaseEntity.java
 * @Package com.cachexic.sjdbc.common.core
 * @Description: 只带id的类，不带其他业务信息比如（createTime，updateTime）等
 * @date 2017-08-26 12:28:30
 */
public class PojoBaseEntity implements Serializable {
    private static final long serialVersionUID = -4363506460772117197L;

    @Id
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
