package com.cachexic.cloud.common.base.validator;

import java.io.Serializable;

/**
 * @author tangmin
 * @Description:
 * @date 2017-09-11 13:48:22
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
