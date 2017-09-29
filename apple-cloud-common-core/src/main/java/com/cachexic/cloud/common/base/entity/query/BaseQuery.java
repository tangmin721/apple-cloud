package com.cachexic.cloud.common.base.entity.query;

import com.cachexic.cloud.common.base.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @author tangmin
 * @version V1.0
 */
public class BaseQuery extends PojoBaseQuery {

  private static final long serialVersionUID = 1919774516804971541L;

  @ApiModelProperty(value = "状态", position = 800)
  protected StatusEnum status = StatusEnum.normal;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty(value = "创建开始时间", example = "2018-08-08 09:09:09", position = 801, hidden = true)
  protected Date startCreateTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty(value = "创建结束时间", example = "2018-08-08 09:09:09", position = 802, hidden = true)
  protected Date endCreateTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty(value = "修改开始时间", example = "2018-08-08 09:09:09", position = 803, hidden = true)
  protected Date startUpdateTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty(value = "修改开始时间", example = "2018-08-08 09:09:09", position = 804, hidden = true)
  protected Date endUpdateTime;

  @ApiModelProperty(value = "创建人id", position = 805)
  protected Long createUserId;

  @ApiModelProperty(value = "修改人id", position = 806)
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

  public void setStartCreateTime(Date startCreateTime) {
    this.startCreateTime = startCreateTime;
  }

  public Date getEndCreateTime() {
    return endCreateTime;
  }

  public void setEndCreateTime(Date endCreateTime) {
    this.endCreateTime = endCreateTime;
  }

  public Date getStartUpdateTime() {
    return startUpdateTime;
  }

  public void setStartUpdateTime(Date startUpdateTime) {
    this.startUpdateTime = startUpdateTime;
  }

  public Date getEndUpdateTime() {
    return endUpdateTime;
  }

  public void setEndUpdateTime(Date endUpdateTime) {
    this.endUpdateTime = endUpdateTime;
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
