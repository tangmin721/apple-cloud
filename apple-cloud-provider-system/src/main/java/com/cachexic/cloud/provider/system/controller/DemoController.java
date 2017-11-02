package com.cachexic.cloud.provider.system.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;
import com.cachexic.cloud.feign.system.feign.DemoFeign;
import com.cachexic.cloud.provider.system.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class DemoController implements DemoFeign {

  @Autowired
  private DemoService demoService;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @Override
  public Result<List<Demo>> list(@RequestBody DemoQuery query){
    return Result.OK().setData(demoService.selectListPage(query));
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @Override
  public Result<Pagination<Demo>> pagination(@RequestBody DemoQuery query){
    return Result.OK().setData(demoService.selectListPagination(query));
  }

  @ApiOperation("getById:根据主键查询")
  @Override
  public Result<Demo> getById(@PathVariable("id") Long id){
    return Result.OK().setData(demoService.selectById(id));
  }

  @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
  @Override
  public Result<List<Demo>> getByIds(@PathVariable("ids") String ids){
    return Result.OK().setData(demoService.selectByIds(IdsUtil.listLong(ids)));
  }

  @ApiOperation("save:新增方法")
  @Override
  public Result save(@RequestBody Demo entity){
    demoService.insert(entity);
    return Result.OK("新增成功");
  }

  @ApiOperation("update:修改方法")
  @Override
  public Result update(@RequestBody Demo entity){
    demoService.update(entity);
    return Result.OK("修改成功");
  }

  @ApiOperation("deleteById:根据Id删除")
  @Override
  public Result deleteById(@PathVariable("id") Long id){
    demoService.deleteById(id);
    return Result.OK("删除成功");
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
  @Override
  public Result deleteByIds(@PathVariable("ids") String ids){
    demoService.deleteByIds(IdsUtil.listLong(ids));
    return Result.OK("删除成功");
  }

  @ApiOperation(value = "isNameNotExist:ajax校验name是否存在",notes = "true为不存在,false为存在")
  @Override
  public Result<Boolean> isNameNotExist(@RequestBody Demo entity) {
    return Result.OK().setData(demoService.isNameNotExist(entity));
  }

}
