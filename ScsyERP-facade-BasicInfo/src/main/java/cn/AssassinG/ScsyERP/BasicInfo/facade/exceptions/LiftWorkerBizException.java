package cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class LiftWorkerBizException extends BizException {

    public static final int LIFTWORKERBIZ_UNKNOWN_ERROR   = 12010000;//未知错误
    public static final int LIFTWORKERBIZ_PARAMS_ILLEGAL  = 12010001;//参数不合法
    public static final int LIFTWORKERBIZ_DBUNIQUE_ERROR  = 12010002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int LIFTWORKERBIZ_NOSUIT_RESULT   = 12010003;//没有找到符合条件的记录以进行下一步操作
    public static final int LIFTWORKERBIZ_NOPERMISSION    = 12010004;//没有权限
    public static final int LIFTWORKERBIZ_CANNOTOPERATE   = 12010005;//无法操作，比如用户名重复等

    public LiftWorkerBizException(){super();}
    public LiftWorkerBizException(int code, String msg) {
        super(code, msg);
    }
    public LiftWorkerBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
