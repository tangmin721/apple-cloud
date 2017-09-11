package com.gasq.cloud.consumer.${CONFIG.serverName}.controller;

import com.gasq.cloud.common.result.Result;
import com.gasq.cloud.common.utils.json.JsonUtils;
import ${entity.fullClassName};
import ${entity.fullClassName}Query;
import com.gasq.cloud.feign.${CONFIG.serverName}.feign.${entity.className}Feign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@RestController
@RequestMapping("/${CONFIG.requestMapPath}")
public class ${entity.className}WebController{

    @Autowired
    private ${entity.className}Feign ${entity.firstLowName}Feign;

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("list")
    public Result<List<${entity.className}>> list(@RequestBody ${entity.className}Query query){
        return ${entity.firstLowName}Feign.list(query);
    }

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("pagination")
    public Result<Pagination<List<${entity.className}>>> pagination(@RequestBody ${entity.className}Query query){
        return ${entity.firstLowName}Feign.pagination(query);
    }

    /**
     * 根据主键查询
     * @param id
     * @return Result data:${entity.className}
     */
    @PostMapping("getById/{id}")
    public Result<${entity.className}> getById(@PathVariable <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id){
        return ${entity.firstLowName}Feign.getById(id);
    }

    /**
     * 根据主键ids查询
     * @param ids
     */
    @GetMapping("{ids}")
    public Result<List<${entity.className}>> getByIds(@PathVariable("ids") String ids){
        return ${entity.firstLowName}Feign.getByIds(ids);
    }

    /**
     * 新增方法
     * @param entity
     */
    @PostMapping
    public Result save(@RequestBody ${entity.className} entity){
        return ${entity.firstLowName}Feign.save(entity);
    }

    /**
     * 修改方法
     * @param entity
     */
    @PostMapping
    public Result update(@RequestBody ${entity.className} entity){
        return ${entity.firstLowName}Feign.update(entity);
    }

    /**
     * 根据Id删除
     * @param id
     */
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") Long id){
        return ${entity.firstLowName}Feign.deleteById(id);
    }

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     * @return Result data: String
     */
    @DeleteMapping("{ids}")
    public Result deleteByIds(@PathVariable("ids") String ids){
        return ${entity.firstLowName}Feign.deleteByIds(ids);
    }
}
