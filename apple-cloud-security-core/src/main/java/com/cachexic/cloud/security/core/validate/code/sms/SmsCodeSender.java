package com.cachexic.cloud.security.core.validate.code.sms;

import com.cachexic.cloud.common.base.Result;

/**
 * @Description: 短信验证码发送接口
 * @author tangmin
 * @date 2017-09-30 12:07:35
 */
public interface SmsCodeSender {

  Result send(String mobile, String code);
}
