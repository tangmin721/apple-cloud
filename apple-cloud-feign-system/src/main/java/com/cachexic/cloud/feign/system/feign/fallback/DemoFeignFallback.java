package com.cachexic.cloud.feign.system.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;
import com.cachexic.cloud.feign.system.feign.DemoFeign;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @Description: DEMO管理
 * @author tangmin
 * @date 2017-10-24 10:32:30
 */
@Component
public class DemoFeignFallback implements FallbackFactory<DemoFeign> {

  @Override
  public DemoFeign create(Throwable cause) {
    return new DemoFeign() {

      @Override
      public Result<List<Demo>> list(DemoQuery query) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<Pagination<Demo>> pagination(DemoQuery query) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<Demo> getById(Long id) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<List<Demo>> getByIds(String ids) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result save(Demo entity) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result update(Demo entity) {
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

      @Override
      public Result isNameNotExist(Demo entity) {
        return Result.FALLBACK(cause);
      }
    };
  }
}
