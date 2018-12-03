package cn.AssassinG.ScsyERP.OnWayWatch.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

import java.util.Date;

public class TruckLog extends BaseEntity {
    @Valid(varType = Valid.VarType.Number)
    private Long OutStorageForm;
    @Valid(varType = Valid.VarType.Number)
    private Long Truck;
    @Valid(varType = Valid.VarType.Other)
    private Date Time;
    @Valid(varType = Valid.VarType.Number)
    private Double Distance;
    @Valid(varType = Valid.VarType.Number, maxValue = 370)
    private Double GPSX;
    @Valid(varType = Valid.VarType.Number, maxValue = 370)
    private Double GPSY;
    @Valid(varType = Valid.VarType.Number, maxValue = 99999)
    private Double Speed;
    @Valid(varType = Valid.VarType.Number, maxValue = 99999)
    private Double FuelVol;
    @Valid(varType = Valid.VarType.Number)
    private Double LeftTirePressure;
    @Valid(varType = Valid.VarType.Number)
    private Double RightTirePressure;
    @Valid(varType = Valid.VarType.Number)
    private Double LeftTireTemp;
    @Valid(varType = Valid.VarType.Number)
    private Double RightTireTemp;
    private String Posture;
    @Valid(varType = Valid.VarType.Other)
    private Boolean HasWarn;
    private Long Warn;

    public TruckLog() {
        super();
    }

    public Long getOutStorageForm() {
        return OutStorageForm;
    }

    public void setOutStorageForm(Long outStorageForm) {
        OutStorageForm = outStorageForm;
    }

    public Long getTruck() {
        return Truck;
    }

    public void setTruck(Long truck) {
        Truck = truck;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public Double getDistance() {
        return Distance;
    }

    public void setDistance(Double distance) {
        Distance = distance;
    }

    public Double getGPSX() {
        return GPSX;
    }

    public void setGPSX(Double GPSX) {
        this.GPSX = GPSX;
    }

    public Double getGPSY() {
        return GPSY;
    }

    public void setGPSY(Double GPSY) {
        this.GPSY = GPSY;
    }

    public Double getSpeed() {
        return Speed;
    }

    public void setSpeed(Double speed) {
        Speed = speed;
    }

    public Double getFuelVol() {
        return FuelVol;
    }

    public void setFuelVol(Double fuelVol) {
        FuelVol = fuelVol;
    }

    public Double getLeftTirePressure() {
        return LeftTirePressure;
    }

    public void setLeftTirePressure(Double leftTirePressure) {
        LeftTirePressure = leftTirePressure;
    }

    public Double getRightTirePressure() {
        return RightTirePressure;
    }

    public void setRightTirePressure(Double rightTirePressure) {
        RightTirePressure = rightTirePressure;
    }

    public Double getLeftTireTemp() {
        return LeftTireTemp;
    }

    public void setLeftTireTemp(Double leftTireTemp) {
        LeftTireTemp = leftTireTemp;
    }

    public Double getRightTireTemp() {
        return RightTireTemp;
    }

    public void setRightTireTemp(Double rightTireTemp) {
        RightTireTemp = rightTireTemp;
    }

    public String getPosture() {
        return Posture;
    }

    public void setPosture(String posture) {
        Posture = posture;
    }

    public Boolean getHasWarn() {
        return HasWarn;
    }

    public void setHasWarn(Boolean hasWarn) {
        HasWarn = hasWarn;
    }

    public Long getWarn() {
        return Warn;
    }

    public void setWarn(Long warn) {
        Warn = warn;
    }

    @Override
    public String toString() {
        return "TruckLog{" +
                "OutStorageForm=" + OutStorageForm +
                ", Truck=" + Truck +
                ", Time=" + Time +
                ", Distance=" + Distance +
                ", GPSX=" + GPSX +
                ", GPSY=" + GPSY +
                ", Speed=" + Speed +
                ", FuelVol=" + FuelVol +
                ", LeftTirePressure=" + LeftTirePressure +
                ", RightTirePressure=" + RightTirePressure +
                ", LeftTireTemp=" + LeftTireTemp +
                ", RightTireTemp=" + RightTireTemp +
                ", Posture='" + Posture + '\'' +
                ", HasWarn=" + HasWarn +
                ", Warn=" + Warn +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
