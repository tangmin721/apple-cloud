package com.cachexic.cloud.common.base.entity.query;

import java.io.Serializable;

/**
 * @author tangmin
 * @version V1.0
 * @Title: OrderField.java
 * @Package com.cachexic.sjdbc.common.core
 * @Description: 排序字段
 * @date 2017-09-02 20:31:09
 */
public class OrderField implements Serializable {
    private static final long serialVersionUID = 8783268276643509260L;

    private String fieldName;
    private String order;

    public OrderField(){
        super();
    }

    public OrderField(String fieldName, String order) {
        super();
        this.fieldName = fieldName.toLowerCase();
        this.order = order;
    }

    public String getFieldName() {
        return fieldName;
    }

    public OrderField setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getOrder() {
        return order;
    }

    public OrderField setOrder(String order) {
        this.order = order;
        return this;
    }
}