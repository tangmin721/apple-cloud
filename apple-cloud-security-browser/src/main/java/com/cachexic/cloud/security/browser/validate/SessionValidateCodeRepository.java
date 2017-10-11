package com.cachexic.cloud.security.browser.validate;

import com.cachexic.cloud.security.core.config.enums.ValidateCodeType;
import com.cachexic.cloud.security.core.validate.code.ValidateCodeRepository;
import com.cachexic.cloud.security.core.validate.code.entity.ValidateCode;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author tangmin
 * @Description: 基于session的验证码存取器
 * @date 2017-10-11 18:43:46
 */
@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {

  /**
   * 验证码放入session时的前缀
   */
  String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

  /**
   * 操作session的工具类
   */
  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();


  @Override
  public void save(ServletWebRequest request, ValidateCode code,
      ValidateCodeType validateCodeType) {
    sessionStrategy.setAttribute(request, getSessionKey(request, validateCodeType), code);
  }

  /**
   * 构建验证码放入session时的key
   */
  private String getSessionKey(ServletWebRequest request, ValidateCodeType validateCodeType) {
    return SESSION_KEY_PREFIX + validateCodeType.toString().toUpperCase();
  }

  @Override
  public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
    return (ValidateCode) sessionStrategy
        .getAttribute(request, getSessionKey(request, validateCodeType));
  }

  @Override
  public void remove(ServletWebRequest request, ValidateCodeType codeType) {
    sessionStrategy.removeAttribute(request, getSessionKey(request, codeType));
  }

}
