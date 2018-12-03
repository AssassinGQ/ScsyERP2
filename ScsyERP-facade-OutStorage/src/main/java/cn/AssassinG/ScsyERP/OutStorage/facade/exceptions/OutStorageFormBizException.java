package cn.AssassinG.ScsyERP.OutStorage.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class OutStorageFormBizException extends BizException {

    public static final int OUTSTORAGEFORMBIZ_UNKNOWN_ERROR   = 14000000;//未知错误
    public static final int OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL  = 14000001;//参数不合法
    public static final int OUTSTORAGEFORMBIZ_DBUNIQUE_ERROR  = 14000002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int OUTSTORAGEFORMBIZ_NOSUIT_RESULT   = 14000003;//没有找到符合条件的记录以进行下一步操作
    public static final int OUTSTORAGEFORMBIZ_NOPERMISSION    = 14000004;//没有权限
    public static final int OUTSTORAGEFORMBIZ_CANNOTOPERATE   = 14000005;//无法操作，比如用户名重复等

    public OutStorageFormBizException(){super();}
    public OutStorageFormBizException(int code, String msg) {
        super(code, msg);
    }
    public OutStorageFormBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
