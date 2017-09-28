package com.cachexic.cloud.common.base.service.impl;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.common.base.entity.PojoBaseEntity;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.base.entity.query.PojoBaseQuery;
import com.cachexic.cloud.common.base.service.BaseService;
import com.cachexic.cloud.common.base.validator.BeanValidator;
import com.cachexic.cloud.common.base.validator.ValidatorResult;
import com.cachexic.cloud.common.base.validator.annotations.Insert;
import com.cachexic.cloud.common.base.validator.annotations.Update;
import com.cachexic.cloud.common.base.validator.exceptions.ValidBizException;
import com.cachexic.cloud.common.base.validator.exceptions.ValidBizExceptionEnum;
import com.cachexic.cloud.common.exceptions.BizException;
import com.cachexic.cloud.common.exceptions.BizExceptionEnum;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.config.redis.RedisService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tangmin
 * @Description: 基础实现类
 * @TODO 从redis获取用户信息，来更新createUserId，updateUserId
 * @date 2017-09-11 14:07:18
 */
public abstract class BaseServiceImpl<T extends PojoBaseEntity, Q extends PojoBaseQuery> implements BaseService<T, Q> {

    private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    protected RedisService redisService;

    @Autowired
    protected BaseDao<T, Q> dao;

    public Long insert(T entity) {
        if (entity == null) {
            throw new RuntimeException("insert entity:T is null");
        }

        //校验
        ValidatorResult validateResult = BeanValidator.validateResult(entity, Insert.class);
        if (!validateResult.getFlag()) {
            throw new ValidBizException(ValidBizExceptionEnum.VALID_INSERT_ERROR.getCode(), JsonUtil.toJson(validateResult.getErrorObjs()));
            //throw new BizException(BizExceptionEnum.VALID_INSERT_ERROR.getCode(), validateResult.getErrorStr());
        }
        int result = dao.insert(entity);
        if (result <= 0) {
            throw new BizException(BizExceptionEnum.DB_INSERT_RESULT_0);
        }
        log.info("{}==>insert entity-->{}", entity.getClass(), JsonUtil.toJson(entity));
        return entity.getId();
    }

    @Transactional
    public int insertBatch(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (T entity : list) {
            //校验
            ValidatorResult validateResult = BeanValidator.validateResult(entity, Insert.class);
            if (!validateResult.getFlag()) {
                throw new ValidBizException(ValidBizExceptionEnum.VALID_INSERT_ERROR.getCode(), JsonUtil.toJson(validateResult.getErrorObjs()));
            }
        }

        int result = dao.insertBatch(list);

        if (result <= 0) {
            throw new BizException(BizExceptionEnum.DB_INSERT_RESULT_0);
        }
        log.info("{}==>insertBatch entitys-->{}", list.get(0).getClass(),JsonUtil.toJson(list));
        return result;

    }

    public T selectById(Long id, String fields) {
        return dao.selectById(id, fields);
    }

    public List<T> selectByIds(List<Long> ids, String fields) {
        return dao.selectByIds(ids, fields);
    }

    public T selectById(Long id) {
        return dao.selectById(id, null);
    }

    public List<T> selectByIds(List<Long> ids) {
        return dao.selectByIds(ids, null);
    }

    public int update(T entity) {
        if (entity == null || entity.getId() == null) {
            throw new RuntimeException("update entity:"+entity.getClass().getName()+" is null");
        }

        //校验
        ValidatorResult validateResult = BeanValidator.validateResult(entity, Update.class);
        if (!validateResult.getFlag()) {
            throw new ValidBizException(ValidBizExceptionEnum.VALID_UPDATE_ERROR.getCode(), JsonUtil.toJson(validateResult.getErrorObjs()));
            //throw new BizException(BizExceptionEnum.VALID_UPDATE_ERROR.getCode(), validateResult.getErrorStr());
        }

        int result = dao.update(entity);

        if (result <= 0) {
            throw new BizException(BizExceptionEnum.DB_UPDATE_RESULT_0);
        }

        log.info("{}==>update entity-->{}", entity.getClass(),JsonUtil.toJson(entity));
        return result;
    }

    public int deleteById(Long id) {
        int result = dao.deleteById(id,null,null);
        if (result <= 0) {
            throw new BizException(BizExceptionEnum.DB_DELETE_RESULT_0);
        }
        log.info("{}==>deleteById-->{}", this.getClass(), JsonUtil.toJson(id));
        return result;
    }

    public int deleteByIds(List<Long> ids) {
        int result = dao.deleteByIds(ids,null,null);
        if (result <= 0) {
            throw new BizException(BizExceptionEnum.DB_DELETE_RESULT_0);
        }
        log.info("{}==>deleteByIds-->{}", this.getClass(),JsonUtil.toJson(ids));
        return result;
    }

    public int removeById(Long id) {
        int result = dao.removeById(id);
        if (result <= 0) {
            throw new BizException(BizExceptionEnum.DB_REMOVE_RESULT_0);
        }
        log.info("{}==>deleteById-->{}", JsonUtil.toJson(id));
        return result;
    }

    public int removeByIds(List<Long> ids) {
        int result = dao.removeByIds(ids);
        if (result <= 0) {
            throw new BizException(BizExceptionEnum.DB_REMOVE_RESULT_0);
        }
        log.info("{}==>deleteById-->{}", JsonUtil.toJson(ids));
        return result;
    }

    public List<T> selectList(Q query) {
        return dao.selectList(query);
    }

    public List<T> selectListPage(Q query) {
        return dao.selectListPage(query);
    }

    public Long selectListTotal(Q query) {
        return dao.selectListTotal(query);
    }

    public Pagination<T> selectListPagination(Q query) {
        long total = this.selectListTotal(query);
        Pagination<T> pagination = new Pagination<T>(query.getCurrentPage(), query.getPageSize(),total);
        if(total>0){
            pagination.setList(this.selectListPage(query));
        }
        return pagination;
    }

}
