package com.cachexic.cloud.web.backstage.controller.system.user;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.system.entity.User;
import com.cachexic.cloud.feign.system.entity.query.UserQuery;
import com.cachexic.cloud.feign.system.feign.UserFeign;
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
 * @Description: 用户管理  /system
 * @author tangmin
 * @date 2017-11-07 15:38:01
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserWebController{

  @Autowired
  private UserFeign userFeign;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @PostMapping("list")
  public Result<List<User>> list(@RequestBody UserQuery query){
    return userFeign.list(query);
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @PostMapping("pagination")
  public Result<Pagination<User>> pagination(@RequestBody UserQuery query){
    return userFeign.pagination(query);
  }

  @ApiOperation("getById:根据主键查询")
  @GetMapping("{id}")
  public Result<User> getById(@PathVariable("id") Long id){
    return userFeign.getById(id);
  }

  @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
  @GetMapping("ids/{ids}")
  public Result<List<User>> getByIds(@PathVariable("ids") String ids){
    return userFeign.getByIds(ids);
  }

  @ApiOperation("save:新增方法")
  @PostMapping
  public Result save(@RequestBody User entity){
    return userFeign.save(entity);
  }

  @ApiOperation("update:修改方法")
  @PutMapping
  public Result update(@RequestBody User entity){
    return userFeign.update(entity);
  }

  @ApiOperation("deleteById:根据Id删除")
  @DeleteMapping("{id}")
  public Result deleteById(@PathVariable("id") Long id){
    return userFeign.deleteById(id);
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
  @DeleteMapping("ids/{ids}")
  public Result deleteByIds(@PathVariable("ids") String ids){
    return userFeign.deleteByIds(ids);
  }
}
