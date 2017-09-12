package com.cachexic.cloud.feign.msg.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;
import com.cachexic.cloud.feign.msg.feign.MsgPersistentFeign;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 持久化消息管理  feign hystrix快速返回实现
 * @author tangmin
 * @date 2017-09-12 19:01:50
 */
@Component
public class MsgPersistentFeignFallback implements FallbackFactory<MsgPersistentFeign> {

    @Override
    public MsgPersistentFeign create(Throwable cause) {
        return new MsgPersistentFeign() {

            @Override
            public Result<List<MsgPersistent>> list(MsgPersistentQuery query) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<Pagination<MsgPersistent>> pagination(MsgPersistentQuery query) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<MsgPersistent> getById(Long id) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<List<MsgPersistent>> getByIds(String ids) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result save(MsgPersistent entity) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result update(MsgPersistent entity) {
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
