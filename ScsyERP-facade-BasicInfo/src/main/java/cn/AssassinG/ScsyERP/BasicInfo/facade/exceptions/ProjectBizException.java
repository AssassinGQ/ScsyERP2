package cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class ProjectBizException extends BizException {

    public static final int PROJECTBIZ_UNKNOWN_ERROR   = 12050000;//未知错误
    public static final int PROJECTBIZ_PARAMS_ILLEGAL  = 12050001;//参数不合法
    public static final int PROJECTBIZ_DBUNIQUE_ERROR  = 12050002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int PROJECTBIZ_NOSUIT_RESULT   = 12050003;//没有找到符合条件的记录以进行下一步操作
    public static final int PROJECTBIZ_NOPERMISSION    = 12050004;//没有权限
    public static final int PROJECTBIZ_CANNOTOPERATE   = 12050005;//无法操作，比如用户名重复等

    public ProjectBizException(){super();}
    public ProjectBizException(int code, String msg) {
        super(code, msg);
    }
    public ProjectBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
