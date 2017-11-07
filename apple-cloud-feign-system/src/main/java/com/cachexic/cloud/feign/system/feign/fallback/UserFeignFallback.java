package com.cachexic.cloud.feign.system.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.system.entity.User;
import com.cachexic.cloud.feign.system.entity.query.UserQuery;
import com.cachexic.cloud.feign.system.feign.UserFeign;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @Description: 用户管理
 * @author tangmin
 * @date 2017-11-07 15:38:01
 */
@Component
public class UserFeignFallback implements FallbackFactory<UserFeign> {

  @Override
  public UserFeign create(Throwable cause) {
    return new UserFeign() {

      @Override
      public Result<List<User>> list(UserQuery query) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<Pagination<User>> pagination(UserQuery query) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<User> getById(Long id) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<List<User>> getByIds(String ids) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result save(User entity) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result update(User entity) {
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
