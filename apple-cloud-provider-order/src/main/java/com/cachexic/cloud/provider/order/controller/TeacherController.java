package com.cachexic.cloud.provider.order.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.feign.order.entity.query.TeacherQuery;
import com.cachexic.cloud.feign.order.feign.TeacherFeign;
import com.cachexic.cloud.provider.order.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 教师测试实体管理
 * @author tangmin
 * @date 2017-09-27 14:42:38
 */
@Api(description = "教师测试实体管理")
@RestController
@RequestMapping("/teacher")
public class TeacherController implements TeacherFeign {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
    @Override
    public Result<List<Teacher>> list(@RequestBody TeacherQuery query){
        return Result.OK().setData(teacherService.selectListPage(query));
    }

    @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
    @Override
    public Result<Pagination<Teacher>> pagination(@RequestBody TeacherQuery query){
        return Result.OK().setData(teacherService.selectListPagination(query));
    }

    @ApiOperation("getById:根据主键查询")
    @Override
    public Result<Teacher> getById(@PathVariable("ids") Long id){
        return Result.OK().setData(teacherService.selectById(id));
    }

    @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
    @Override
    public Result<List<Teacher>> getByIds(@PathVariable String ids){
        return Result.OK().setData(teacherService.selectByIds(IdsUtil.listLong(ids)));
    }

    @ApiOperation("save:新增方法")
    @Override
    public Result save(@RequestBody Teacher entity){
        teacherService.insert(entity);
        return Result.OK("新增成功");
    }

    @ApiOperation("update:修改方法")
    @Override
    public Result update(@RequestBody Teacher entity){
        teacherService.update(entity);
        return Result.OK("修改成功");
    }

    @ApiOperation("deleteById:根据Id删除")
    @Override
    public Result deleteById(@PathVariable("id") Long id){
        teacherService.deleteById(id);
        return Result.OK("删除成功");
    }

    @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
    @Override
    public Result deleteByIds(@PathVariable("ids") String ids){
        teacherService.deleteByIds(IdsUtil.listLong(ids));
        return Result.OK("删除成功");
    }

}
