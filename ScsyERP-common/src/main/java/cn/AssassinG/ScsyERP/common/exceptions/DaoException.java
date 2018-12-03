package cn.AssassinG.ScsyERP.common.exceptions;

public class DaoException extends RuntimeException {
    /**
     * 数据库操作,insert 异常
     */
    public static final DaoException DB_INSERT_EXCEPTION = new DaoException(90040001, "数据库insert操作异常");

    /**
     * 数据库操作,update 异常
     */
    public static final DaoException DB_UPDATE_EXCEPTION = new DaoException(90040002, "数据库update操作异常");

    /**
     * 数据库操作,delete 异常
     */
    public static final DaoException DB_DELETE_EXCEPTION = new DaoException(90040003, "数据库update操作异常");

    /**
     * 数据库操作,selectOne 异常
     */
    public static final DaoException DB_SELECTONE_EXCEPTION = new DaoException(90040004, "数据库selectOne操作异常");

    /**
     * 数据库操作,getBy 异常
     */
    public static final DaoException DB_GETBY_EXCEPTION = new DaoException(90040005, "数据库getBy操作异常");

    /**
     * 数据库操作,list 异常
     */
    public static final DaoException DB_LIST_EXCEPTION = new DaoException(90040006, "数据库list操作异常");

    /**
     * 数据库操作,其他查询操作异常
     */
    public static final DaoException DB_QUERY_EXCEPTION = new DaoException(90040007, "数据库查询操作异常");

    /**
     * Token 验证不通过
     */
//    public static final DaoException TOKEN_IS_ILLICIT = new DaoException(90040007, "Token 验证非法");
    /**
     * 会话超时　获取session时，如果是空，throws 下面这个异常 拦截器会拦截爆会话超时页面
     */
//    public static final DaoException SESSION_IS_OUT_TIME = new DaoException(90040008, "会话超时");

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    public DaoException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public DaoException() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public DaoException newInstance(String msgFormat, Object... args) {
        return new DaoException(this.code, msgFormat, args);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message) {
        super(message);
    }
}
