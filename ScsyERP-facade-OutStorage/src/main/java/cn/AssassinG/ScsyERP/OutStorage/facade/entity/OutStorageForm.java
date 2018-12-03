package cn.AssassinG.ScsyERP.OutStorage.facade.entity;

import cn.AssassinG.ScsyERP.OutStorage.facade.enums.OutStorageFormStatus;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;

import java.util.Date;
import java.util.Set;

public class OutStorageForm extends BaseEntity {
    @Valid(varType = Valid.VarType.Number)
    private Long Project;
    @Valid(varType = Valid.VarType.Other)
    private OutStorageFormStatus OutStorageStatus;
    private String OutStorageNumber;
    @Valid(varType = Valid.VarType.Other)
    private Date OutStorageTime;
    @Valid(varType = Valid.VarType.Number)
    private Long Warehouse;
    @Valid(varType = Valid.VarType.Number)
    private Long Truck;
    @Valid(varType = Valid.VarType.Number)
    private Long PickWorker;
    @Valid(varType = Valid.VarType.Number)
    private Long Lister;
    private Set<Long> DriveWorkers;
    private Set<Long> LiftWorkers;
    private AccountStatus AccountStatus;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxValue = 9999)
    private Integer TotalAmount;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxValue = 99999)
    private Double TotalVolume;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxValue = 99999)
    private Double TotalWeight;
    private Set<Long> Products;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxValue = 999999)
    private Double RealOutStorageWeight;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxValue = 999999)
    private Double DriveWorkerAverageWeight;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxValue = 999999)
    private Double LiftWorkerAverageWeight;

    public OutStorageForm() {
        super();
    }

    public Long getProject() {
        return Project;
    }

    public void setProject(Long project) {
        Project = project;
    }

    public OutStorageFormStatus getOutStorageStatus() {
        return OutStorageStatus;
    }

    public void setOutStorageStatus(OutStorageFormStatus outStorageStatus) {
        OutStorageStatus = outStorageStatus;
    }

    public String getOutStorageNumber() {
        return OutStorageNumber;
    }

    public void setOutStorageNumber(String outStorageNumber) {
        OutStorageNumber = outStorageNumber;
    }

    public Date getOutStorageTime() {
        return OutStorageTime;
    }

    public void setOutStorageTime(Date outStorageTime) {
        OutStorageTime = outStorageTime;
    }

    public Long getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(Long warehouse) {
        Warehouse = warehouse;
    }

    public Long getTruck() {
        return Truck;
    }

    public void setTruck(Long truck) {
        Truck = truck;
    }

    public Long getPickWorker() {
        return PickWorker;
    }

    public void setPickWorker(Long pickWorker) {
        PickWorker = pickWorker;
    }

    public Long getLister() {
        return Lister;
    }

    public void setLister(Long lister) {
        Lister = lister;
    }

    public Set<Long> getDriveWorkers() {
        return DriveWorkers;
    }

    public void setDriveWorkers(Set<Long> driveWorkers) {
        DriveWorkers = driveWorkers;
    }

    public Set<Long> getLiftWorkers() {
        return LiftWorkers;
    }

    public void setLiftWorkers(Set<Long> liftWorkers) {
        LiftWorkers = liftWorkers;
    }

    public cn.AssassinG.ScsyERP.common.enums.AccountStatus getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(cn.AssassinG.ScsyERP.common.enums.AccountStatus accountStatus) {
        AccountStatus = accountStatus;
    }

    public Integer getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        TotalAmount = totalAmount;
    }

    public Double getTotalVolume() {
        return TotalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        TotalVolume = totalVolume;
    }

    public Double getTotalWeight() {
        return TotalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        TotalWeight = totalWeight;
    }

    public Set<Long> getProducts() {
        return Products;
    }

    public void setProducts(Set<Long> products) {
        Products = products;
    }

    public Double getRealOutStorageWeight() {
        return RealOutStorageWeight;
    }

    public void setRealOutStorageWeight(Double realOutStorageWeight) {
        RealOutStorageWeight = realOutStorageWeight;
    }

    public Double getDriveWorkerAverageWeight() {
        return DriveWorkerAverageWeight;
    }

    public void setDriveWorkerAverageWeight(Double driveWorkerAverageWeight) {
        DriveWorkerAverageWeight = driveWorkerAverageWeight;
    }

    public Double getLiftWorkerAverageWeight() {
        return LiftWorkerAverageWeight;
    }

    public void setLiftWorkerAverageWeight(Double liftWorkerAverageWeight) {
        LiftWorkerAverageWeight = liftWorkerAverageWeight;
    }

    @Override
    public String toString() {
        return "OutStorageForm{" +
                "Project=" + Project +
                ", OutStorageStatus=" + OutStorageStatus +
                ", OutStorageNumber='" + OutStorageNumber + '\'' +
                ", OutStorageTime=" + OutStorageTime +
                ", Warehouse=" + Warehouse +
                ", Truck=" + Truck +
                ", PickWorker=" + PickWorker +
                ", Lister=" + Lister +
                ", DriveWorkers=" + DriveWorkers +
                ", LiftWorkers=" + LiftWorkers +
                ", AccountStatus=" + AccountStatus +
                ", TotalAmount=" + TotalAmount +
                ", TotalVolume=" + TotalVolume +
                ", TotalWeight=" + TotalWeight +
                ", Products=" + Products +
                ", RealOutStorageWeight=" + RealOutStorageWeight +
                ", DriveWorkerAverageWeight=" + DriveWorkerAverageWeight +
                ", LiftWorkerAverageWeight=" + LiftWorkerAverageWeight +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
