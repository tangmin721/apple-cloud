package com.cachexic.cloud.feign.eshop.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.eshop.entity.Eshop;
import com.cachexic.cloud.feign.eshop.entity.query.EshopQuery;
import com.cachexic.cloud.feign.eshop.feign.EshopFeign;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @Description: e店管理
 * @author tangmin
 * @date 2017-10-10 21:00:52
 */
@Component
public class EshopFeignFallback implements FallbackFactory<EshopFeign> {

  @Override
  public EshopFeign create(Throwable cause) {
    return new EshopFeign() {

      @Override
      public Result<List<Eshop>> list(EshopQuery query) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<Pagination<Eshop>> pagination(EshopQuery query) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<Eshop> getById(Long id) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<List<Eshop>> getByIds(String ids) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result save(Eshop entity) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result update(Eshop entity) {
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
