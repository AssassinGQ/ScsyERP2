package cn.AssassinG.ScsyERP.Fee.facade.entity;

import cn.AssassinG.ScsyERP.Fee.facade.enums.OilCardType;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

public class TransportContract extends BaseEntity {
    private String ContractNumber;
    private Long OnTruckForm;
    private Long Project;
    private Long OutStorageForm;
    private Long Truck;
    private String Supplier;
    private Double ProductInsurance;
    private Double RealWeight;
    private Double FareByWeight;
    private Double TotalFareByWeight;
    private Double FareByTruck;
    private Double PrePay;
    private OilCardType OilCardType;
    private String OilCardNumber;
    private Double OilCardMoney;
    private Double PreRepairFee;

    public TransportContract() {
        super();
    }

    public String getContractNumber() {
        return ContractNumber;
    }

    public void setContractNumber(String contractNumber) {
        ContractNumber = contractNumber;
    }

    public Long getOnTruckForm() {
        return OnTruckForm;
    }

    public void setOnTruckForm(Long onTruckForm) {
        OnTruckForm = onTruckForm;
    }

    public Long getProject() {
        return Project;
    }

    public void setProject(Long project) {
        Project = project;
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

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public Double getProductInsurance() {
        return ProductInsurance;
    }

    public void setProductInsurance(Double productInsurance) {
        ProductInsurance = productInsurance;
    }

    public Double getRealWeight() {
        return RealWeight;
    }

    public void setRealWeight(Double realWeight) {
        RealWeight = realWeight;
    }

    public Double getFareByWeight() {
        return FareByWeight;
    }

    public void setFareByWeight(Double fareByWeight) {
        FareByWeight = fareByWeight;
    }

    public Double getTotalFareByWeight() {
        return TotalFareByWeight;
    }

    public void setTotalFareByWeight(Double totalFareByWeight) {
        TotalFareByWeight = totalFareByWeight;
    }

    public Double getFareByTruck() {
        return FareByTruck;
    }

    public void setFareByTruck(Double fareByTruck) {
        FareByTruck = fareByTruck;
    }

    public Double getPrePay() {
        return PrePay;
    }

    public void setPrePay(Double prePay) {
        PrePay = prePay;
    }

    public cn.AssassinG.ScsyERP.Fee.facade.enums.OilCardType getOilCardType() {
        return OilCardType;
    }

    public void setOilCardType(cn.AssassinG.ScsyERP.Fee.facade.enums.OilCardType oilCardType) {
        OilCardType = oilCardType;
    }

    public String getOilCardNumber() {
        return OilCardNumber;
    }

    public void setOilCardNumber(String oilCardNumber) {
        OilCardNumber = oilCardNumber;
    }

    public Double getOilCardMoney() {
        return OilCardMoney;
    }

    public void setOilCardMoney(Double oilCardMoney) {
        OilCardMoney = oilCardMoney;
    }

    public Double getPreRepairFee() {
        return PreRepairFee;
    }

    public void setPreRepairFee(Double preRepairFee) {
        PreRepairFee = preRepairFee;
    }

    @Override
    public String toString() {
        return "TransportContract{" +
                "ContractNumber='" + ContractNumber + '\'' +
                ", OnTruckForm=" + OnTruckForm +
                ", Project=" + Project +
                ", OutStorageForm=" + OutStorageForm +
                ", Truck=" + Truck +
                ", Supplier='" + Supplier + '\'' +
                ", ProductInsurance=" + ProductInsurance +
                ", RealWeight=" + RealWeight +
                ", FareByWeight=" + FareByWeight +
                ", TotalFareByWeight=" + TotalFareByWeight +
                ", FareByTruck=" + FareByTruck +
                ", PrePay=" + PrePay +
                ", OilCardType=" + OilCardType +
                ", OilCardNumber='" + OilCardNumber + '\'' +
                ", OilCardMoney=" + OilCardMoney +
                ", PreRepairFee=" + PreRepairFee +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
