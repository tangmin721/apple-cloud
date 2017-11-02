package com.cachexic.cloud.provider.system.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.common.exceptions.BizPreconditions;
import com.cachexic.cloud.feign.system.entity.Demo;
import com.cachexic.cloud.feign.system.entity.query.DemoQuery;
import com.cachexic.cloud.provider.system.dao.DemoDao;
import com.cachexic.cloud.provider.system.service.DemoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangmin
 * @Description: DEMO管理
 * @date 2017-10-24 10:32:30
 */
@Service("demoService")
public class DemoServiceImpl extends BaseServiceImpl<Demo, DemoQuery> implements DemoService {

  @Autowired
  private DemoDao demoDao;

  /*@Override
  public int update(Demo entity) {
    try (HintManager hintManager = HintManager.getInstance()){
      //添加数据源分片键值(指定分库设置的shardingColumn，value:与他的id在同一个库)
      hintManager.addDatabaseShardingValue("t_demo", "id", entity.getId());
      //来添加表分片键值(指定分表设置的shardingColumn，value:与他的id在同一个表)
      hintManager.addTableShardingValue("t_demo", "id", entity.getId());
      return super.update(entity);
    }
  }*/

  @Override
  public Long insert(Demo entity) {
    BizPreconditions.checkArgument(this.isNameNotExist(entity),"该姓名数据库里已存在");
    return super.insert(entity);
  }

  @Override
  public int update(Demo entity) {
    BizPreconditions.checkArgument(this.isNameNotExist(entity),"该姓名数据库里已存在");
    return super.update(entity);
  }

  @Override
  public int deleteByIds(List<Long> ids) {
    ids.forEach(id -> this.deleteById(id));
    return ids.size();
  }

  /**
   * 不存在
   */
  @Override
  public Boolean isNameNotExist(Demo demo) {
    BizPreconditions.checkArgument(StringUtils.isNotBlank(demo.getName()), "姓名不能为空");
    long count = this.demoDao.selectCheckNameExit(demo.getName(), demo.getId());
    return count <= 0;
  }
}