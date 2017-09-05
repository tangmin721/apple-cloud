package com.gasq.cloud.feign.${CONFIG.serverName}.feign;

import com.gasq.cloud.common.result.Result;
import ${entity.fullClassName};
import ${entity.fullClassName}Query;
import com.gasq.cloud.feign.${CONFIG.serverName}.feign.fallback.${entity.className}FeignClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
* ${CONFIG.modelName}管理
* @author tangmin
* @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
*/
@FeignClient(name = "s2f-cloud-provider-${CONFIG.serverName}", path = "/${CONFIG.requestMapPath}", fallbackFactory = ${entity.className}FeignClientFallbackFactory.class)
public interface ${entity.className}FeignClient{

    /**
    * 分页查询
    * @param query
    * @return Result data：List<${entity.className}>
    */
    @RequestMapping(value = "listPage",method = RequestMethod.POST)
    Result listPage(@RequestBody ${entity.className}Query query);

    /**
    * 分页查询
    * @param query
    * @return Result data：Pagination
    */
    @RequestMapping(value = "listPagination",method = RequestMethod.POST)
    Result listPagination(@RequestBody ${entity.className}Query query);

    /**
    * 根据主键查询
    * @param id
    * @return Result data:${entity.className}
    */
    @RequestMapping(value = "getById/{id}",method = RequestMethod.POST)
    Result getById(@PathVariable("id") <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id);

    /**
    * 根据主键ids查询
    * @param ids
    * @return Result data: List<${entity.className}>
    */
    @RequestMapping(value = "getByIds/{ids}",method = RequestMethod.POST)
    Result getByIds(@PathVariable("ids") String ids);

    /**
    * 保存方法，合并了新增修改。
    * @param entity
    * @return Result data: String
    */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    Result save(@RequestBody ${entity.className} entity);

    /**
    * 根据Id删除
    * @param id
    * @return Result data: String
    */
    @RequestMapping(value = "deleteById/{id}",method = RequestMethod.DELETE)
    Result deleteById(@PathVariable("id") <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id);

    /**
    * 根据ids删除，id逗号隔开
    * @param ids
    * @return Result data: String
    */
    @RequestMapping(value = "deleteByIds/{ids}",method = RequestMethod.DELETE)
    Result deleteByIds(@PathVariable("ids") String ids);
}
