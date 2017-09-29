package com.cachexic.cloud.common.base.entity.query;

import io.swagger.annotations.ApiModelProperty;
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

  @ApiModelProperty("排序字段")
  protected String orderField;

  @ApiModelProperty("升序或降序")
  protected String orderSort = "asc";

  public OrderField() {
    super();
  }

  public OrderField(String orderField, String orderSort) {
    super();
    this.orderField = orderField.toLowerCase();
    this.orderSort = orderSort;
  }

  public String getOrderField() {
    return orderField;
  }

  public OrderField setOrderField(String orderField) {
    this.orderField = orderField;
    return this;
  }

  public String getOrderSort() {
    return orderSort;
  }

  public OrderField setOrderSort(String orderSort) {
    this.orderSort = orderSort;
    return this;
  }
}