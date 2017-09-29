package com.cachexic.cloud.feign.order.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.feign.order.entity.query.TeacherQuery;
import com.cachexic.cloud.feign.order.feign.TeacherFeign;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 教师测试实体管理  feign hystrix快速返回实现
 *
 * @author tangmin
 * @date 2017-09-27 14:42:38
 */
@Component
public class TeacherFeignFallback implements FallbackFactory<TeacherFeign> {

  @Override
  public TeacherFeign create(Throwable cause) {
    return new TeacherFeign() {

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
