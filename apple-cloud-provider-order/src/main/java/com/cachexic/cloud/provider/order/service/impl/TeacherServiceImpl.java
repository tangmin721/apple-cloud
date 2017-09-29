package com.cachexic.cloud.provider.order.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.feign.order.entity.Teacher;
import com.cachexic.cloud.feign.order.entity.query.TeacherQuery;
import com.cachexic.cloud.provider.order.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * 教师测试实体管理
 *
 * @author tangmin
 * @date 2017-09-27 14:42:38
 */
@Service("teacherService")
public class TeacherServiceImpl extends BaseServiceImpl<Teacher, TeacherQuery> implements
    TeacherService {

}