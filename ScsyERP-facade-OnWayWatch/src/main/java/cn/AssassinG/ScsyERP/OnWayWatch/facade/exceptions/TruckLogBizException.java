package cn.AssassinG.ScsyERP.OnWayWatch.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class TruckLogBizException extends BizException {
    public static final int TRUCKLOGBIZ_UNKNOWN_ERROR   = 15000000;//未知错误
    public static final int TRUCKLOGBIZ_PARAMS_ILLEGAL  = 15000001;//参数不合法
    public static final int TRUCKLOGBIZ_DBUNIQUE_ERROR  = 15000002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int TRUCKLOGBIZ_NOSUIT_RESULT   = 15000003;//没有找到符合条件的记录以进行下一步操作
    public static final int TRUCKLOGBIZ_NOPERMISSION    = 15000004;//没有权限
    public static final int TRUCKLOGBIZ_CANNOTOPERATE   = 15000005;//无法操作，比如用户名重复等

    public TruckLogBizException(){super();}
    public TruckLogBizException(int code, String msg) {
        super(code, msg);
    }
    public TruckLogBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
