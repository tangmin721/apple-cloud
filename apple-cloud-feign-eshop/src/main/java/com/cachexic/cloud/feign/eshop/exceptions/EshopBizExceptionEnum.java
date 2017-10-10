package com.cachexic.cloud.feign.eshop.exceptions;

/**
 * @author tangmin
 * @Description: eshop的异常信息
 * @date 2017-09-14 09:35:53
 */
public enum EshopBizExceptionEnum {
  NOT_OPEN(-1, "店铺未开业");

  private int code;
  private String msg;

  /**
   * 构造方法
   */
  EshopBizExceptionEnum(int code, String msg) {
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
