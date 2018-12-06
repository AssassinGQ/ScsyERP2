package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

import java.util.Set;

public class Manufacturer extends LoginableEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 100)
    private String Address;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 20)
    private String ManName;
    private Set<Long> Workshops;

    public Manufacturer() {
    }

    public Manufacturer(String address) {
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

    public Set<Long> getWorkshops() {
        return Workshops;
    }

    public void setWorkshops(Set<Long> workshops) {
        Workshops = workshops;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "Address='" + Address + '\'' +
                ", ManName='" + ManName + '\'' +
                ", Workshops=" + Workshops +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
