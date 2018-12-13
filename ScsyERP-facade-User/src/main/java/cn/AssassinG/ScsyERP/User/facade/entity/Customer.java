package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

import javax.persistence.Entity;

@Entity
public class Customer extends LoginableEntity {
    private static final long serialVersionUID = 5983592654698540841L;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 100)
    private String Address;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 50)
    private String Bank;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 50)
    private String TaxNumber;

    public Customer() {
        super();
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getTaxNumber() {
        return TaxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        TaxNumber = taxNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Address='" + Address + '\'' +
                ", Bank='" + Bank + '\'' +
                ", TaxNumber='" + TaxNumber + '\'' +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
