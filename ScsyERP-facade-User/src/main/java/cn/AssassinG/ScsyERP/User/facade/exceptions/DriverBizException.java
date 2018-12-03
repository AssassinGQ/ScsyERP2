package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class DriverBizException extends BizException {

    public static final int DRIVERBIZ_UNKNOWN_ERROR   = 11030000;//未知错误
    public static final int DRIVERBIZ_PARAMS_ILLEGAL  = 11030001;//参数不合法
    public static final int DRIVERBIZ_DBUNIQUE_ERROR  = 11030002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int DRIVERBIZ_NOSUIT_RESULT   = 11030003;//没有找到符合条件的记录以进行下一步操作
    public static final int DRIVERBIZ_NOPERMISSION    = 11030004;//没有权限
    public static final int DRIVERBIZ_CANNOTOPERATE   = 11030005;//无法操作，比如用户名重复等

    public DriverBizException(){super();}
    public DriverBizException(int code, String msg) {
        super(code, msg);
    }
    public DriverBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
