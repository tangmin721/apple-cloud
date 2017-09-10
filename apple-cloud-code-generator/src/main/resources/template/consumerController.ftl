package com.gasq.cloud.consumer.${CONFIG.serverName}.controller;

import com.gasq.cloud.common.result.Result;
import com.gasq.cloud.common.utils.json.JsonUtils;
import ${entity.fullClassName};
import ${entity.fullClassName}Query;
import com.gasq.cloud.feign.${CONFIG.serverName}.feign.${entity.className}FeignClient;
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
public class ${entity.className}ConsumerController{

    private final static Logger log = LoggerFactory.getLogger(${entity.className}ConsumerController.class);

    @Autowired
    private ${entity.className}FeignClient ${entity.firstLowName}FeignClient;

    /**
     * 分页查询
     * @param query
     * @return Result data：List<${entity.className}>
     */
    @PostMapping("listPage")
    public Result listPage(@RequestBody ${entity.className}Query query){
        return ${entity.firstLowName}FeignClient.listPage(query);
    }

    /**
     * 分页查询
     * @param query
     * @return Result data：Pagination
     */
    @PostMapping("listPagination")
    public Result listPagination(@RequestBody ${entity.className}Query query){
        return ${entity.firstLowName}FeignClient.listPagination(query);
    }

    /**
     * 根据主键查询
     * @param id
     * @return Result data:${entity.className}
     */
    @PostMapping("getById/{id}")
    public Result getById(@PathVariable <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id){
        return ${entity.firstLowName}FeignClient.getById(id);
    }

    /**
     * 根据主键ids查询
     * @param ids
     * @return Result data: List<${entity.className}>
     */
    @PostMapping("getByIds/{ids}")
    public Result getByIds(@PathVariable String ids){
        return ${entity.firstLowName}FeignClient.getByIds(ids);
    }

    /**
     * 保存方法，合并了新增修改。
     * @param entity
     * @return Result data: String
     */
    @PostMapping("save")
    public Result save(@RequestBody ${entity.className} entity){
        log.info("save ${entity.className}{} -->", JsonUtils.toJson(entity));
        return ${entity.firstLowName}FeignClient.save(entity);
    }

    /**
     * 根据Id删除
     * @param id
     * @return Result data: String
     */
    @DeleteMapping("deleteById/{id}")
    public Result deleteById(@PathVariable <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id){
        return ${entity.firstLowName}FeignClient.deleteById(id);
    }

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     * @return Result data: String
     */
    @DeleteMapping("deleteByIds/{ids}")
    public Result deleteByIds(@PathVariable String ids){
        return ${entity.firstLowName}FeignClient.deleteByIds(ids);
    }
}
