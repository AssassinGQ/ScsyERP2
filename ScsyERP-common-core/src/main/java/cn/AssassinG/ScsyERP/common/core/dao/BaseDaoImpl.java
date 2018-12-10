package cn.AssassinG.ScsyERP.common.core.dao;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.exceptions.DaoException;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    protected static final String SQL_INSERT = "insert";
    protected static final String SQL_BATCH_INSERT = "batchInsert";
    protected static final String SQL_UPDATE = "update";
    protected static final String SQL_BATCH_UPDATE = "batchUpdate";
    protected static final String SQL_GET_BY_ID = "getById";
    protected static final String SQL_DELETE_BY_ID = "deleteById";
    protected static final String SQL_DELETE = "delete";
    protected static final String SQL_LIST_ALL = "listAll";
    protected static final String SQL_LIST_BY = "listBy";
    protected static final String SQL_LIST_PAGE = "listPage";
    private static final String SQL_LIST_PAGE_COUNT = "listPageCount";
    protected static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam"; // 根据当前分页参数进行统计


    private SqlSessionTemplate sessionTemplate;

    protected SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }

    @Autowired
    @Qualifier("sqlSessionTemplate")
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }

    @Autowired
    @Qualifier("sqlSessionTemplate")
    public void setSqlSession(SqlSessionTemplate sessionTemplate){
        super.setSqlSessionTemplate(sessionTemplate);
    }
//todo 注入问题该怎么解决：在idea中使用单元测试没问题，打包后就找不到SqlSessionTemplate
//    protected SqlSessionTemplate sessionTemplate;
//
//    protected SqlSessionTemplate getSessionTemplate() {
//        return sessionTemplate;
//    }
//
//    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
//        this.sessionTemplate = sessionTemplate;
//    }
//
//    public SqlSession getSqlSession() {
//        return super.getSqlSession();
//    }

    public long insert(T entity) {
        if(entity == null)
            throw new RuntimeException("entity is null");
        int result = sessionTemplate.insert(getStatement(SQL_INSERT), entity);

        if (result != 1) {
            throw DaoException.DB_INSERT_EXCEPTION.newInstance("数据库操作,insert返回非1.{%s}", getStatement(SQL_INSERT));
        }

        if (entity.getId() != null) {
            return entity.getId();
        }else{
            throw DaoException.DB_INSERT_EXCEPTION.newInstance("数据库操作,insert后实体对象没有主键.{%s}", getStatement(SQL_INSERT));
        }
    }

    public int insert(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }

        int result = sessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);

        if (result < 0) {
            throw DaoException.DB_INSERT_EXCEPTION.newInstance("数据库操作,BatchInsert返回result返回负数.{%s}", getStatement(SQL_INSERT));
        }else
            return result;
    }

    public void update(T entity) {
        if(entity == null)
            throw new RuntimeException("entity is null");
        int result = sessionTemplate.update(getStatement(SQL_UPDATE), entity);
        if (result != 1) {
            throw DaoException.DB_UPDATE_EXCEPTION.newInstance("数据库操作,update返回非1.{%s}", getStatement(SQL_UPDATE));
        }
//        return result;
    }

    public int update(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int result = sessionTemplate.update(getStatement(SQL_BATCH_UPDATE), list);
        if (result < 0) {
            throw DaoException.DB_UPDATE_EXCEPTION.newInstance("数据库操作,BatchUpdate返回负数.{%s}", getStatement(SQL_UPDATE));
        }else
            return result;
    }

    public void delete(long id){
        int result = sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
        if(result != 1){
            throw DaoException.DB_DELETE_EXCEPTION.newInstance("数据库操作,deleteById返回非1.{%s}", getStatement(SQL_DELETE_BY_ID));
        }
//        return result;
    }

    public void delete(T entity) {
        if(entity == null)
            throw new RuntimeException("entity is null");
        int result = sessionTemplate.update(getStatement(SQL_DELETE), entity);
        if (result != 1) {
            throw DaoException.DB_DELETE_EXCEPTION.newInstance("数据库操作,delete返回非1.{%s}", getStatement(SQL_DELETE));
        }
//        return result;
    }

    public T getById(long id) {
        return sessionTemplate.selectOne(getStatement(SQL_GET_BY_ID), id);
    }

    public List<T> listAll() {
        return sessionTemplate.selectList(getStatement(SQL_LIST_ALL));
    }

    @SuppressWarnings("unchecked")
    public T getBy(Map<String, Object> paramMap) {
        return (T) this.getBy(paramMap, SQL_LIST_BY);
    }

    public Object getBy(Map<String, Object> paramMap, String sqlId) {
        if (paramMap == null)
            paramMap = new HashMap<String, Object>();
        return this.getSqlSession().selectOne(getStatement(sqlId), paramMap);
    }

    public List<T> listBy(Map<String, Object> paramMap) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY), paramMap);
    }

    public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
        if (paramMap == null)
            paramMap = new HashMap<String, Object>();

        return sessionTemplate.selectList(getStatement(sqlId), paramMap);
    }

    public PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap) {

        if (paramMap == null)
            paramMap = new HashMap<String, Object>();

        // 获取分页数据集 , 注切勿换成 sessionTemplate 对象
        List<T> list = getSqlSession().selectList(getStatement(SQL_LIST_PAGE), paramMap,
                new RowBounds((pageParam.getPageNum() - 1) * pageParam.getNumPerPage(), pageParam.getNumPerPage()));

        // 统计总记录数
//        Object countObject = getSqlSession().selectOne(getStatement(SQL_LIST_PAGE),
//                new ExecutorInterceptor.CountParameter(paramMap));
//        Long count = Long.valueOf(countObject.toString());
        Long count = sessionTemplate.selectOne(getStatement(SQL_LIST_PAGE_COUNT), paramMap);

        // 是否统计当前分页条件下的数据：1:是，其他为否
        Object isCount = paramMap.get("isCount");
        if (isCount != null && "1".equals(isCount.toString())) {
            Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
            return new PageBean<T>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list, countResultMap);
        } else {
            return new PageBean<T>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
        }
    }

    public PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {

        if (paramMap == null)
            paramMap = new HashMap<String, Object>();

        // 获取分页数据集 , 注切勿换成 sessionTemplate 对象
        List<T> list = getSqlSession().selectList(getStatement(sqlId), paramMap,
                new RowBounds((pageParam.getPageNum() - 1) * pageParam.getNumPerPage(), pageParam.getNumPerPage()));

        // 统计总记录数
//        Object countObject = getSqlSession().selectOne(getStatement(sqlId), new ExecutorInterceptor.CountParameter(paramMap));
//        Long count = Long.valueOf(countObject.toString());
        Long count = sessionTemplate.selectOne(getStatement(SQL_LIST_PAGE_COUNT), paramMap);

        return new PageBean<T>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
    }

    protected String getStatement(String sqlId) {
        String name = this.getClass().getName();
        return name + "." + sqlId;
    }
}
