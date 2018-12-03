package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class ConsigneeBizException extends BizException {

    public static final int CONSIGNEEBIZ_UNKNOWN_ERROR   = 11070000;//未知错误
    public static final int CONSIGNEEBIZ_PARAMS_ILLEGAL  = 11070001;//参数不合法
    public static final int CONSIGNEEBIZ_DBUNIQUE_ERROR  = 11070002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int CONSIGNEEBIZ_NOSUIT_RESULT   = 11070003;//没有找到符合条件的记录以进行下一步操作
    public static final int CONSIGNEEBIZ_NOPERMISSION    = 11070004;//没有权限
    public static final int CONSIGNEEBIZ_CANNOTOPERATE   = 11070005;//无法操作，比如用户名重复等

    public ConsigneeBizException(){super();}
    public ConsigneeBizException(int code, String msg) {
        super(code, msg);
    }
    public ConsigneeBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
