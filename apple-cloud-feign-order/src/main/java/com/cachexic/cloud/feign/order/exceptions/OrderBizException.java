package com.cachexic.cloud.feign.order.exceptions;

import com.cachexic.cloud.common.exceptions.BizException;

/**
 * @author tangmin
 * @version V1.0
 * @Title: MsgBizException.java
 * @Package com.cachexic.cloud.feign.msg.exceptions
 * @Description: 订单模块的异常信息
 * @date 2017-09-09 17:08:09
 */
public class OrderBizException extends BizException{
    private static final long serialVersionUID = -5236996541263894704L;

    /**
     * 构造方法
     * @param _enum
     */
    public OrderBizException(OrderBizExceptionEnum _enum){
        super(_enum.getCode(), _enum.getMsg());
    }
}
