package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Project extends UnLoginableEntity {
    private static final long serialVersionUID = -1639306927016776025L;
    //    @Valid(varType = Valid.VarType.String, maxLength = 30)
//    private String Name;
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
                "ProjectNumber='" + ProjectNumber + '\'' +
                ", Customer=" + Customer +
                ", Manufacturer=" + Manufacturer +
                ", Consignee=" + Consignee +
                ", Admin=" + Admin +
                ", Materials=" + Materials +
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
