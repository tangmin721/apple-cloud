package com.cachexic.cloud.provider.system.dao;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.cachexic.cloud.feign.system.entity.Teacher;
import com.cachexic.cloud.feign.system.entity.query.TeacherQuery;

/**
 * @Description: 教师管理
 * @author tangmin
 * @date 2017-11-05 19:47:05
 */
@MybatisDao
public interface TeacherDao extends BaseDao<Teacher, TeacherQuery>{

}
