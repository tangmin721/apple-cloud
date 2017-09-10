package com.gasq.cloud.feign.${CONFIG.serverName}.feign.fallback;

import com.gasq.cloud.common.constants.AppConstant;
import com.gasq.cloud.common.result.Result;
import ${entity.fullClassName};
import ${entity.fullClassName}Query;
import com.gasq.cloud.feign.${CONFIG.serverName}.feign.${entity.className}FeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ${CONFIG.modelName}管理  Feign利用fallbackFactory属性，处理fallback异常
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Component
public class ${entity.className}FeignClientFallbackFactory implements FallbackFactory<${entity.className}FeignClient> {

    private static final Logger log = LoggerFactory.getLogger(${entity.className}FeignClientFallbackFactory.class);

    @Override
    public ${entity.className}FeignClient create(Throwable cause) {
        //一进fallback就能拦截到异常
        log.warn("Fallback Exception class[{}],errorCode:[{}],message:[{}]", cause.getClass().getName(),AppConstant.FEIGN_CLIENT_FALLBACK_CODE,cause.getMessage());

        return new ${entity.className}FeignClientWithFallbackFactory() {

            Result result = Result.FAIL(AppConstant.FEIGN_CLIENT_FALLBACK_CODE, AppConstant.FEIGN_CLIENT_FALLBACK_MSG+":"+cause.getMessage());

            @Override
            public Result listPage(${entity.className}Query query) {
                return result;
            }

            @Override
            public Result listPagination(${entity.className}Query query) {
                return result;
            }

            @Override
            public Result getById(<#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id) {
                return result;
            }

            @Override
            public Result getByIds(String ids) {
                return result;
            }

            @Override
            public Result save(${entity.className} entity) {
                return result;
            }

            @Override
            public Result deleteById(<#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id) {
                return result;
            }

            @Override
            public Result deleteByIds(String ids) {
                return result;
            }
        };
    }
}
