package com.cachexic.cloud.security.core.validate.code;

import com.cachexic.cloud.security.core.config.enums.ValidateCodeType;
import com.cachexic.cloud.security.core.validate.exceptions.ValidateCodeException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 校验码处理器，封装不同校验码的处理逻辑
 * 封装图片验证码、短信验证码 两种类型处理代码
 * @author tangmin
 * @date 2017-10-01 21:54:29
 */
@Component
public class ValidateCodeProcessorHolder {

	@Autowired
	private Map<String, ValidateCodeProcessor> validateCodeProcessors;

	public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
		return findValidateCodeProcessor(type.toString().toLowerCase());
	}

	public ValidateCodeProcessor findValidateCodeProcessor(String type) {
		String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
		ValidateCodeProcessor processor = validateCodeProcessors.get(name);
		if (processor == null) {
			throw new ValidateCodeException("验证码处理器" + name + "不存在");
		}
		return processor;
	}

}
