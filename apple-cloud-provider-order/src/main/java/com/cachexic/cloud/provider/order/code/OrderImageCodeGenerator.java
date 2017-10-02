package com.cachexic.cloud.provider.order.code;

import com.cachexic.cloud.security.core.validate.code.ValidateCodeGenerator;
import com.cachexic.cloud.security.core.validate.code.entity.ImageCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 用自定义的图形验证码覆写默认图形验证码
 * @author tangmin
 * @date 2017-09-30 09:55:21
 */
//@Component("imageValidateCodeGenerator")
public class OrderImageCodeGenerator implements ValidateCodeGenerator{

  private static final Logger log = LoggerFactory.getLogger(OrderImageCodeGenerator.class);

  @Override
  public ImageCode generate(ServletWebRequest request) {
    log.debug("====>OrderImageCodeGenerator 自定义更高级的图形验证码的实现");
    return null;
  }
}
