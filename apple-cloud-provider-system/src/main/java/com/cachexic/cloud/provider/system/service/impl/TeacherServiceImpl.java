package com.cachexic.cloud.provider.system.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.feign.system.entity.Teacher;
import com.cachexic.cloud.feign.system.entity.query.TeacherQuery;
import com.cachexic.cloud.provider.system.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * @Description: 教师管理
 * @author tangmin
 * @date 2017-11-05 19:47:05
 */
@Service("teacherService")
public class TeacherServiceImpl extends BaseServiceImpl<Teacher, TeacherQuery> implements
    TeacherService {

}