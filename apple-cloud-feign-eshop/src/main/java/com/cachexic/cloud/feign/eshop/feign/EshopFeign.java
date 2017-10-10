package com.cachexic.cloud.feign.eshop.feign;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.eshop.entity.Eshop;
import com.cachexic.cloud.feign.eshop.entity.query.EshopQuery;
import com.cachexic.cloud.feign.eshop.feign.fallback.EshopFeignFallback;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description: e店管理
 * @author tangmin
 * @date 2017-10-10 21:00:52
 */
@FeignClient(name = "provider-eshop", path = "/eshop", fallbackFactory = EshopFeignFallback.class)
public interface EshopFeign{

  /**
   * List
   * @param query
   */
  @PostMapping("list")
  Result<List<Eshop>> list(@RequestBody EshopQuery query);

  /**
   * 分页查询
   * @param query
   */
  @PostMapping("pagination")
  Result<Pagination<Eshop>> pagination(@RequestBody EshopQuery query);

  /**
   * 根据主键查询
   * @param id
   */
  @GetMapping("{id}")
  Result<Eshop> getById(@PathVariable("id") Long id);

  /**
   * 根据主键ids查询
   * @param ids
   */
  @GetMapping("ids/{ids}")
  Result<List<Eshop>> getByIds(@PathVariable("ids") String ids);

  /**
   * 新增方法
   * @param entity
   */
  @PostMapping
  Result save(@RequestBody Eshop entity);

  /**
   * 修改方法
   * @param entity
   */
  @PutMapping
  Result update(@RequestBody Eshop entity);

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
