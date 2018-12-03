package cn.AssassinG.ScsyERP.Fee.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class OnTruckFormBizException extends BizException {

    public static final int ONTRUCKFORMBIZ_UNKNOWN_ERROR   = 16000000;//未知错误
    public static final int ONTRUCKFORMBIZ_PARAMS_ILLEGAL  = 16000001;//参数不合法
    public static final int ONTRUCKFORMBIZ_DBUNIQUE_ERROR  = 16000002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int ONTRUCKFORMBIZ_NOSUIT_RESULT   = 16000003;//没有找到符合条件的记录以进行下一步操作
    public static final int ONTRUCKFORMBIZ_NOPERMISSION    = 16000004;//没有权限
    public static final int ONTRUCKFORMBIZ_CANNOTOPERATE   = 16000005;//无法操作，比如用户名重复等

    public OnTruckFormBizException(){super();}
    public OnTruckFormBizException(int code, String msg) {
        super(code, msg);
    }
    public OnTruckFormBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
