package com.cachexic.cloud.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description: 验证码异常继承认证失败异常
 * @author tangmin
 * @date 2017-09-29 16:01:32
 */
public class ValidateCodeException extends AuthenticationException {

  private static final long serialVersionUID = -2534495451425923361L;

  public ValidateCodeException(String msg) {
    super(msg);
  }
}
