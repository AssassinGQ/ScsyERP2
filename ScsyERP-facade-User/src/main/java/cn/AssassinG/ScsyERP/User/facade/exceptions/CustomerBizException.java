package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class CustomerBizException extends BizException {

    public static final int CUSTOMERBIZ_UNKNOWN_ERROR   = 11050000;//未知错误
    public static final int CUSTOMERBIZ_PARAMS_ILLEGAL  = 11050001;//参数不合法
    public static final int CUSTOMERBIZ_DBUNIQUE_ERROR  = 11050002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int CUSTOMERBIZ_NOSUIT_RESULT   = 11050003;//没有找到符合条件的记录以进行下一步操作
    public static final int CUSTOMERBIZ_NOPERMISSION    = 11050004;//没有权限
    public static final int CUSTOMERBIZ_CANNOTOPERATE   = 11050005;//无法操作，比如用户名重复等

    public CustomerBizException(){super();}
    public CustomerBizException(int code, String msg) {
        super(code, msg);
    }
    public CustomerBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
