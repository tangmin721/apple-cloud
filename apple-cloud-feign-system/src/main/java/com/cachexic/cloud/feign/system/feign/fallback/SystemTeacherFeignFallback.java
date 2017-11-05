package com.cachexic.cloud.feign.system.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.system.entity.Teacher;
import com.cachexic.cloud.feign.system.entity.query.TeacherQuery;
import com.cachexic.cloud.feign.system.feign.SystemTeacherFeign;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @Description: 教师管理
 * @author tangmin
 * @date 2017-11-05 19:47:06
 */
@Component
public class SystemTeacherFeignFallback implements FallbackFactory<SystemTeacherFeign> {

  @Override
  public SystemTeacherFeign create(Throwable cause) {
    return new SystemTeacherFeign() {

      @Override
      public Result<List<Teacher>> list(TeacherQuery query) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<Pagination<Teacher>> pagination(TeacherQuery query) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<Teacher> getById(Long id) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result<List<Teacher>> getByIds(String ids) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result save(Teacher entity) {
        return Result.FALLBACK(cause);
      }

      @Override
      public Result update(Teacher entity) {
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
