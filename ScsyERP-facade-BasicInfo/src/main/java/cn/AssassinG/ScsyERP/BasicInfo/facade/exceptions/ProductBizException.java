package cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class ProductBizException extends BizException {

    public static final int PRODUCTBIZ_UNKNOWN_ERROR   = 12070000;//未知错误
    public static final int PRODUCTBIZ_PARAMS_ILLEGAL  = 12070001;//参数不合法
    public static final int PRODUCTBIZ_DBUNIQUE_ERROR  = 12070002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int PRODUCTBIZ_NOSUIT_RESULT   = 12070003;//没有找到符合条件的记录以进行下一步操作
    public static final int PRODUCTBIZ_NOPERMISSION    = 12070004;//没有权限
    public static final int PRODUCTBIZ_CANNOTOPERATE   = 12070005;//无法操作，比如用户名重复等

    public ProductBizException(){super();}
    public ProductBizException(int code, String msg) {
        super(code, msg);
    }
    public ProductBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
