package com.cachexic.cloud.common.base.validator.exceptions;

/**
 * @author tangmin
 * @Description: 校验信息的异常信息
 * @date 2017-09-14 09:32:27
 */
public enum ValidBizExceptionEnum {
  VALID_INSERT_ERROR(-1, "新增校验失败"),
  VALID_UPDATE_ERROR(-1, "更新校验失败");

  private int code;
  private String msg;

  /**
   * 构造方法
   */
  ValidBizExceptionEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
