package com.cachexic.cloud.feign.msg.feign;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;
import com.cachexic.cloud.feign.msg.feign.fallback.MsgPersistentFeignFallback;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 持久化消息管理
 * @author tangmin
 * @date 2017-09-12 19:01:50
 */
@FeignClient(name = "provider-msg", path = "/msgPersistent", fallbackFactory = MsgPersistentFeignFallback.class)
public interface MsgPersistentFeign{

    /**
     * List
     * @param query
     */
    @PostMapping("list")
    Result<List<MsgPersistent>> list(@RequestBody MsgPersistentQuery query);

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("pagination")
    Result<Pagination<MsgPersistent>> pagination(@RequestBody MsgPersistentQuery query);

    /**
     * 根据主键查询
     * @param id
     */
    @GetMapping("id/{id}")
    Result<MsgPersistent> getById(@PathVariable("id") Long id);

    /**
     * 根据主键ids查询
     * @param ids
     */
    @GetMapping("ids/{ids}")
    Result<List<MsgPersistent>> getByIds(@PathVariable("ids") String ids);

    /**
     * 新增方法
     * @param entity
     */
    @PostMapping
    Result save(@RequestBody MsgPersistent entity);

    /**
     * 修改方法
     * @param entity
     */
    @PutMapping
    Result update(@RequestBody MsgPersistent entity);

    /**
     * 根据Id删除
     * @param id
     */
    @DeleteMapping("id/{id}")
    Result deleteById(@PathVariable("id") Long id);

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     */
    @DeleteMapping("ids/{ids}")
    Result deleteByIds(@PathVariable("ids") String ids);
}
