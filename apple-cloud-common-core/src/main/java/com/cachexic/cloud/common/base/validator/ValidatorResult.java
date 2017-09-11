package com.cachexic.cloud.common.base.validator;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

/**
 * @author tangmin
 * @Description: 校验结果
 * @date 2017-09-11 13:48:10
 */
public class ValidatorResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 校验是否通过标记
     */
    private Boolean flag = true;

    private List<ValidatorBean> errorObjs = Lists.newArrayList();

    private String errorStr;

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

    public String getErrorStr() {
        return errorStr;
    }

    public void setErrorStr(String errorStr) {
        this.errorStr = errorStr;
    }
}
