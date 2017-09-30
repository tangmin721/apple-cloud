package com.cachexic.cloud.security.core.validate.code.sms;

import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import com.cachexic.cloud.security.core.validate.code.ValidateCodeGenerator;
import com.cachexic.cloud.security.core.validate.code.entity.ValidateCode;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 短信验证码生成器
 * @author tangmin
 * @date 2017-09-30 09:32:39
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

  @Autowired
  private SecurityProperties securityProperties;

  @Override
  public ValidateCode generate(ServletWebRequest request) {
    String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
    return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
  }

}
