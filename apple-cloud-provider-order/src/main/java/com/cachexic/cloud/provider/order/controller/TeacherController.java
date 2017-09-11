package com.cachexic.cloud.provider.order.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.feign.order.feign.TeacherFeign;
import com.cachexic.cloud.provider.order.service.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 教师管理
 * @author tangmin
 * @date 2017-09-11 18:11:48
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController implements TeacherFeign {

    @Autowired
    private TeacherService teacherService;

    /**
     * list
     * @param query
     */
    @Override
    public Result<List<Teacher>> list(@RequestBody TeacherQuery query){
        return Result.OK().setData(teacherService.selectListPage(query));
    }

    /**
     * 分页查询
     * @param query
     */
    @Override
    public Result<Pagination<List<Teacher>>> pagination(@RequestBody TeacherQuery query){
        return Result.OK().setData(teacherService.selectListPagination(query));
    }

    /**
     * 根据主键查询
     * @param id
     */
    @Override
    public Result<Teacher> getById(@PathVariable("ids") Long id){
        return Result.OK().setData(teacherService.selectById(id));
    }

    /**
     * 根据主键ids查询
     * @param ids
     */
    @Override
    public Result<List<Teacher>> getByIds(@PathVariable String ids){
        return Result.OK().setData(teacherService.selectByIds(IdsUtil.listLong(ids)));
    }

    /**
     * 新增方法
     * @param entity
     */
    @Override
    public Result save(@RequestBody Teacher entity){
        teacherService.insert(entity);
        return Result.OK("新增成功");
    }

    /**
     * 修改方法
     * @param entity
     */
    @Override
    public Result update(@RequestBody Teacher entity){
        teacherService.update(entity);
        return Result.OK("修改成功");
    }

    /**
     * 根据Id删除
     * @param id
     */
    @Override
    public Result deleteById(@PathVariable("id") Long id){
        teacherService.deleteById(id);
        return Result.OK("删除成功");
    }

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     */
    @Override
    public Result deleteByIds(@PathVariable("ids") String ids){
        teacherService.deleteByIds(IdsUtil.listLong(ids));
        return Result.OK("删除成功");
    }

}
