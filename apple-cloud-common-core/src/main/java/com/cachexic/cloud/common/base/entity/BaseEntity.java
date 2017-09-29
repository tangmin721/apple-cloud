package com.cachexic.cloud.common.base.entity;

import com.cachexic.cloud.common.base.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @author tangmin
 * @version V1.0
 */
public class BaseEntity extends PojoBaseEntity {

  private static final long serialVersionUID = 4515148147423576935L;

  @ApiModelProperty(value = "版本号", position = -998)
  private Integer version = 0;

  @ApiModelProperty(value = "创建时间", hidden = true, position = 993)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  @ApiModelProperty(value = "创建人Id", hidden = true, position = 994)
  private Long createUserId;

  @ApiModelProperty(value = "创建人Name", hidden = true, position = 995)
  private String createUserName;

  @ApiModelProperty(value = "最后修改时间", hidden = true, position = 996)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;

  @ApiModelProperty(value = "修改人Id", hidden = true, position = 997)
  private Long updateUserId;

  @ApiModelProperty(value = "修改人Name", hidden = true, position = 998)
  private String updateUserName;

  @ApiModelProperty(value = "状态", position = 999)
  private StatusEnum status;

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Long getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  public String getCreateUserName() {
    return createUserName;
  }

  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Long getUpdateUserId() {
    return updateUserId;
  }

  public void setUpdateUserId(Long updateUserId) {
    this.updateUserId = updateUserId;
  }

  public String getUpdateUserName() {
    return updateUserName;
  }

  public void setUpdateUserName(String updateUserName) {
    this.updateUserName = updateUserName;
  }

  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }
}
