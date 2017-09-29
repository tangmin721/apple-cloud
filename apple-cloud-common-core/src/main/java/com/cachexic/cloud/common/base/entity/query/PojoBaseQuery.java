package com.cachexic.cloud.common.base.entity.query;

import com.cachexic.cloud.common.constants.SystemConst;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 */
public class PojoBaseQuery implements Serializable {

  private static final long serialVersionUID = -3499284113420390114L;

  protected long DEFAULT_PAGE_SIZE = SystemConst.DEFAULT_PAGE_SIZE;

  protected long MAX_PAGE_SIZE = SystemConst.MAX_PAGE_SIZE;

  @ApiModelProperty(value = "每页记录条数", position = 901)
  protected Long pageSize = DEFAULT_PAGE_SIZE;

  @ApiModelProperty(value = "起始行", hidden = true)
  protected Long startRow;

  @ApiModelProperty(value = "当前页", example = "1", position = 902)
  protected Long currentPage = 1L;

  @ApiModelProperty(value = "Sql查询字段,可自定义只取哪几列的信息", hidden = true, example = "1", position = 903)
  protected String fields;

  @ApiModelProperty(value = "单排序字段", position = 904)
  protected String orderField;

  @ApiModelProperty(value = "单字段升序或降序", position = 905)
  protected String orderSort = "asc";

  @ApiModelProperty(value = "多字段排序", notes = "多字段排序,OrderField对象list", position = 906)
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
