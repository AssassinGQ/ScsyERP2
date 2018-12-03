package cn.AssassinG.ScsyERP.common.core.service;

import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;

import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	protected abstract BaseBiz<T> getBiz();

	public Long create(T entity){
		return getBiz().create(entity);
	}
	public void update(T entity){
		getBiz().update(entity);
	}
	public void deleteById(Long entityId){
		getBiz().deleteById(entityId);
	}
	public void delete(T entity){
		getBiz().delete(entity);
	}
	public T getById(Long entityId){
		return getBiz().getById(entityId);
	}
	public T getBy(Map<String, Object> paramMap){
		return getBiz().getBy(paramMap);
	}
	public List<T> listBy(Map<String, Object> paramMap){
		return getBiz().listBy(paramMap);
	}
	public PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap){
		return getBiz().listPage(pageParam, paramMap);
	}
}
