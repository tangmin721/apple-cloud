package com.cachexic.cloud.provider.eshop.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.eshop.entity.Eshop;
import com.cachexic.cloud.feign.eshop.entity.query.EshopQuery;
import com.cachexic.cloud.feign.eshop.feign.EshopFeign;
import com.cachexic.cloud.provider.eshop.service.EshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: e店管理  /eshop
 * @author tangmin
 * @date 2017-10-10 21:00:52
 */
@Api(description = "e店管理")
@RestController
@RequestMapping("/eshop")
public class EshopController implements EshopFeign {

  @Autowired
  private EshopService eshopService;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @Override
  public Result<List<Eshop>> list(@RequestBody EshopQuery query){
    return Result.OK().setData(eshopService.selectListPage(query));
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @Override
  public Result<Pagination<Eshop>> pagination(@RequestBody EshopQuery query){
    return Result.OK().setData(eshopService.selectListPagination(query));
  }

  @ApiOperation("getById:根据主键查询")
  @Override
  public Result<Eshop> getById(@PathVariable("id") Long id){
    return Result.OK().setData(eshopService.selectById(id));
  }

  @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
  @Override
  public Result<List<Eshop>> getByIds(@PathVariable("ids") String ids){
    return Result.OK().setData(eshopService.selectByIds(IdsUtil.listLong(ids)));
  }

  @ApiOperation("save:新增方法")
  @Override
  public Result save(@RequestBody Eshop entity){
    eshopService.insert(entity);
    return Result.OK("新增成功");
  }

  @ApiOperation("update:修改方法")
  @Override
  public Result update(@RequestBody Eshop entity){
    eshopService.update(entity);
    return Result.OK("修改成功");
  }

  @ApiOperation("deleteById:根据Id删除")
  @Override
  public Result deleteById(@PathVariable("id") Long id){
    eshopService.deleteById(id);
    return Result.OK("删除成功");
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
  @Override
  public Result deleteByIds(@PathVariable("ids") String ids){
    eshopService.deleteByIds(IdsUtil.listLong(ids));
    return Result.OK("删除成功");
  }

}
