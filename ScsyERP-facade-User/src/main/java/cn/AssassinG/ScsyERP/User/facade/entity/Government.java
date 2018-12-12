package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.User.facade.enums.GovernmentDeptType;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;
import com.alibaba.fastjson.annotation.JSONField;

public class Government extends LoginableEntity {
    @Valid(varType = Valid.VarType.Other)
    private GovernmentDeptType Dept;

    public Government() {
        super();
        Dept = GovernmentDeptType.JJB;
    }

    public Government(GovernmentDeptType dept) {
        super();
        Dept = dept;
    }

    @JSONField(serialize = false)
    public GovernmentDeptType getDept() {
        return Dept;
    }

    @JSONField(deserialize = false)
    public void setDept(GovernmentDeptType dept) {
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
        this.Dept = GovernmentDeptType.getEnum(name);
    }

    @Override
    public String toString() {
        return "Government{" +
                "Dept=" + Dept +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
