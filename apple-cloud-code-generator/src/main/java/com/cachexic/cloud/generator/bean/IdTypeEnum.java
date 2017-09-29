package com.cachexic.cloud.generator.bean;

/**
 * @author tangmin
 * @version V1.0
 * @Title: IdType.java
 * @Package com.gasq.cloud.generator.bean
 * @Description:
 * @date 2017-04-26 17:41:56
 */
public enum IdTypeEnum {

  AUTO_INCR(0, "自增"),
  UUID(1, "UUID");

  private int code;
  private String msg;

  /**
   * 构造方法
   */
  IdTypeEnum(int code, String msg) {
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
