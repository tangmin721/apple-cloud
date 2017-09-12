package com.cachexic.cloud.web.backstage.controller.msg;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;
import com.cachexic.cloud.feign.msg.feign.MsgPersistentFeign;
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
 * 持久化消息管理  /msg
 * @author tangmin
 * @date 2017-09-12 19:01:50
 */
@RestController
@RequestMapping("/msgPersistent")
public class MsgPersistentWebController{

    @Autowired
    private MsgPersistentFeign msgPersistentFeign;

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("list")
    public Result<List<MsgPersistent>> list(@RequestBody MsgPersistentQuery query){
        return msgPersistentFeign.list(query);
    }

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("pagination")
    public Result<Pagination<MsgPersistent>> pagination(@RequestBody MsgPersistentQuery query){
        return msgPersistentFeign.pagination(query);
    }

    /**
     * 根据主键查询
     * @param id
     */
    @GetMapping("id/{id}")
    public Result<MsgPersistent> getById(@PathVariable("id") Long id){
        return msgPersistentFeign.getById(id);
    }

    /**
     * 根据主键ids查询
     * @param ids
     */
    @GetMapping("ids/{ids}")
    public Result<List<MsgPersistent>> getByIds(@PathVariable("ids") String ids){
        return msgPersistentFeign.getByIds(ids);
    }

    /**
     * 新增方法
     * @param entity
     */
    @PostMapping
    public Result save(@RequestBody MsgPersistent entity){
        return msgPersistentFeign.save(entity);
    }

    /**
     * 修改方法
     * @param entity
     */
    @PutMapping
    public Result update(@RequestBody MsgPersistent entity){
        return msgPersistentFeign.update(entity);
    }

    /**
     * 根据Id删除
     * @param id
     */
    @DeleteMapping("id/{id}")
    public Result deleteById(@PathVariable("id") Long id){
        return msgPersistentFeign.deleteById(id);
    }

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     */
    @DeleteMapping("ids/{ids}")
    public Result deleteByIds(@PathVariable("ids") String ids){
        return msgPersistentFeign.deleteByIds(ids);
    }
}
