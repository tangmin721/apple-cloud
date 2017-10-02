/**
 *
 */
package com.cachexic.cloud.security.core.config.enums;

import com.cachexic.cloud.security.core.config.contants.SecurityConstants;

/**
 * @author tangmin
 * @Description: 验证码类型
 * @date 2017-10-01 22:05:53
 */
public enum ValidateCodeType {

  /**
   * 短信验证码
   */
  SMS {
    @Override
    public String getParamNameOnValidate() {
      return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
    }
  },
  /**
   * 图片验证码
   */
  IMAGE {
    @Override
    public String getParamNameOnValidate() {
      return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
    }
  };

  /**
   * 校验时从请求中获取的参数的名字
   */
  public abstract String getParamNameOnValidate();

}
