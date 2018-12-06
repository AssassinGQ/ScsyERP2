package cn.AssassinG.ScsyERP.common.core.biz.impl;

import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.exceptions.BizException;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;
import cn.AssassinG.ScsyERP.common.utils.ValidUtils;

import java.util.List;
import java.util.Map;

public abstract class BaseBizImpl<T extends BaseEntity> implements BaseBiz<T> {
    protected abstract BaseDao<T> getDao();
    public Long create(T entity) {
        ValidUtils.ValidationWithExp(entity);
        return getDao().insert(entity);
    }

//    public int create(List<T> list) {
//        return getDao().insert(list);
//    }

    public void update(T entity) {
        ValidUtils.ValidationWithExp(entity);
        if(entity.getIfDeleted()){
            throw new BizException(00000000, "对象已被删除，不能更新");
        }
        getDao().update(entity);
    }

//    public long update(List<T> list) {
//        return getDao().update(list);
//    }

    public void deleteById(long id) {
        getDao().delete(id);
    }

    public void delete(T entity) {
        getDao().delete(entity);
    }

    public T getById(long id) {
        return getDao().getById(id);
    }

    public T getBy(Map<String, Object> paramMap) {
        return getDao().getBy(paramMap);
    }

    public Object getBy(Map<String, Object> paramMap, String sqlId) {
        return getDao().getBy(paramMap, sqlId);
    }

    public List<T> listBy(Map<String, Object> paramMap) {
        return getDao().listBy(paramMap);
    }

    public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
        return getDao().listBy(paramMap, sqlId);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        return getDao().listPage(pageParam, paramMap);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {
        return getDao().listPage(pageParam, paramMap, sqlId);
    }
}
