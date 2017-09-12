package com.cachexic.cloud.web.backstage.controller.order;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.feign.order.entity.query.TeacherQuery;
import com.cachexic.cloud.feign.order.feign.TeacherFeign;
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
 * @author tangmin
 * @date 2017-09-12 00:38:43
 */
@RestController
@RequestMapping("/teacher")
public class TeacherWebController{

    @Autowired
    private TeacherFeign teacherFeign;

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("list")
    public Result<List<Teacher>> list(@RequestBody TeacherQuery query){
        return teacherFeign.list(query);
    }

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("pagination")
    public Result<Pagination<Teacher>> pagination(@RequestBody TeacherQuery query){
        return teacherFeign.pagination(query);
    }

    /**
     * 根据主键查询
     * @param id
     */
    @GetMapping("id/{id}")
    public Result<Teacher> getById(@PathVariable("id") Long id){
        return teacherFeign.getById(id);
    }

    /**
     * 根据主键ids查询
     * @param ids
     */
    @GetMapping("ids/{ids}")
    public Result<List<Teacher>> getByIds(@PathVariable("ids") String ids){
        return teacherFeign.getByIds(ids);
    }

    /**
     * 新增方法
     * @param entity
     */
    @PostMapping
    public Result save(@RequestBody Teacher entity){
        return teacherFeign.save(entity);
    }

    /**
     * 修改方法
     * @param entity
     */
    @PutMapping
    public Result update(@RequestBody Teacher entity){
        return teacherFeign.update(entity);
    }

    /**
     * 根据Id删除
     * @param id
     */
    @DeleteMapping("id/{id}")
    public Result deleteById(@PathVariable("id") Long id){
        return teacherFeign.deleteById(id);
    }

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     */
    @DeleteMapping("ids/{ids}")
    public Result deleteByIds(@PathVariable("ids") String ids){
        return teacherFeign.deleteByIds(ids);
    }
}
