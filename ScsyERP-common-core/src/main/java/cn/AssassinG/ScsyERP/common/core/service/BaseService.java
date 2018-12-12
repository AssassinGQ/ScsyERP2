package cn.AssassinG.ScsyERP.common.core.service;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;

import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity> {

	Long create(T entity);
	void update(T entity);
	void updateByMap(Long entityId, Map<String, String> paramMap);
	void deleteById(Long entityId);
	void delete(T entity);

	/**
	 * 根据ID查找记录.
	 *
	 * @param entityId
	 *            .
	 * @return entity .
	 */
	T getById(Long entityId);

	/**
	 * 根据条件查询 listBy: <br/>
	 *
	 * @param paramMap
	 * @return 返回实体
	 */
	T getBy(Map<String, Object> paramMap);

	/**
	 * 根据条件查询 listBy: <br/>
	 *
	 * @param paramMap
	 * @return 返回集合
	 */
	List<T> listBy(Map<String, Object> paramMap);

	/**
	 * 分页查询 .
	 *
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            业务条件查询参数.
	 * @return
	 */
	PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap);

}
