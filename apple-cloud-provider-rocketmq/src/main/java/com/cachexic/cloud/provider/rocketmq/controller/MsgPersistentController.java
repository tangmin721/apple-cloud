package com.cachexic.cloud.provider.rocketmq.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;
import com.cachexic.cloud.feign.msg.feign.MsgPersistentFeign;
import com.cachexic.cloud.provider.rocketmq.service.MsgPersistentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 持久化消息管理
 * @author tangmin
 * @date 2017-09-12 19:01:50
 */
@RestController
@RequestMapping("/msgPersistent")
public class MsgPersistentController implements MsgPersistentFeign {

    @Autowired
    private MsgPersistentService msgPersistentService;

    /**
     * list
     * @param query
     */
    @Override
    public Result<List<MsgPersistent>> list(@RequestBody MsgPersistentQuery query){
        return Result.OK().setData(msgPersistentService.selectListPage(query));
    }

    /**
     * 分页查询
     * @param query
     */
    @Override
    public Result<Pagination<MsgPersistent>> pagination(@RequestBody MsgPersistentQuery query){
        return Result.OK().setData(msgPersistentService.selectListPagination(query));
    }

    /**
     * 根据主键查询
     * @param id
     */
    @Override
    public Result<MsgPersistent> getById(@PathVariable("ids") Long id){
        return Result.OK().setData(msgPersistentService.selectById(id));
    }

    /**
     * 根据主键ids查询
     * @param ids
     */
    @Override
    public Result<List<MsgPersistent>> getByIds(@PathVariable String ids){
        return Result.OK().setData(msgPersistentService.selectByIds(IdsUtil.listLong(ids)));
    }

    /**
     * 新增方法
     * @param entity
     */
    @Override
    public Result save(@RequestBody MsgPersistent entity){
        msgPersistentService.insert(entity);
        return Result.OK("新增成功");
    }

    /**
     * 修改方法
     * @param entity
     */
    @Override
    public Result update(@RequestBody MsgPersistent entity){
        msgPersistentService.update(entity);
        return Result.OK("修改成功");
    }

    /**
     * 根据Id删除
     * @param id
     */
    @Override
    public Result deleteById(@PathVariable("id") Long id){
        msgPersistentService.deleteById(id);
        return Result.OK("删除成功");
    }

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     */
    @Override
    public Result deleteByIds(@PathVariable("ids") String ids){
        msgPersistentService.deleteByIds(IdsUtil.listLong(ids));
        return Result.OK("删除成功");
    }

}
