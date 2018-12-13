package cn.AssassinG.ScsyERP.InStorage.facade.entity;

import cn.AssassinG.ScsyERP.InStorage.facade.enums.InStorageFormStatus;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.FormEntity;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Entity
public class InStorageForm extends FormEntity {
    private static final long serialVersionUID = -1523511587846385659L;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long Project;
    @Valid(varType = Valid.VarType.Other)
    private InStorageFormStatus InStorageStatus;
    private String InStorageNumber;
    @Valid(varType = Valid.VarType.Other)
    private Date InStorageTime;
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
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxValue = 99999)
    private Long WorkingProduct;//正在运输的货物

    public InStorageForm() {
        super();
    }

    public Long getProject() {
        return Project;
    }

    public void setProject(Long project) {
        Project = project;
    }

    @JSONField(serialize = false)
    public InStorageFormStatus getInStorageStatus() {
        return InStorageStatus;
    }

    @JSONField(deserialize = false)
    public void setInStorageStatus(InStorageFormStatus inStorageStatus) {
        InStorageStatus = inStorageStatus;
    }

    @JSONField(name = "inStorageStatus")
    public String getInStorageFormStatusName(){
        if(InStorageStatus != null)
            return this.InStorageStatus.getName();
        else
            return "";
    }

    @JSONField(name = "inStorageStatus")
    public void setInStorageFormStatusName(String name){
        this.InStorageStatus = InStorageFormStatus.getEnum(name);
    }

    public String getInStorageNumber() {
        return InStorageNumber;
    }

    public void setInStorageNumber(String inStorageNumber) {
        InStorageNumber = inStorageNumber;
    }

    public Date getInStorageTime() {
        return InStorageTime;
    }

    public void setInStorageTime(Date inStorageTime) {
        InStorageTime = inStorageTime;
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

    @JSONField(serialize = false)
    public cn.AssassinG.ScsyERP.common.enums.AccountStatus getAccountStatus() {
        return AccountStatus;
    }

    @JSONField(deserialize = false)
    public void setAccountStatus(cn.AssassinG.ScsyERP.common.enums.AccountStatus accountStatus) {
        AccountStatus = accountStatus;
    }

    @JSONField(name = "accountStatus")
    public String getAccountStatusName(){
        if(AccountStatus != null)
            return this.AccountStatus.getName();
        else
            return "";
    }

    @JSONField(name = "accountStatus")
    public void setAccountStatusName(String name){
        this.AccountStatus = cn.AssassinG.ScsyERP.common.enums.AccountStatus.getEnum(name);
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

    public Long getWorkingProduct() {
        return WorkingProduct;
    }

    public void setWorkingProduct(Long workingProduct) {
        this.WorkingProduct = workingProduct;
    }

    @Override
    public String toString() {
        return "InStorageForm{" +
                "Project=" + Project +
                ", InStorageStatus=" + InStorageStatus +
                ", InStorageNumber='" + InStorageNumber + '\'' +
                ", InStorageTime=" + InStorageTime +
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
                ", WorkingProduct=" + WorkingProduct +
                ", IfCompleted=" + IfCompleted +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
