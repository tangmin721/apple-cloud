package com.cachexic.cloud.provider.system.dao;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;

/**
 * @Description: DEMO管理
 * @author tangmin
 * @date 2017-10-24 10:32:30
 */
@MybatisDao
public interface DemoDao extends BaseDao<Demo, DemoQuery>{

}
