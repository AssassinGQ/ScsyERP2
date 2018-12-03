package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class UserBizException extends BizException {

    public static final int USERBIZ_UNKNOWN_ERROR   = 10000000;//未知错误
    public static final int USERBIZ_PARAMS_ILLEGAL  = 10000001;//参数不合法
    public static final int USERBIZ_DBUNIQUE_ERROR  = 10000002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int USERBIZ_NOSUIT_RESULT   = 10000003;//没有找到符合条件的记录以进行下一步操作
    public static final int USERBIZ_NOPERMISSION    = 10000004;//没有权限
    public static final int USERBIZ_CANNOTOPERATE   = 10000005;//无法操作，比如用户名重复等

    public UserBizException(){super();}
    public UserBizException(int code, String msg) {
        super(code, msg);
    }
    public UserBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
