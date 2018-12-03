package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class ManufacturerBizException extends BizException {

    public static final int MANUFACTURERBIZ_UNKNOWN_ERROR   = 11060000;//未知错误
    public static final int MANUFACTURERBIZ_PARAMS_ILLEGAL  = 11060001;//参数不合法
    public static final int MANUFACTURERBIZ_DBUNIQUE_ERROR  = 11060002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int MANUFACTURERBIZ_NOSUIT_RESULT   = 11060003;//没有找到符合条件的记录以进行下一步操作
    public static final int MANUFACTURERBIZ_NOPERMISSION    = 11060004;//没有权限
    public static final int MANUFACTURERBIZ_CANNOTOPERATE   = 11060005;//无法操作，比如用户名重复等

    public ManufacturerBizException(){super();}
    public ManufacturerBizException(int code, String msg) {
        super(code, msg);
    }
    public ManufacturerBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
