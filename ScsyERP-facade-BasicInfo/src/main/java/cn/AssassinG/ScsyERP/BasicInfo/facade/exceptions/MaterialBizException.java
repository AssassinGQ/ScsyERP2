package cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class MaterialBizException extends BizException {

    public static final int MATERIALBIZ_UNKNOWN_ERROR   = 12060000;//未知错误
    public static final int MATERIALBIZ_PARAMS_ILLEGAL  = 12060001;//参数不合法
    public static final int MATERIALBIZ_DBUNIQUE_ERROR  = 12060002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int MATERIALBIZ_NOSUIT_RESULT   = 12060003;//没有找到符合条件的记录以进行下一步操作
    public static final int MATERIALBIZ_NOPERMISSION    = 12060004;//没有权限
    public static final int MATERIALBIZ_CANNOTOPERATE   = 12060005;//无法操作，比如用户名重复等

    public MaterialBizException(){super();}
    public MaterialBizException(int code, String msg) {
        super(code, msg);
    }
    public MaterialBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
