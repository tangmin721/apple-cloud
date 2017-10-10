package com.cachexic.cloud.feign.eshop.exceptions;

import com.cachexic.cloud.common.exceptions.BizException;

/**
 * @author tangmin
 * @Description: eshop的异常信息
 * @date 2017-09-14 09:35:43
 */
public class EshopBizException extends BizException {

  private static final long serialVersionUID = -4580632478681261355L;

  /**
   * 构造方法
   */
  public EshopBizException(EshopBizExceptionEnum _enum) {
    super(_enum.getCode(), _enum.getMsg());
  }
}
