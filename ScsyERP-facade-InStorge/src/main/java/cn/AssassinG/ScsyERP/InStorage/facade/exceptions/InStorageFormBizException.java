package cn.AssassinG.ScsyERP.InStorage.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class InStorageFormBizException extends BizException {

    public static final int INSTORAGEFORMBIZ_UNKNOWN_ERROR   = 13000000;//未知错误
    public static final int INSTORAGEFORMBIZ_PARAMS_ILLEGAL  = 13000001;//参数不合法
    public static final int INSTORAGEFORMBIZ_DBUNIQUE_ERROR  = 13000002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int INSTORAGEFORMBIZ_NOSUIT_RESULT   = 13000003;//没有找到符合条件的记录以进行下一步操作
    public static final int INSTORAGEFORMBIZ_NOPERMISSION    = 13000004;//没有权限
    public static final int INSTORAGEFORMBIZ_CANNOTOPERATE   = 13000005;//无法操作，比如用户名重复等

    public InStorageFormBizException(){super();}
    public InStorageFormBizException(int code, String msg) {
        super(code, msg);
    }
    public InStorageFormBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
