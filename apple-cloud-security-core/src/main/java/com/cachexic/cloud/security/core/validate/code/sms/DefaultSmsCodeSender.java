package com.cachexic.cloud.security.core.validate.code.sms;

import com.cachexic.cloud.common.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tangmin
 * @Description: 默认的短信发送接口
 * @date 2017-09-30 12:09:49
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

  private static final Logger log = LoggerFactory.getLogger(DefaultSmsCodeSender.class);

  @Override
  public Result send(String mobile, String code) {
    log.debug("向手机:[" + mobile + "[发送短信验证码:[" + code + "]");
    return Result.OK();
  }
}
