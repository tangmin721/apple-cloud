package com.cachexic.cloud.security.core.validate.code.sms;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.validate.code.entity.ValidateCode;
import com.cachexic.cloud.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码处理器
 *
 * @author zhailiang
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

  /**
   * 短信验证码发送器
   */
  @Autowired
  private SmsCodeSender smsCodeSender;

  @Override
  protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
    String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
    String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);

    Result result = smsCodeSender.send(mobile, validateCode.getCode());

    request.getResponse().setContentType("application/json;charset=UTF-8");
    request.getResponse().getWriter().write(JsonUtil.toJson(result));
  }

}
