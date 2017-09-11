package com.gasq.cloud.feign.${CONFIG.serverName}.feign;

import com.cachexic.cloud.common.base.Result;
import ${entity.fullClassName};
import ${entity.fullQueryClassName};
import com.cachexic.cloud.feign.${CONFIG.serverName}.feign.fallback.${entity.className}FeignClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@FeignClient(name = "provider-${CONFIG.serverName}", path = "/${CONFIG.requestMapPath}", fallbackFactory = ${entity.className}FeignFallback.class)
public interface ${entity.className}Feign{

    /**
     * List
     * @param query
     */
    @PostMapping("list")
    Result<List<${entity.className}>> list(@RequestBody ${entity.className}Query query);

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("pagination")
    Result<Pagination<${entity.className}>> pagination(@RequestBody ${entity.className}Query query);

    /**
     * 根据主键查询
     * @param id
     */
    @GetMapping("{id}")
    Result<${entity.className}> getById(@PathVariable("id") Long id);

    /**
     * 根据主键ids查询
     * @param ids
     */
    @GetMapping("ids/{ids}")
    Result<List<${entity.className}>> getByIds(@PathVariable("ids") String ids);

    /**
     * 新增方法
     * @param entity
     */
    @PostMapping
    Result save(@RequestBody ${entity.className} entity);

    /**
     * 修改方法
     * @param entity
     */
    @PutMapping
    Result update(@RequestBody ${entity.className} entity);

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
