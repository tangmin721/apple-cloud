package com.cachexic.cloud.security.core.validate.code;

import com.cachexic.cloud.security.core.validate.code.entity.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 通用验证码生成器接口
 * @author tangmin
 * @date 2017-09-30 09:19:15
 */
public interface ValidateCodeGenerator {
  ValidateCode generate(ServletWebRequest request);
}
