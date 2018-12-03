package cn.AssassinG.ScsyERP.OnWayWatch.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class WarnBizException extends BizException {
    public static final int WARNBIZ_UNKNOWN_ERROR   = 15010000;//未知错误
    public static final int WARNBIZ_PARAMS_ILLEGAL  = 15010001;//参数不合法
    public static final int WARNBIZ_DBUNIQUE_ERROR  = 15010002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int WARNBIZ_NOSUIT_RESULT   = 15010003;//没有找到符合条件的记录以进行下一步操作
    public static final int WARNBIZ_NOPERMISSION    = 15010004;//没有权限
    public static final int WARNBIZ_CANNOTOPERATE   = 15010005;//无法操作，比如用户名重复等

    public WarnBizException(){super();}
    public WarnBizException(int code, String msg) {
        super(code, msg);
    }
    public WarnBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
