package com.cachexic.cloud.common.aop;

import com.cachexic.cloud.common.constants.SystemConst;
import com.cachexic.cloud.common.utils.id.UUIDUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.common.utils.network.IpAddressUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangmin
 * @version V1.0
 * @Title: HttpAspect.java
 * @Package com.cachexic.sjdbc.common.aop
 * @Description: Http拦截器
 * @date 2017-08-26 13:07:27
 */
@Aspect
@Component
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
        log.info("****************************************[ request start ]****************************************");
        log.info("====> before controller...");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String uuid = UUIDUtil.get32UUID();//暂时在这里面设置requestId，如果是分布式springCloud，可以在zuul过滤器设置： ctx.addZuulRequestHeader(SystemConst.REQUEST_ID,,uuid);
        request.setAttribute(SystemConst.REQUEST_ID, uuid);

        //设置参数，以便在异常处理的时候日志里打印
        request.setAttribute(SystemConst.REQUEST_ARGS, JsonUtil.toJson(joinpoint.getArgs()));

        log.info("====> url=[{}],method={},ip={},class_method={},requestId={},requestArgs={}",
                request.getRequestURL(),
                request.getMethod(),
                IpAddressUtil.getRealIp(request),
                joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature().getName(),
                uuid,
                JsonUtil.toJson(joinpoint.getArgs())
        );
    }

    @After("log()")
    public void doAfter() {
        log.info("====> do after controller...");
    }

    /**
     * 获取切面方法返回结果
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void returning(Object object) {
        log.info("====> response={}", JsonUtil.toJson(object));
        log.info("****************************************[ request  end  ]****************************************");
    }
}