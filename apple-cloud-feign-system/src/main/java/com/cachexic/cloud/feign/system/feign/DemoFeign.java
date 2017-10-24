package com.cachexic.cloud.feign.system.feign;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;
import com.cachexic.cloud.feign.system.feign.fallback.DemoFeignFallback;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description: DEMO管理
 * @author tangmin
 * @date 2017-10-24 10:32:30
 */
@FeignClient(name = "provider-system", path = "/demo", fallbackFactory = DemoFeignFallback.class)
public interface DemoFeign{

  /**
   * List
   * @param query
   */
  @PostMapping("list")
  Result<List<Demo>> list(@RequestBody DemoQuery query);

  /**
   * 分页查询
   * @param query
   */
  @PostMapping("pagination")
  Result<Pagination<Demo>> pagination(@RequestBody DemoQuery query);

  /**
   * 根据主键查询
   * @param id
   */
  @GetMapping("{id}")
  Result<Demo> getById(@PathVariable("id") Long id);

  /**
   * 根据主键ids查询
   * @param ids
   */
  @GetMapping("ids/{ids}")
  Result<List<Demo>> getByIds(@PathVariable("ids") String ids);

  /**
   * 新增方法
   * @param entity
   */
  @PostMapping
  Result save(@RequestBody Demo entity);

  /**
   * 修改方法
   * @param entity
   */
  @PutMapping
  Result update(@RequestBody Demo entity);

  /**
   * 根据Id删除
   * @param id
   */
  @DeleteMapping("{id}")
  Result deleteById(@PathVariable("id") Long id);

  /**
   * 根据ids删除，id逗号隔开
   * @param ids
   */
  @DeleteMapping("ids/{ids}")
  Result deleteByIds(@PathVariable("ids") String ids);
}
