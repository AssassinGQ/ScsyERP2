package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

public class Consignee extends LoginableEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 100)
    private String Address;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 20)
    private String ManName;

    public Consignee() {
        super();
    }

    public Consignee(String address) {
        super();
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getManName() {
        return ManName;
    }

    public void setManName(String manName) {
        ManName = manName;
    }

    @Override
    public String toString() {
        return "Consignee{" +
                "Address='" + Address + '\'' +
                ", ManName='" + ManName + '\'' +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
