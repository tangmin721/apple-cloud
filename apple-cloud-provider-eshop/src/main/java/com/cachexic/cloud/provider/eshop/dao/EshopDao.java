package com.cachexic.cloud.provider.eshop.dao;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.cachexic.cloud.feign.eshop.entity.Eshop;
import com.cachexic.cloud.feign.eshop.entity.query.EshopQuery;

/**
 * @Description: e店管理
 * @author tangmin
 * @date 2017-10-10 21:00:52
 */
@MybatisDao
public interface EshopDao extends BaseDao<Eshop, EshopQuery>{

}
