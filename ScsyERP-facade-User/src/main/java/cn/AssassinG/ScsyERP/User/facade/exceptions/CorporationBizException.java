package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class CorporationBizException extends BizException {

    public static final int CORPORATIONBIZ_UNKNOWN_ERROR   = 11000000;//未知错误
    public static final int CORPORATIONBIZ_PARAMS_ILLEGAL  = 11000001;//参数不合法
    public static final int CORPORATIONBIZ_DBUNIQUE_ERROR  = 11000002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int CORPORATIONBIZ_NOSUIT_RESULT   = 11000003;//没有找到符合条件的记录以进行下一步操作
    public static final int CORPORATIONBIZ_NOPERMISSION    = 11000004;//没有权限
    public static final int CORPORATIONBIZ_CANNOTOPERATE   = 11000005;//无法操作，比如用户名重复等

    public CorporationBizException(){super();}
    public CorporationBizException(int code, String msg) {
        super(code, msg);
    }
    public CorporationBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
