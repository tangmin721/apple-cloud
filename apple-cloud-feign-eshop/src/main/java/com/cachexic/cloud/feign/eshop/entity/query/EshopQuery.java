package com.cachexic.cloud.feign.eshop.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: e店管理
 * @author tangmin
 * @date 2017-10-10 21:00:52
 */
public class EshopQuery extends BaseQuery{
  private static final long serialVersionUID = 1L;

  @ApiModelProperty("店铺名称")
  private String name;
  private Boolean nameLike = false;

  @ApiModelProperty("店铺编号")
  private String code;
  private Boolean codeLike = false;

  public String getName() {
    return name;
  }

  public EshopQuery setName(String name) {
    this.name = name;
    return this;
  }

  public Boolean getNameLike() {
    return nameLike;
  }

  public EshopQuery setNameLike(Boolean nameLike) {
    this.nameLike = nameLike;
    return this;
  }
  public String getCode() {
    return code;
  }

  public EshopQuery setCode(String code) {
    this.code = code;
    return this;
  }

  public Boolean getCodeLike() {
    return codeLike;
  }

  public EshopQuery setCodeLike(Boolean codeLike) {
    this.codeLike = codeLike;
    return this;
  }
}