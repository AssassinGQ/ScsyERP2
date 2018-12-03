package cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class DriveWorkerBizException extends BizException {

    public static final int DRIVEWORKERBIZ_UNKNOWN_ERROR   = 12000000;//未知错误
    public static final int DRIVEWORKERBIZ_PARAMS_ILLEGAL  = 12000001;//参数不合法
    public static final int DRIVEWORKERBIZ_DBUNIQUE_ERROR  = 12000002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int DRIVEWORKERBIZ_NOSUIT_RESULT   = 12000003;//没有找到符合条件的记录以进行下一步操作
    public static final int DRIVEWORKERBIZ_NOPERMISSION    = 12000004;//没有权限
    public static final int DRIVEWORKERBIZ_CANNOTOPERATE   = 12000005;//无法操作，比如用户名重复等

    public DriveWorkerBizException(){super();}
    public DriveWorkerBizException(int code, String msg) {
        super(code, msg);
    }
    public DriveWorkerBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
