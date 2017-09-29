package com.cachexic.cloud.common.base.dao;

import com.cachexic.cloud.common.base.entity.PojoBaseEntity;
import com.cachexic.cloud.common.base.entity.query.PojoBaseQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tangmin
 * @Description: basedao
 * @date 2017-09-11 12:30:53
 */
public interface BaseDao<T extends PojoBaseEntity, Q extends PojoBaseQuery> {

  /**
   * 根据实体对象新增记录.
   */
  int insert(T entity);

  /**
   * 批量保存对象
   */
  int insertBatch(List<T> list);

  /**
   * 根据ID查找记录.或只查询其中几个字段
   */
  T selectById(@Param("id") Long id, @Param("fields") String fields);

  /**
   * 批量根据ids查找记录.
   */
  List<T> selectByIds(@Param("ids") List<Long> ids, @Param("fields") String fields);

  /**
   * 更新实体对应的记录.
   */
  int update(T entity);

  /**
   * 根据id 删除status 标记为deleted
   */
  int deleteById(@Param("id") Long id, @Param("updateUserId") Long updateUserId,
      @Param("updateUserName") String updateUserName);

  /**
   * 根据ids 删除status 标记为deleted
   */
  int deleteByIds(@Param("ids") List<Long> ids, @Param("updateUserId") Long updateUserId,
      @Param("updateUserName") String updateUserName);

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
   * Limit Page查询
   */
  List<T> selectListPage(Q query);

  /**
   * 总条数
   */
  Long selectListTotal(Q query);
}
