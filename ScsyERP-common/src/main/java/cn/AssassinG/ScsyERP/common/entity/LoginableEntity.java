package cn.AssassinG.ScsyERP.common.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;

public abstract class LoginableEntity extends BaseEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    protected String Name;

    public LoginableEntity() {
        super();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
