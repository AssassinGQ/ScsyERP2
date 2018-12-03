package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

public class Truck extends UnLoginableEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    private String CarNumber;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 30)
    private String CarLicense;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 30)
    private String CarId;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 50)
    private String Affiliation;
    @Valid(varType = Valid.VarType.Number, nullAble = true, minLength = 20, maxLength = 20)
    private Long Driver;

    public Truck() {
        super();
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public String getCarLicense() {
        return CarLicense;
    }

    public void setCarLicense(String carLicense) {
        CarLicense = carLicense;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public String getAffiliation() {
        return Affiliation;
    }

    public void setAffiliation(String affiliation) {
        Affiliation = affiliation;
    }

    public Long getDriver() {
        return Driver;
    }

    public void setDriver(Long driver) {
        Driver = driver;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "CarNumber='" + CarNumber + '\'' +
                ", CarLicense='" + CarLicense + '\'' +
                ", CarId='" + CarId + '\'' +
                ", Affiliation='" + Affiliation + '\'' +
                ", Driver='" + Driver + '\'' +
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
