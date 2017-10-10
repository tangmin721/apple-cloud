package com.cachexic.cloud.feign.eshop.entity;

import com.cachexic.cloud.common.base.annotations.Entity;
import com.cachexic.cloud.common.base.entity.BaseEntity;
import com.cachexic.cloud.common.base.validator.annotations.Insert;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author tangmin
 * @version V1.0
 */
@Entity("t_eshop")
public class Eshop extends BaseEntity {

  private static final long serialVersionUID = -1368803008067580882L;
  @ApiModelProperty(value = "店铺名称", notes = "店铺大气的名称")
  @NotBlank(message = "店铺名称不能为空", groups = Insert.class)
  private String name;

  @ApiModelProperty("店铺编号")
  @NotBlank(message = "店铺编号不能为空", groups = Insert.class)
  private String code;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
