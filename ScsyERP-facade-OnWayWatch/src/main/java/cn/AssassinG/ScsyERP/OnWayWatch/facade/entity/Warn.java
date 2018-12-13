package cn.AssassinG.ScsyERP.OnWayWatch.facade.entity;

import cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnStatus;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnType;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Entity
public class Warn extends BaseEntity {
    private static final long serialVersionUID = -8047870212524375383L;
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

    @JSONField(serialize = false)
    public cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnType getWarnType() {
        return WarnType;
    }

    @JSONField(deserialize = false)
    public void setWarnType(cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnType warnType) {
        WarnType = warnType;
    }

    @JSONField(name = "warnType")
    public String getWarnTypeName(){
        if(WarnType != null)
            return this.WarnType.getName();
        else
            return "";
    }

    @JSONField(name = "warnType")
    public void setWarnTypeName(String name){
        this.WarnType = cn.AssassinG.ScsyERP.OnWayWatch.facade.enums.WarnType.getEnum(name);
    }

    @JSONField(serialize = false)
    public WarnStatus getStatus() {
        return Status;
    }

    @JSONField(deserialize = false)
    public void setStatus(WarnStatus status) {
        Status = status;
    }

    @JSONField(name = "status")
    public String getWarnStatusName(){
        if(Status != null)
            return this.Status.getName();
        else
            return "";
    }

    @JSONField(name = "status")
    public void setWarnStatusName(String name){
        this.Status = WarnStatus.getEnum(name);
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
