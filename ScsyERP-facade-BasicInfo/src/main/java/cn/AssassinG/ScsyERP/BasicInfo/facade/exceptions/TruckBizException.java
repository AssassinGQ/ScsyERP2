package cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class TruckBizException extends BizException {

    public static final int TRUCKBIZ_UNKNOWN_ERROR   = 12040000;//未知错误
    public static final int TRUCKBIZ_PARAMS_ILLEGAL  = 12040001;//参数不合法
    public static final int TRUCKBIZ_DBUNIQUE_ERROR  = 12040002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int TRUCKBIZ_NOSUIT_RESULT   = 12040003;//没有找到符合条件的记录以进行下一步操作
    public static final int TRUCKBIZ_NOPERMISSION    = 12040004;//没有权限
    public static final int TRUCKBIZ_CANNOTOPERATE   = 12040005;//无法操作，比如用户名重复等

    public TruckBizException(){super();}
    public TruckBizException(int code, String msg) {
        super(code, msg);
    }
    public TruckBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
