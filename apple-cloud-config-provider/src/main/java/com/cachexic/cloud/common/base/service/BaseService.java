package com.cachexic.cloud.common.base.service;

import com.cachexic.cloud.common.base.entity.PojoBaseEntity;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.base.entity.query.PojoBaseQuery;
import java.util.List;

/**
 * @author tangmin
 */
public interface BaseService<T extends PojoBaseEntity, Q extends PojoBaseQuery> {

  /**
   * 根据实体对象新增记录.返回主键
   */
  Long insert(T entity);

  /**
   * 批量保存对象
   *
   * @return 返回插入的条数
   */
  int insertBatch(List<T> list);

  /**
   * 根据ID查找全部字段记录.
   *
   * @return 返回T
   */
  T selectById(Long id);

  /**
   * 根据id,fields自定义字段查找记录
   */
  T selectById(Long id, String fields);

  /**
   * 根据ids,fields自定义字段查找记录
   */
  List<T> selectByIds(List<Long> ids, String fields);

  /**
   * 批量根据ids查找全部字段记录.
   *
   * @return 返回List<T>
   */
  List<T> selectByIds(List<Long> ids);

  /**
   * 更新实体对应的记录.
   */
  int update(T entity);

  /**
   * 根据id 删除status 标记为yes
   */
  int deleteById(Long id);

  /**
   * 根据ids 删除status 标记为yes
   */
  int deleteByIds(List<Long> ids);

  /**
   * 根据id  彻底删除
   */
  int removeById(Long id);

  /**
   * 根据ids 彻底删除
   */
  int removeByIds(List<Long> ids);

  /**
   * 查询所有记录
   */
  List<T> selectList(Q query);

  /**
   * limit Page查询
   *
   * @return 返回结果集
   */
  List<T> selectListPage(Q query);

  /**
   * 总条数
   */
  Long selectListTotal(Q query);

  /**
   * 页面分页
   *
   * @return 返回分页对象
   */
  Pagination<T> selectListPagination(Q query);

}
