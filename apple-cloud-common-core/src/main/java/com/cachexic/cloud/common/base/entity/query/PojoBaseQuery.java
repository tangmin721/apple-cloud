package com.cachexic.cloud.common.base.entity.query;

import com.cachexic.cloud.common.constants.SystemConst;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: PojoPojoBaseQuery.java
 * @Package com.gasq.cloud.common.core.entity
 * @Description: 只带id的类，不带其他业务信息比如（createTime，updateTime）等
 * @date 2017-04-27 16:12:37
 */
public class PojoBaseQuery implements Serializable {
    private static final long serialVersionUID = -3499284113420390114L;

    protected long DEFAULT_PAGE_SIZE = SystemConst.DEFAULT_PAGE_SIZE;

    protected long MAX_PAGE_SIZE = SystemConst.MAX_PAGE_SIZE;

    protected Long pageSize = DEFAULT_PAGE_SIZE;

    /** 起始行 */
    protected Long startRow;

    /** 当前页 */
    protected Long currentPage = 1L;

    /** Sql查询字段,可自定义只取哪几列的信息 */
    protected String fields;

    /** 排序字段：默认按id，如果默认按其他，set一下 */
    protected String orderField;

    /** asc or desc  默认正序 */
    protected String orderSort = "asc";

    /** 排序列表字段 */
    private List<OrderField> orderFields = Lists.newArrayList();

    public PojoBaseQuery() {
        this.startRow = (this.currentPage - 1) * this.pageSize;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public PojoBaseQuery setPageSize(Long pageSize) {
        if (pageSize.longValue() > MAX_PAGE_SIZE) {
            this.pageSize = MAX_PAGE_SIZE;
        }
        if (pageSize.longValue() > 0 && pageSize.longValue() <= MAX_PAGE_SIZE) {
            this.pageSize = pageSize;
        }

        this.startRow = (this.currentPage - 1) * this.pageSize;
        return this;
    }

    public Long getStartRow() {
        return startRow;
    }

    public PojoBaseQuery setStartRow(Long startRow) {
        this.startRow = startRow;
        return this;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public PojoBaseQuery setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
        this.startRow = (this.currentPage - 1) * this.pageSize;
        return this;
    }

    public String getFields() {
        return fields;
    }

    public PojoBaseQuery setFields(String fields) {
        this.fields = fields;
        return this;
    }

    public String getOrderField() {
        return orderField;
    }

    public PojoBaseQuery setOrderField(String orderField) {
        this.orderField = orderField;
        if (StringUtils.isNotBlank(orderField)) {
            this.orderFields.clear();
            this.orderFields.add(new OrderField(this.orderField, this.orderSort));
        }
        return this;
    }

    public String getOrderSort() {
        return orderSort;
    }

    public PojoBaseQuery setOrderSort(String orderSort) {
        this.orderSort = orderSort;
        if (StringUtils.isNotBlank(orderSort)) {
            this.orderFields.clear();
            if (StringUtils.isNotBlank(orderField)) {
                this.orderFields.add(new OrderField(this.orderField, this.orderSort));
            }
        }
        return this;
    }

    public List<OrderField> getOrderFields() {
        return orderFields;
    }

    public PojoBaseQuery setOrderFields(List<OrderField> orderFields) {
        this.orderFields = orderFields;
        return this;
    }

}
