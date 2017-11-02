package com.cachexic.cloud.common.exceptions;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.validator.ValidatorBean;
import com.cachexic.cloud.common.base.validator.exceptions.ValidBizException;
import com.cachexic.cloud.common.constants.SystemConst;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.common.utils.network.IpAddressUtil;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangmin
 * @Description: 统一异常处理
 * @date 2017-08-26 13:16:32
 */
@ControllerAdvice
public class ExceptionHandle {

  private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

  /**
   * 异常统一返回
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result handle(HttpServletRequest request, Exception e) {

    //当参数是一个空的 {} 时的处理
    String args = null;
    try {
      args = request.getAttribute(SystemConst.REQUEST_ARGS).toString();
      if (args.equals("{}")) {
        args = "";
      }
    } catch (Exception e1) {
      log.warn("====> ExceptionHandler get Parameter error==>" + e1.getClass());
    }

    String requestInfo = String.format(
        "====> ExceptionHandler ==>[RequestInfo:url=[%s],method=%s,ip%s,requestId=%s,requestArgs=%s],",
        request.getRequestURL(),
        request.getMethod(),
        IpAddressUtil.getRealIp(request),
        request.getAttribute(SystemConst.REQUEST_ID),
        args);

    String exceptionInfo = "[Exception info:exception class:{},errorCode:{},message:{}]";
    String logStr = requestInfo + exceptionInfo;
    //传入参数异常
    if (e instanceof org.springframework.web.bind.MissingPathVariableException) {
      return getFailResult(e, BizExceptionEnum.REQUEST_PATH_BING_ERROR, logStr);
    } else if (e instanceof org.springframework.web.HttpRequestMethodNotSupportedException) {
      return getFailResult(e, BizExceptionEnum.REQUEST_METHOD_ERROR, logStr);
    } else if (e instanceof org.springframework.web.method.annotation.MethodArgumentTypeMismatchException) {
      return getFailResult(e, BizExceptionEnum.PARAMETER_ERROR, logStr);
    } else if (e instanceof org.springframework.http.converter.HttpMessageNotReadableException) {
      return getFailResult(e, BizExceptionEnum.PARAMETER_ERROR, logStr);
      //valid异常
    } else if (e instanceof ValidBizException) {
      ValidBizException ex = (ValidBizException) e;
      String message = ex.getMessage();
      return getFailResult(e, ex.getCode(), ex.getMessage(), logStr).setData(JsonUtil.toList(message, ValidatorBean.class));
      //再写总的业务异常
    } else if (e instanceof BizException) {
      BizException ex = (BizException) e;
      return getFailResult(e, ex.getCode(), ex.getMessage(), logStr);
    } else {
      return getFailResult(e, BizExceptionEnum.SYS_EXCEPTION, logStr);
    }
  }

  private Result getFailResult(Exception e, int code, String msg, String logStr) {
    String errorMsg = msg;
    if (log.isDebugEnabled()) {
      e.printStackTrace();
    }
    log.warn(logStr, e.getClass().getName(), code, errorMsg);
    return Result.FAIL(code, errorMsg);
  }

  private Result getFailResult(Exception e, BizExceptionEnum bizExceptionEnum, String logStr) {
    String errorMsg = BizExceptionEnum.PARAMETER_ERROR.getMsg();
    if(log.isDebugEnabled()){
      errorMsg += ":" + e.getMessage();
    }
    log.warn(logStr, e.getClass().getName(), bizExceptionEnum.getCode(), errorMsg);
    return Result.FAIL(bizExceptionEnum);
  }
}
