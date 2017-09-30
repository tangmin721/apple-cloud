package com.cachexic.cloud.security.core.validate.code.impl;

import com.cachexic.cloud.security.core.validate.code.ValidateCodeGenerator;
import com.cachexic.cloud.security.core.validate.code.ValidateCodeProcessor;
import com.cachexic.cloud.security.core.validate.code.entity.ValidateCode;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: ValidateCodeProcessor的抽象实现
 * @author tangmin
 * @date 2017-09-30 12:50:28
 */
public abstract class AbstractValidateCodeProcessor <C extends ValidateCode> implements
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
   * @param request
   * @throws Exception
   */
  @Override
  public void create(ServletWebRequest request) throws Exception {
    C validateCode = generate(request);
    save(request, validateCode);
    send(request, validateCode);
  }

  /**
   * 生成校验码
   *
   * @param request
   * @return
   */
  @SuppressWarnings("unchecked")
  private C generate(ServletWebRequest request) {
    String type = getProcessorType(request);
    ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type+"CodeGenerator");
    return (C) validateCodeGenerator.generate(request);
  }

  /**
   * 保存校验码
   *
   * @param request
   * @param validateCode
   */
  private void save(ServletWebRequest request, C validateCode) {
    sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX+getProcessorType(request).toUpperCase(), validateCode);
  }

  /**
   * 发送校验码，由子类实现
   *
   * @param request
   * @param validateCode
   * @throws Exception
   */
  protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;


  /**
   * 根据请求的url获取校验码的类型
   * @param request
   * @return
   */
  private String getProcessorType(ServletWebRequest request) {
    return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
  }

}
