package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

import java.util.Set;

public class Project extends BaseEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    private String Name;
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    private String ProjectNumber;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long Customer;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long Manufacturer;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long Consignee;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long Admin;
    private Set<Long> Materials;

    public Project() {
        super();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProjectNumber() {
        return ProjectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        ProjectNumber = projectNumber;
    }

    public Long getCustomer() {
        return Customer;
    }

    public void setCustomer(Long customer) {
        Customer = customer;
    }

    public Long getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(Long manufacturer) {
        Manufacturer = manufacturer;
    }

    public Long getConsignee() {
        return Consignee;
    }

    public void setConsignee(Long consignee) {
        Consignee = consignee;
    }

    public Long getAdmin() {
        return Admin;
    }

    public void setAdmin(Long admin) {
        Admin = admin;
    }

    public Set<Long> getMaterials() {
        return Materials;
    }

    public void setMaterials(Set<Long> materials) {
        Materials = materials;
    }

    @Override
    public String toString() {
        return "Project{" +
                "Name='" + Name + '\'' +
                ", ProjectNumber='" + ProjectNumber + '\'' +
                ", Customer=" + Customer +
                ", Manufacturer=" + Manufacturer +
                ", Consignee=" + Consignee +
                ", Admin=" + Admin +
                ", Materials=" + Materials +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
