package com.cachexic.cloud.web.backstage.controller.msg;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;
import com.cachexic.cloud.feign.msg.feign.MsgPersistentFeign;
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
 * 消息持久化管理  /msg
 *
 * @author tangmin
 * @date 2017-09-28 13:23:00
 */
@Api(description = "消息持久化管理")
@RestController
@RequestMapping("/msgPersistent")
public class MsgPersistentWebController {

  @Autowired
  private MsgPersistentFeign msgPersistentFeign;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @PostMapping("list")
  public Result<List<MsgPersistent>> list(@RequestBody MsgPersistentQuery query) {
    return msgPersistentFeign.list(query);
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @PostMapping("pagination")
  public Result<Pagination<MsgPersistent>> pagination(@RequestBody MsgPersistentQuery query) {
    return msgPersistentFeign.pagination(query);
  }

  @ApiOperation("getById:根据主键查询")
  @GetMapping("{id:\\d+}")
  public Result<MsgPersistent> getById(@PathVariable("id") Long id) {
    return msgPersistentFeign.getById(id);
  }

  @ApiOperation(value = "getByIds:根据主键ids查询", notes = "逗号分隔")
  @GetMapping("ids/{ids}")
  public Result<List<MsgPersistent>> getByIds(@PathVariable("ids") String ids) {
    return msgPersistentFeign.getByIds(ids);
  }

  @ApiOperation("save:新增方法")
  @PostMapping
  public Result save(@RequestBody MsgPersistent entity) {
    return msgPersistentFeign.save(entity);
  }

  @ApiOperation("update:修改方法")
  @PutMapping
  public Result update(@RequestBody MsgPersistent entity) {
    return msgPersistentFeign.update(entity);
  }

  @ApiOperation("deleteById:根据Id删除")
  @DeleteMapping("{id:\\d+}")
  public Result deleteById(@PathVariable("id") Long id) {
    return msgPersistentFeign.deleteById(id);
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除", notes = "逗号分隔")
  @DeleteMapping("ids/{ids}")
  public Result deleteByIds(@PathVariable("ids") String ids) {
    return msgPersistentFeign.deleteByIds(ids);
  }
}
