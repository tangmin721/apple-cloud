package com.gasq.cloud.feign.${CONFIG.serverName}.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import ${entity.fullClassName};
import ${entity.fullQueryClassName};
import com.cachexic.cloud.feign.${CONFIG.serverName}.feign.${entity.className}FeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ${CONFIG.modelName}管理  feign hystrix快速返回实现
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Component
public class ${entity.className}FeignFallback implements FallbackFactory<${entity.className}Feign> {

    @Override
    public ${entity.className}Feign create(Throwable cause) {
        return new ${entity.className}Feign() {

            @Override
            public Result<List<${entity.className}>> list(${entity.className}Query query) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<Pagination<${entity.className}>> pagination(${entity.className}Query query) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<${entity.className}> getById(Long id) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<List<${entity.className}>> getByIds(String ids) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result save(${entity.className} entity) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result update(${entity.className} entity) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result deleteById(Long id) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result deleteByIds(String ids) {
                return Result.FALLBACK(cause);
            }
        };
    }
}
