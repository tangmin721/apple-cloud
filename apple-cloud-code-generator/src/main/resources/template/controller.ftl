package com.gasq.cloud.provider.${CONFIG.serverName}.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import ${entity.fullClassName};
import ${entity.fullQueryClassName};
import com.cachexic.cloud.provider.${CONFIG.serverName}.service.${entity.className}Service;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Api(description = "${CONFIG.modelName}管理")
@RestController
@RequestMapping("/${CONFIG.requestMapPath}")
public class ${entity.className}Controller implements ${entity.className}Feign{

    @Autowired
    private ${entity.className}Service ${entity.firstLowName}Service;

    @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
    @Override
    public Result<List<${entity.className}>> list(@RequestBody ${entity.className}Query query){
        return Result.OK().setData(${entity.firstLowName}Service.selectListPage(query));
    }

    @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
    @Override
    public Result<Pagination<${entity.className}>> pagination(@RequestBody ${entity.className}Query query){
        return Result.OK().setData(${entity.firstLowName}Service.selectListPagination(query));
    }

    @ApiOperation("getById:根据主键查询")
    @Override
    public Result<${entity.className}> getById(@PathVariable("id") Long id){
        return Result.OK().setData(${entity.firstLowName}Service.selectById(id));
    }

    @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
    @Override
    public Result<List<${entity.className}>> getByIds(@PathVariable("ids") String ids){
        return Result.OK().setData(${entity.firstLowName}Service.selectByIds(IdsUtil.listLong(ids)));
    }

    @ApiOperation("save:新增方法")
    @Override
    public Result save(@RequestBody ${entity.className} entity){
        ${entity.firstLowName}Service.insert(entity);
        return Result.OK("新增成功");
    }

    @ApiOperation("update:修改方法")
    @Override
    public Result update(@RequestBody ${entity.className} entity){
        ${entity.firstLowName}Service.update(entity);
        return Result.OK("修改成功");
    }

    @ApiOperation("deleteById:根据Id删除")
    @Override
    public Result deleteById(@PathVariable("id") Long id){
        ${entity.firstLowName}Service.<#if CONFIG.extendBaseEntity=="true">deleteById</#if><#if CONFIG.extendBaseEntity=="false">removeById</#if>(id);
        return Result.OK("删除成功");
    }

    @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
    @Override
    public Result deleteByIds(@PathVariable("ids") String ids){
        ${entity.firstLowName}Service.<#if CONFIG.extendBaseEntity=="true">deleteByIds</#if><#if CONFIG.extendBaseEntity=="false">removeByIds</#if>(IdsUtil.listLong(ids));
        return Result.OK("删除成功");
    }

}
