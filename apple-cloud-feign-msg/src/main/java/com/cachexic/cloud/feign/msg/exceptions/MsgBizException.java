package com.cachexic.cloud.feign.msg.exceptions;

import com.cachexic.cloud.common.exceptions.BizException;

/**
 * @author tangmin
 * @Description: 消息中间件的异常信息
 * @date 2017-09-14 09:35:43
 */
public class MsgBizException extends BizException {

  private static final long serialVersionUID = -4580632478681261355L;

  /**
   * 构造方法
   */
  public MsgBizException(MsgBizExceptionEnum _enum) {
    super(_enum.getCode(), _enum.getMsg());
  }
}
