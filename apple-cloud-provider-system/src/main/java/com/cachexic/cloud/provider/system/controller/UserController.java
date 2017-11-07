package com.cachexic.cloud.provider.system.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.system.entity.User;
import com.cachexic.cloud.feign.system.entity.query.UserQuery;
import com.cachexic.cloud.feign.system.feign.UserFeign;
import com.cachexic.cloud.provider.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户管理  /system
 * @author tangmin
 * @date 2017-11-07 15:38:01
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController implements UserFeign {

  @Autowired
  private UserService userService;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @Override
  public Result<List<User>> list(@RequestBody UserQuery query){
    return Result.OK().setData(userService.selectListPage(query));
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @Override
  public Result<Pagination<User>> pagination(@RequestBody UserQuery query){
    return Result.OK().setData(userService.selectListPagination(query));
  }

  @ApiOperation("getById:根据主键查询")
  @Override
  public Result<User> getById(@PathVariable("id") Long id){
    return Result.OK().setData(userService.selectById(id));
  }

  @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
  @Override
  public Result<List<User>> getByIds(@PathVariable("ids") String ids){
    return Result.OK().setData(userService.selectByIds(IdsUtil.listLong(ids)));
  }

  @ApiOperation("save:新增方法")
  @Override
  public Result save(@RequestBody User entity){
    userService.insert(entity);
    return Result.OK("新增成功");
  }

  @ApiOperation("update:修改方法")
  @Override
  public Result update(@RequestBody User entity){
    userService.update(entity);
    return Result.OK("修改成功");
  }

  @ApiOperation("deleteById:根据Id删除")
  @Override
  public Result deleteById(@PathVariable("id") Long id){
    userService.deleteById(id);
    return Result.OK("删除成功");
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
  @Override
  public Result deleteByIds(@PathVariable("ids") String ids){
    userService.deleteByIds(IdsUtil.listLong(ids));
    return Result.OK("删除成功");
  }

}
