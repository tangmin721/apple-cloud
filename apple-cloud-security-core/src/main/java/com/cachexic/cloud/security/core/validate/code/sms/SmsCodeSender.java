package com.cachexic.cloud.security.core.validate.code.sms;

/**
 * @Description: 短信验证码发送接口
 * @author tangmin
 * @date 2017-09-30 12:07:35
 */
public interface SmsCodeSender {

  void send(String mobile, String code);
}
