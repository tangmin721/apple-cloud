package com.cachexic.cloud.feign.order.feign;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.feign.order.entity.query.TeacherQuery;
import com.cachexic.cloud.feign.order.feign.fallback.TeacherFeignFallback;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 教师测试实体管理
 *
 * @author tangmin
 * @date 2017-09-27 14:42:38
 */
@FeignClient(name = "provider-order", path = "/teacher", fallbackFactory = TeacherFeignFallback.class)
public interface TeacherFeign {

  /**
   * List
   */
  @PostMapping("list")
  Result<List<Teacher>> list(@RequestBody TeacherQuery query);

  /**
   * 分页查询
   */
  @PostMapping("pagination")
  Result<Pagination<Teacher>> pagination(@RequestBody TeacherQuery query);

  /**
   * 根据主键查询
   */
  @GetMapping("id/{id}")
  Result<Teacher> getById(@PathVariable("id") Long id);

  /**
   * 根据主键ids查询
   */
  @GetMapping("ids/{ids}")
  Result<List<Teacher>> getByIds(@PathVariable("ids") String ids);

  /**
   * 新增方法
   */
  @PostMapping
  Result save(@RequestBody Teacher entity);

  /**
   * 修改方法
   */
  @PutMapping
  Result update(@RequestBody Teacher entity);

  /**
   * 根据Id删除
   */
  @DeleteMapping("id/{id}")
  Result deleteById(@PathVariable("id") Long id);

  /**
   * 根据ids删除，id逗号隔开
   */
  @DeleteMapping("ids/{ids}")
  Result deleteByIds(@PathVariable("ids") String ids);
}
