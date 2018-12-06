package cn.AssassinG.ScsyERP.common.exceptions;

public class BizException extends RuntimeException {
    /**
     * 业务异常基类，所有业务异常都必须继承于此异常
     *         定义异常时，需要先确定异常所属模块。例如：添加商户报错 可以定义为 [10020001] 前四位数为系统模块编号，后4位为错误代码 ,唯一 <br>
     *         用户登录信息               1000 <br>
     *
     *         承运方信息                 1100 <br>
     *         政府信息                   1101 <br>
     *         承运方管理员信息           1102 <br>
     *         驾驶员信息                 1103 <br>
     *         押运员信息                 1104 <br>
     *         客户信息                   1105 <br>
     *         生产厂家信息               1106 <br>
     *         收货单位信息               1107 <br>
     *
     *         行车工                     1200 <br>
     *         起重工                     1201 <br>
     *         生产厂家下属车间信息       1202 <br>
     *         仓库信息                   1203 <br>
     *         车辆信息                   1204 <br>
     *         工程信息                   1205 <br>
     *         物料信息                   1206 <br>
     *         货物信息                   1207 <br>
     *
     *         入库业务                   1300 <br>
     *         出库业务                   1400 <br>
     *
     *         行车日志业务               1500 <br>
     *         异常信息业务               1501 <br>
     *
     *         费用结算业务               1600 <br>
     *         数据统计业务               1700 <br>
     *         管理网页门户               1800 <br>
     *         文件业务                   1900 <br>
     */

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    public BizException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public BizException() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message) {
        super(message);
    }
}
