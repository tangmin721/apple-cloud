package com.cachexic.cloud.common.base.validator.exceptions;

import com.cachexic.cloud.common.exceptions.BizException;

/**
 * @author tangmin
 * @Description: 校验信息的异常处理
 * @date 2017-09-14 09:34:14
 */
public class ValidBizException extends BizException{
    private static final long serialVersionUID = -4580632478681261355L;

    /**
     * 构造方法
     * @param _enum
     */
    public ValidBizException(ValidBizExceptionEnum _enum){
        super(_enum.getCode(), _enum.getMsg());
    }

    public ValidBizException(int code,String msg){
        super(code,msg);
    }

}
