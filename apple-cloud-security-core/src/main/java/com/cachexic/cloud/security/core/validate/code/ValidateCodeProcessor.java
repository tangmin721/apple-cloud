package com.cachexic.cloud.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 校验码处理器,封装不同校验码的处理逻辑
 * @author tangmin
 * @date 2017-09-30 12:45:30
 */
public interface ValidateCodeProcessor {

  /**
   * 验证码方式session时的前缀
   */
  String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";


  /**
   * 创建校验码  ServletWebRequest封装了 request和response
   * @param request
   * @throws Exception
   */
  void create(ServletWebRequest request) throws Exception;
}
