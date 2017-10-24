package com.cachexic.cloud.web.backstage.controller.demo;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;
import com.cachexic.cloud.feign.system.feign.DemoFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: DEMO管理  /system
 * @author tangmin
 * @date 2017-10-24 10:32:30
 */
@Api(description = "DEMO管理")
@RestController
@RequestMapping("/demo")
public class DemoWebController{

  @Autowired
  private DemoFeign demoFeign;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @PostMapping("list")
  public Result<List<Demo>> list(@RequestBody DemoQuery query){
    return demoFeign.list(query);
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @PostMapping("pagination")
  public Result<Pagination<Demo>> pagination(@RequestBody DemoQuery query){
    return demoFeign.pagination(query);
  }

  @ApiOperation("getById:根据主键查询")
  @GetMapping("{id}")
  public Result<Demo> getById(@PathVariable("id") Long id){
    return demoFeign.getById(id);
  }

  @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
  @GetMapping("ids/{ids}")
  public Result<List<Demo>> getByIds(@PathVariable("ids") String ids){
    return demoFeign.getByIds(ids);
  }

  @ApiOperation("save:新增方法")
  @PostMapping
  public Result save(@RequestBody Demo entity){
    return demoFeign.save(entity);
  }

  @ApiOperation("update:修改方法")
  @PutMapping
  public Result update(@RequestBody Demo entity){
    return demoFeign.update(entity);
  }

  @ApiOperation("deleteById:根据Id删除")
  @DeleteMapping("{id}")
  public Result deleteById(@PathVariable("id") Long id){
    return demoFeign.deleteById(id);
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
  @DeleteMapping("ids/{ids}")
  public Result deleteByIds(@PathVariable("ids") String ids){
    return demoFeign.deleteByIds(ids);
  }
}
