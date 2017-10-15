package com.cachexic.cloud.security.core.exceptions;

import com.cachexic.cloud.common.exceptions.BizException;

/**
 * @Description: 安全模块自定义业务异常信息
 * @author tangmin
 * @date 2017-10-15 17:08:42
 */
public class SecurityBizException extends BizException {

  private static final long serialVersionUID = -4580632478681261355L;

  /**
   * 构造方法
   */
  public SecurityBizException(SecurityBizExceptionEnum _enum) {
    super(_enum.getCode(), _enum.getMsg());
  }
}
