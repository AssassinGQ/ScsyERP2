package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class EscortBizException extends BizException {

    public static final int ESCORTBIZ_UNKNOWN_ERROR   = 11040000;//未知错误
    public static final int ESCORTBIZ_PARAMS_ILLEGAL  = 11040001;//参数不合法
    public static final int ESCORTBIZ_DBUNIQUE_ERROR  = 11040002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int ESCORTBIZ_NOSUIT_RESULT   = 11040003;//没有找到符合条件的记录以进行下一步操作
    public static final int ESCORTBIZ_NOPERMISSION    = 11040004;//没有权限
    public static final int ESCORTBIZ_CANNOTOPERATE   = 11040005;//无法操作，比如用户名重复等

    public EscortBizException(){super();}
    public EscortBizException(int code, String msg) {
        super(code, msg);
    }
    public EscortBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
