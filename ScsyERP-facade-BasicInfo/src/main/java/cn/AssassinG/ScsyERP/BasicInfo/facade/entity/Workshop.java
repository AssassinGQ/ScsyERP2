package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

public class Workshop extends UnLoginableEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 100)
    private String Address;
    @Valid(varType = Valid.VarType.Number, nullAble = true, minLength = 20, maxLength = 20)
    private Long Manufacturer;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 30)
    private String ManName;

    public Workshop() {
        super();
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Long getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(Long manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getManName() {
        return ManName;
    }

    public void setManName(String manName) {
        ManName = manName;
    }

    @Override
    public String toString() {
        return "Workshop{" +
                "Address='" + Address + '\'' +
                ", Manufacturer=" + Manufacturer +
                ", ManName='" + ManName + '\'' +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
