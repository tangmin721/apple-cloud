package com.cachexic.cloud.common.validator.annotations;

import java.io.Serializable;

/**
 * @Description: 校验结果
 * @author: tangm
 * @date: 2016年2月20日 
 * @version: 1.0
 */
public class ValidatorBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 字段名
	 */
	private String filed;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
