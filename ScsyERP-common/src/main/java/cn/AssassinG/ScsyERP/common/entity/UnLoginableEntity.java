package cn.AssassinG.ScsyERP.common.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;

public abstract class UnLoginableEntity extends BaseEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    protected String Name;
    @Valid(varType = Valid.VarType.String, nullAble = true, minLength = 11, maxLength = 11)
    protected String Phone;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}

