package com.gasq.cloud.consumer.${CONFIG.serverName}.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import ${entity.fullClassName};
import ${entity.fullQueryClassName};
import com.cachexic.cloud.feign.${CONFIG.serverName}.feign.${entity.className}Feign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: ${CONFIG.modelName}管理  /${CONFIG.serverName}
 * @author ${CONFIG.author}
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Api(description = "${CONFIG.modelName}管理")
@RestController
@RequestMapping("/${CONFIG.requestMapPath}")
public class ${entity.className}WebController{

  @Autowired
  private ${entity.className}Feign ${entity.firstLowName}Feign;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @PostMapping("list")
  public Result<List<${entity.className}>> list(@RequestBody ${entity.className}Query query){
    return ${entity.firstLowName}Feign.list(query);
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @PostMapping("pagination")
  public Result<Pagination<${entity.className}>> pagination(@RequestBody ${entity.className}Query query){
    return ${entity.firstLowName}Feign.pagination(query);
  }

  @ApiOperation("getById:根据主键查询")
  @GetMapping("{id:\\d+}")
  public Result<${entity.className}> getById(@PathVariable("id") Long id){
    return ${entity.firstLowName}Feign.getById(id);
  }

  @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
  @GetMapping("ids/{ids}")
  public Result<List<${entity.className}>> getByIds(@PathVariable("ids") String ids){
    return ${entity.firstLowName}Feign.getByIds(ids);
  }

  @ApiOperation("save:新增方法")
  @PostMapping
  public Result save(@RequestBody ${entity.className} entity){
    return ${entity.firstLowName}Feign.save(entity);
  }

  @ApiOperation("update:修改方法")
  @PutMapping
  public Result update(@RequestBody ${entity.className} entity){
    return ${entity.firstLowName}Feign.update(entity);
  }

  @ApiOperation("deleteById:根据Id删除")
  @DeleteMapping("{id:\\d+}")
  public Result deleteById(@PathVariable("id") Long id){
    return ${entity.firstLowName}Feign.deleteById(id);
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
  @DeleteMapping("ids/{ids}")
  public Result deleteByIds(@PathVariable("ids") String ids){
    return ${entity.firstLowName}Feign.deleteByIds(ids);
  }
}
