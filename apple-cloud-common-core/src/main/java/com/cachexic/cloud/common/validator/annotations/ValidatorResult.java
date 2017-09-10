package com.cachexic.cloud.common.validator.annotations;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 校验结果
 * @author: tangm
 * @date: 2016年2月20日 
 * @version: 1.0
 */
public class ValidatorResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 校验是否通过标记
	 */
	private Boolean flag = true;
	
	private List<ValidatorBean> errorObjs = Lists.newArrayList();
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<ValidatorBean> getErrorObjs() {
		return errorObjs;
	}

	public void setErrorObjs(List<ValidatorBean> errorObjs) {
		this.errorObjs = errorObjs;
	}

}
