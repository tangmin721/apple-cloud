package com.cachexic.cloud.provider.system.dao;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: DEMO管理
 * @author tangmin
 * @date 2017-10-24 10:32:30
 */
@MybatisDao
public interface DemoDao extends BaseDao<Demo, DemoQuery>{

  /**
   * 查找name为@name，且id不为@id的记录条数
   * @param name
   * @param id
   * @return
   */
  long selectCheckNameExit(@Param("name") String name, @Param("id") Long id);
}
