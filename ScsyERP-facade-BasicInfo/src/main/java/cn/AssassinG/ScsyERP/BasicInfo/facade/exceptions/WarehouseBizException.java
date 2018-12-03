package cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class WarehouseBizException extends BizException {

    public static final int WAREHOUSEBIZ_UNKNOWN_ERROR   = 12030000;//未知错误
    public static final int WAREHOUSEBIZ_PARAMS_ILLEGAL  = 12030001;//参数不合法
    public static final int WAREHOUSEBIZ_DBUNIQUE_ERROR  = 12030002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int WAREHOUSEBIZ_NOSUIT_RESULT   = 12030003;//没有找到符合条件的记录以进行下一步操作
    public static final int WAREHOUSEBIZ_NOPERMISSION    = 12030004;//没有权限
    public static final int WAREHOUSEBIZ_CANNOTOPERATE   = 12030005;//无法操作，比如用户名重复等

    public WarehouseBizException(){super();}
    public WarehouseBizException(int code, String msg) {
        super(code, msg);
    }
    public WarehouseBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
