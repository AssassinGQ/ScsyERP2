package cn.AssassinG.ScsyERP.File.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class MyFileBizException extends BizException {

    public static final int MYFILEBIZ_UNKNOWN_ERROR   = 19000000;//未知错误
    public static final int MYFILEBIZ_PARAMS_ILLEGAL  = 19000001;//参数不合法
    public static final int MYFILEBIZ_DBUNIQUE_ERROR  = 19000002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int MYFILEBIZ_NOSUIT_RESULT   = 19000003;//没有找到符合条件的记录以进行下一步操作
    public static final int MYFILEBIZ_NOPERMISSION    = 19000004;//没有权限
    public static final int MYFILEBIZ_CANNOTOPERATE   = 19000005;//无法操作，比如用户名重复等

    public MyFileBizException(){super();}
    public MyFileBizException(int code, String msg) {
        super(code, msg);
    }
    public MyFileBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
