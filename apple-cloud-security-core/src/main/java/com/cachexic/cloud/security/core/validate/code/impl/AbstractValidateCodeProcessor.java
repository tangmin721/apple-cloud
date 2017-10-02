package com.cachexic.cloud.security.core.validate.code.impl;

import com.cachexic.cloud.security.core.config.enums.ValidateCodeType;
import com.cachexic.cloud.security.core.validate.code.ValidateCodeGenerator;
import com.cachexic.cloud.security.core.validate.code.ValidateCodeProcessor;
import com.cachexic.cloud.security.core.validate.code.entity.ValidateCode;
import com.cachexic.cloud.security.core.validate.exceptions.ValidateCodeException;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author tangmin
 * @Description: ValidateCodeProcessor的抽象实现
 * @date 2017-09-30 12:50:28
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements
    ValidateCodeProcessor {

  /**
   * 操作session的工具类
   */
  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
  /**
   * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
   */
  @Autowired
  private Map<String, ValidateCodeGenerator> validateCodeGenerators;

  /**
   * create的3个步骤 创建,保存,发送
   */
  @Override
  public void create(ServletWebRequest request) throws Exception {
    C validateCode = generate(request);
    save(request, validateCode);
    send(request, validateCode);
  }

  /**
   * 发送校验码，由子类实现
   */
  protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

  /**
   * 生成校验码
   */
  @SuppressWarnings("unchecked")
  private C generate(ServletWebRequest request) {
    String type = getValidateCodeType(request).toString().toLowerCase();
    String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
    ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
    if (validateCodeGenerator == null) {
      throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
    }
    return (C) validateCodeGenerator.generate(request);
  }

  /**
   * 根据请求的url获取校验码的类型
   */
  private ValidateCodeType getValidateCodeType(ServletWebRequest request) {
    String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
    return ValidateCodeType.valueOf(type.toUpperCase());
  }

  /**
   * 保存校验码
   */
  private void save(ServletWebRequest request, C validateCode) {
    sessionStrategy.setAttribute(request, getSessionKey(request), validateCode);
  }

  /**
   * 构建验证码放入session时的key
   */
  private String getSessionKey(ServletWebRequest request) {
    return SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
  }


  @SuppressWarnings("unchecked")
  @Override
  public void validate(ServletWebRequest request) {

    ValidateCodeType processorType = getValidateCodeType(request);
    String sessionKey = getSessionKey(request);

    C codeInSession = (C) sessionStrategy.getAttribute(request, sessionKey);

    String codeInRequest;
    try {
      codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
          processorType.getParamNameOnValidate());
    } catch (ServletRequestBindingException e) {
      throw new ValidateCodeException("获取验证码的值失败");
    }

    if (StringUtils.isBlank(codeInRequest)) {
      throw new ValidateCodeException(processorType + "验证码的值不能为空");
    }

    if (codeInSession == null) {
      throw new ValidateCodeException(processorType + "验证码不存在");
    }

    if (codeInSession.isExpried()) {
      sessionStrategy.removeAttribute(request, sessionKey);
      throw new ValidateCodeException(processorType + "验证码已过期");
    }

    if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
      throw new ValidateCodeException(processorType + "验证码不匹配");
    }

    sessionStrategy.removeAttribute(request, sessionKey);
  }


}
