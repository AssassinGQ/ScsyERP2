package cn.AssassinG.ScsyERP.Fee.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class TransportContractBizException extends BizException {

    public static final int TRANSPORTCONTRACTBIZ_UNKNOWN_ERROR   = 16010000;//未知错误
    public static final int TRANSPORTCONTRACTBIZ_PARAMS_ILLEGAL  = 16010001;//参数不合法
    public static final int TRANSPORTCONTRACTBIZ_DBUNIQUE_ERROR  = 16010002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int TRANSPORTCONTRACTBIZ_NOSUIT_RESULT   = 16010003;//没有找到符合条件的记录以进行下一步操作
    public static final int TRANSPORTCONTRACTBIZ_NOPERMISSION    = 16010004;//没有权限
    public static final int TRANSPORTCONTRACTBIZ_CANNOTOPERATE   = 16010005;//无法操作，比如用户名重复等

    public TransportContractBizException(){super();}
    public TransportContractBizException(int code, String msg) {
        super(code, msg);
    }
    public TransportContractBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
