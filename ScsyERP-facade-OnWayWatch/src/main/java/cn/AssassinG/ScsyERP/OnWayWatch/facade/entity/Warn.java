package cn.AssassinG.ScsyERP.OnWayWatch.facade.entity;

import cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnStatus;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnType;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

import java.util.Date;
import java.util.Set;

public class Warn extends BaseEntity {
    @Valid(varType = Valid.VarType.Number)
    private Long OutStorageForm;
    @Valid(varType = Valid.VarType.Number)
    private Long Truck;
    @Valid(varType = Valid.VarType.Number)
    private Long TruckLog;
    private Date Time;
    @Valid(varType = Valid.VarType.Number, maxValue = 370)
    private Double GPSX;
    @Valid(varType = Valid.VarType.Number, maxValue = 370)
    private Double GPSY;
    @Valid(varType = Valid.VarType.Other)
    private WarnType WarnType;
    @Valid(varType = Valid.VarType.Other)
    private WarnStatus Status;
    private String WarnValue;
    private Set<Long> Pictures;

    public Warn() {
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

    public Long getTruckLog() {
        return TruckLog;
    }

    public void setTruckLog(Long truckLog) {
        TruckLog = truckLog;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
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

    public cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnType getWarnType() {
        return WarnType;
    }

    public void setWarnType(cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnType warnType) {
        WarnType = warnType;
    }

    public WarnStatus getStatus() {
        return Status;
    }

    public void setStatus(WarnStatus status) {
        Status = status;
    }

    public String getWarnValue() {
        return WarnValue;
    }

    public void setWarnValue(String warnValue) {
        WarnValue = warnValue;
    }

    public Set<Long> getPictures() {
        return Pictures;
    }

    public void setPictures(Set<Long> pictures) {
        Pictures = pictures;
    }

    @Override
    public String toString() {
        return "Warn{" +
                "OutStorageForm=" + OutStorageForm +
                ", Truck=" + Truck +
                ", TruckLog=" + TruckLog +
                ", Time=" + Time +
                ", GPSX=" + GPSX +
                ", GPSY=" + GPSY +
                ", WarnType=" + WarnType +
                ", Status=" + Status +
                ", WarnValue='" + WarnValue + '\'' +
                ", Pictures=" + Pictures +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
