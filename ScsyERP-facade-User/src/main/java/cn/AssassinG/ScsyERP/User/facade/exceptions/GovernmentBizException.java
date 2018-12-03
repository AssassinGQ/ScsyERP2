package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class GovernmentBizException extends BizException {

    public static final int GOVERNMENTBIZ_UNKNOWN_ERROR   = 11010000;//未知错误
    public static final int GOVERNMENTBIZ_PARAMS_ILLEGAL  = 11010001;//参数不合法
    public static final int GOVERNMENTBIZ_DBUNIQUE_ERROR  = 11010002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int GOVERNMENTBIZ_NOSUIT_RESULT   = 11010003;//没有找到符合条件的记录以进行下一步操作
    public static final int GOVERNMENTBIZ_NOPERMISSION    = 11010004;//没有权限
    public static final int GOVERNMENTBIZ_CANNOTOPERATE   = 11010005;//无法操作，比如用户名重复等

    public GovernmentBizException(){super();}
    public GovernmentBizException(int code, String msg) {
        super(code, msg);
    }
    public GovernmentBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
