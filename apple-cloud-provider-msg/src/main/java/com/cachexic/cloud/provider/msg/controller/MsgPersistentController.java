package com.cachexic.cloud.provider.msg.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;
import com.cachexic.cloud.feign.msg.feign.MsgPersistentFeign;
import com.cachexic.cloud.provider.msg.service.MsgPersistentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息持久化管理
 * @author tangmin
 * @date 2017-09-28 13:23:00
 */
@Api(description = "消息持久化管理")
@RestController
@RequestMapping("/msgPersistent")
public class MsgPersistentController implements MsgPersistentFeign {

    @Autowired
    private MsgPersistentService msgPersistentService;

    @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
    @Override
    public Result<List<MsgPersistent>> list(@RequestBody MsgPersistentQuery query){
        return Result.OK().setData(msgPersistentService.selectListPage(query));
    }

    @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
    @Override
    public Result<Pagination<MsgPersistent>> pagination(@RequestBody MsgPersistentQuery query){
        return Result.OK().setData(msgPersistentService.selectListPagination(query));
    }

    @ApiOperation("getById:根据主键查询")
    @Override
    public Result<MsgPersistent> getById(@PathVariable("id") Long id){
        return Result.OK().setData(msgPersistentService.selectById(id));
    }

    @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
    @Override
    public Result<List<MsgPersistent>> getByIds(@PathVariable("ids") String ids){
        return Result.OK().setData(msgPersistentService.selectByIds(IdsUtil.listLong(ids)));
    }

    @ApiOperation("save:新增方法")
    @Override
    public Result save(@RequestBody MsgPersistent entity){
        msgPersistentService.insert(entity);
        return Result.OK("新增成功");
    }

    @ApiOperation("update:修改方法")
    @Override
    public Result update(@RequestBody MsgPersistent entity){
        msgPersistentService.update(entity);
        return Result.OK("修改成功");
    }

    @ApiOperation("deleteById:根据Id删除")
    @Override
    public Result deleteById(@PathVariable("id") Long id){
        msgPersistentService.deleteById(id);
        return Result.OK("删除成功");
    }

    @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
    @Override
    public Result deleteByIds(@PathVariable("ids") String ids){
        msgPersistentService.deleteByIds(IdsUtil.listLong(ids));
        return Result.OK("删除成功");
    }

}
