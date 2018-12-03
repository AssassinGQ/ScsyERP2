package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

public class Driver extends LoginableEntity {
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 50)
    private String DriverLicense;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 50)
    private String CapableCar;
    @Valid(varType = Valid.VarType.Number, nullAble = true, minLength = 20, maxLength = 20)
    private Long IDCardPhoto;

    public Driver() {
        super();
    }

    public String getDriverLicense() {
        return DriverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        DriverLicense = driverLicense;
    }

    public String getCapableCar() {
        return CapableCar;
    }

    public void setCapableCar(String capableCar) {
        CapableCar = capableCar;
    }

    public Long getIDCardPhoto() {
        return IDCardPhoto;
    }

    public void setIDCardPhoto(Long IDCardPhoto) {
        this.IDCardPhoto = IDCardPhoto;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "DriverLicense='" + DriverLicense + '\'' +
                ", CapableCar='" + CapableCar + '\'' +
                ", IDCardPhoto=" + IDCardPhoto +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
