package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.User.facade.enums.AdminDeptType;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;

@Entity
public class Admin extends LoginableEntity {
    private static final long serialVersionUID = 7496553409033954061L;
    @Valid(varType = Valid.VarType.Other)
    private AdminDeptType Dept;

    public Admin() {
        super();
    }

    public Admin(AdminDeptType dept) {
        super();
        Dept = dept;
    }

    @JSONField(serialize = false)
    public AdminDeptType getDept() {
        return Dept;
    }

    @JSONField(deserialize = false)
    public void setDept(AdminDeptType dept) {
        Dept = dept;
    }

    @JSONField(name = "dept")
    public String getDeptName(){
        if(Dept != null)
            return this.Dept.getName();
        else
            return "";
    }

    @JSONField(name = "dept")
    public void setDeptName(String name){
        this.Dept = AdminDeptType.getEnum(name);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Dept=" + Dept +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
