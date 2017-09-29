package com.cachexic.cloud.common.aop;

import com.cachexic.cloud.common.constants.SystemConst;
import com.cachexic.cloud.common.utils.id.UUIDUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.common.utils.network.IpAddressUtil;
import com.google.common.collect.Lists;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author tangmin
 * @version V1.0
 * @Title: HttpAspect.java
 * @Package com.cachexic.sjdbc.common.aop
 * @Description: Http切面, 开发调试
 * @date 2017-08-26 13:07:27
 */
@Aspect
@Component
@Profile({"dev", "test"})
public class HttpAspect {

  private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

  /**
   * 定义一个切面
   */
  @Pointcut("execution(public * com.cachexic.cloud..*.controller..*.*(..))")
  public void log() {
  }

  /**
   * 指定切面方法
   */
  @Before("log()")
  public void doBefore(JoinPoint joinpoint) {

    try {
      log.info("====> before controller...");
      ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
          .getRequestAttributes();
      HttpServletRequest request = attributes.getRequest();

      String uuid = UUIDUtil
          .get32UUID();//暂时在这里面设置requestId，如果是分布式springCloud，可以在zuul过滤器设置： ctx.addZuulRequestHeader(SystemConst.REQUEST_ID,,uuid);
      request.setAttribute(SystemConst.REQUEST_ID, uuid);

      List<Map<String, String>> headsMapList = Lists.newArrayList();

      Enumeration<String> names = request.getHeaderNames();
      while (names.hasMoreElements()) {
        String head = names.nextElement();
        HashMap<String, String> map = new HashMap<>();
        map.put(head, request.getHeader(head));
        headsMapList.add(map);
      }

      //设置参数，以便在异常处理的时候日志里打印
      request.setAttribute(SystemConst.REQUEST_ARGS, JsonUtil.toJson(joinpoint.getArgs()));

      log.info(
          "====> url=[{}],method={},ip={},class_method={},requestId={},requestHead={},requestArgs={}",
          request.getRequestURL(),
          request.getMethod(),
          IpAddressUtil.getRealIp(request),
          joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature()
              .getName(),
          uuid,
          JsonUtil.toJson(headsMapList),
          JsonUtil.toJson(joinpoint.getArgs())
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @After("log()")
  public void doAfter() {
    log.info("====> do after controller...");
  }

  /**
   * 获取切面方法返回结果
   */
  @AfterReturning(returning = "object", pointcut = "log()")
  public void returning(Object object) {
    try {
      log.info("====> response={}", JsonUtil.toJson(object));
    } catch (Exception e) {
      e.printStackTrace();
    }
    log.info(
        "****************************************[ request  end  ]****************************************");
  }

  /**
   * 记录一次请求的耗时时间，通过环绕切面
   */
  @Around(value = "log()")
  public Object doAroundMethodController(ProceedingJoinPoint point) throws Throwable {
    Object result = null;
    try {
      log.info(
          "****************************************[ request start ]****************************************");
      //if(){ 判断权限
      long start = System.nanoTime();
      //拦截的实体类
      Object target = point.getTarget();
      //拦截的方法名称
      String methodName = point.getSignature().getName();

      result = point.proceed();
      log.info("====>Class:" + target.getClass() + ",Method: " + methodName + "====>执行耗时 : 【"
          + (System.nanoTime() - start) / (1000 * 1000) + " 毫秒】 ");
      //}

      return result;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    return result;
  }
}