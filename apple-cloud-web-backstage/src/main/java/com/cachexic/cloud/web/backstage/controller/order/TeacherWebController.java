package com.cachexic.cloud.web.backstage.controller.order;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.feign.order.entity.query.TeacherQuery;
import com.cachexic.cloud.feign.order.feign.TeacherFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * 教师管理  /order
 *
 * @author tangmin
 */
@Api(description = "描述整个类-教师管理的相关接口")
@RestController
@RequestMapping("/teacher")
public class TeacherWebController {

    @Autowired
    private TeacherFeign teacherFeign;

    /**
     * 分页查询
     *
     * @param query
     */
    @ApiOperation(value = "批量获取数据", notes = "不带分页信息的list集合")
    @PostMapping("list")
    public Result<List<Teacher>> list(@RequestBody TeacherQuery query) {
        return teacherFeign.list(query);
    }

    /**
     * 分页查询
     *
     * @param query
     */
    @ApiOperation(value = "分页查询", notes = "带分页信息的Pagination对象")
    @PostMapping("pagination")
    public Result<Pagination<Teacher>> pagination(@RequestBody TeacherQuery query) {
        return teacherFeign.pagination(query);
    }

    /**
     * 根据主键查询
     *
     * @param id
     */
    @GetMapping("id/{id}")
    public Result<Teacher> getById(@PathVariable("id") Long id) {
        return teacherFeign.getById(id);
    }

    /**
     * 根据主键ids查询
     *
     * @param ids
     */
    @GetMapping("ids/{ids}")
    public Result<List<Teacher>> getByIds(@PathVariable("ids") String ids) {
        return teacherFeign.getByIds(ids);
    }

    /**
     * 新增方法
     *
     * @param entity
     */
    @PostMapping
    public Result save(@RequestBody Teacher entity) {
        return teacherFeign.save(entity);
    }

    /**
     * 修改方法
     *
     * @param entity
     */
    @PutMapping
    public Result update(@RequestBody Teacher entity) {
        return teacherFeign.update(entity);
    }

    /**
     * 根据Id删除
     *
     * @param id
     */
    @DeleteMapping("id/{id}")
    public Result deleteById(@ApiParam("teacher的id") @PathVariable("id") Long id) {
        return teacherFeign.deleteById(id);
    }

    /**
     * 根据ids删除，id逗号隔开
     *
     * @param ids
     */
    @ApiOperation("根据ids批量删除")
    @DeleteMapping("ids/{ids}")
    public Result deleteByIds(@PathVariable("ids") String ids) {
        return teacherFeign.deleteByIds(ids);
    }
}
