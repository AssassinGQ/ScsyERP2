package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.BasicInfo.facade.enums.PacketType;
import cn.AssassinG.ScsyERP.BasicInfo.facade.enums.ProductStatus;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;

@Entity
public class Product extends UnLoginableEntity {
    private static final long serialVersionUID = -4055954878508954177L;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long Project;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long Material;
    @Valid(varType = Valid.VarType.Other)
    private ProductStatus Status;
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    private String PacketNumber;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long Warehouse;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 30)
    private String WarehouseLocation;
    @Valid(varType = Valid.VarType.Number, nullAble = true)
    private Long InStorageForm;
    @Valid(varType = Valid.VarType.Number, nullAble = true)
    private Long OutStorageForm;
    @Valid(varType = Valid.VarType.Other)
    private PacketType PacketType;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxLength = 5)
    private Double Width;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxLength = 5)
    private Double Height;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxLength = 5)
    private Double Length;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxLength = 5)
    private Double Weight;
    @Valid(varType = Valid.VarType.Number, nullAble = true, maxLength = 5)
    private Double Volume;

    public Product() {
        super();
        this.Status = ProductStatus.YRK;
    }

    public Long getProject() {
        return Project;
    }

    public void setProject(Long project) {
        Project = project;
    }

    public Long getMaterial() {
        return Material;
    }

    public void setMaterial(Long material) {
        Material = material;
    }

    @JSONField(serialize = false)
    public ProductStatus getStatus() {
        return Status;
    }

    @JSONField(deserialize = false)
    public void setStatus(ProductStatus status) {
        Status = status;
    }

    @JSONField(name = "status")
    public String getStatusName(){
        if(Status != null)
            return this.Status.getName();
        else
            return "";
    }

    @JSONField(name = "status")
    public void setStatusName(String name){
        this.Status = ProductStatus.getEnum(name);
    }

    public String getPacketNumber() {
        return PacketNumber;
    }

    public void setPacketNumber(String packetNumber) {
        PacketNumber = packetNumber;
    }

    public Long getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(Long warehouse) {
        Warehouse = warehouse;
    }

    public String getWarehouseLocation() {
        return WarehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        WarehouseLocation = warehouseLocation;
    }

    public Long getInStorageForm() {
        return InStorageForm;
    }

    public void setInStorageForm(Long inStorageForm) {
        InStorageForm = inStorageForm;
    }

    public Long getOutStorageForm() {
        return OutStorageForm;
    }

    public void setOutStorageForm(Long outStorageForm) {
        OutStorageForm = outStorageForm;
    }

    @JSONField(serialize = false)
    public cn.AssassinG.ScsyERP.BasicInfo.facade.enums.PacketType getPacketType() {
        return PacketType;
    }

    @JSONField(deserialize = false)
    public void setPacketType(cn.AssassinG.ScsyERP.BasicInfo.facade.enums.PacketType packetType) {
        PacketType = packetType;
    }

    @JSONField(name = "packetType")
    public String getPacketTypeName(){
        if(PacketType != null)
            return this.PacketType.getName();
        else
            return "";
    }

    @JSONField(name = "packetType")
    public void setPacketTypeName(String name){
        this.PacketType = cn.AssassinG.ScsyERP.BasicInfo.facade.enums.PacketType.getEnum(name);
    }

    public Double getWidth() {
        return Width;
    }

    public void setWidth(Double width) {
        Width = width;
    }

    public Double getHeight() {
        return Height;
    }

    public void setHeight(Double height) {
        Height = height;
    }

    public Double getLength() {
        return Length;
    }

    public void setLength(Double length) {
        Length = length;
    }

    public Double getWeight() {
        return Weight;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

    public Double getVolume() {
        return Volume;
    }

    public void setVolume(Double volume) {
        Volume = volume;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Project=" + Project +
                ", Material=" + Material +
                ", Status=" + Status +
                ", PacketNumber='" + PacketNumber + '\'' +
                ", Warehouse=" + Warehouse +
                ", WarehouseLocation='" + WarehouseLocation + '\'' +
                ", InStorageForm=" + InStorageForm +
                ", OutStorageForm=" + OutStorageForm +
                ", PacketType=" + PacketType +
                ", Width=" + Width +
                ", Height=" + Height +
                ", Length=" + Length +
                ", Weight=" + Weight +
                ", Volume=" + Volume +
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
