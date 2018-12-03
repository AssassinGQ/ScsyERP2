package cn.AssassinG.ScsyERP.common.core.dao;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;

import java.util.List;
import java.util.Map;

/**
 * @param <T>
 */
public interface BaseDao<T extends BaseEntity> {

    /**
     * @param entity 要插入数据库的实体对象，不能为空
     * @return 如果插入成功，返回对应记录的主键值 会抛出运行异常DB_INSERT_EXCEPTION
     */
    long insert(T entity);

    /**
     * @param list 可以为null，可以为Empty
     * @return 返回成功插入了几个实体，可能返回0，需要上层判断成功插入了几个，会抛出运行异常
     */
    int insert(List<T> list);

    /**
     * @param entity 不能为空
     *               会抛出运行异常
     */
    void update(T entity);

    /**
     * @param list 可以为null，可以为Empty
     * @return 返回成功修改了几个实体，可能返回0，需要上层判断成功修改了几个，会抛出运行异常
     */
    int update(List<T> list);

    /**
     * @param id 要删除的记录的主键值
     *           会抛出运行异常
     */
    void delete(long id);

    /**
     * @param entity 不能为空
     *               会抛出运行异常
     */
    void delete(T entity);

    /**
     * @param id
     * @return
     * 直接调用sessionTemplate的方法
     */
    T getById(long id);

    /**
     * @return
     * 直接调用sessionTemplate的方法
     */
    List<T> listAll();

    /**
     * @param paramMap
     * @return
     * 直接调用sessionTemplate的方法
     */
    T getBy(Map<String, Object> paramMap);

    /**
     * @param paramMap
     * @return
     * 直接调用sessionTemplate的方法
     */
    Object getBy(Map<String, Object> paramMap, String sqlId);

    /**
     * @param paramMap
     * @return
     * 直接调用sessionTemplate的方法
     */
    List<T> listBy(Map<String, Object> paramMap);

    /**
     * @param paramMap 不能为null并且不能为Empty
     * @param sqlId
     * @return
     * 直接调用sessionTemplate的方法
     */
    List<Object> listBy(Map<String, Object> paramMap, String sqlId);

    /**
     * @param pageParam
     * @param paramMap
     * @return
     */
    PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap);

    /**
     * @param pageParam
     * @param paramMap
     * @param sqlId
     * @return
     */
    PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId);
}
