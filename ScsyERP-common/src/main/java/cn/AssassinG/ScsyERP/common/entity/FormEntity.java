package cn.AssassinG.ScsyERP.common.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;

public abstract class FormEntity extends BaseEntity {
    @Valid(varType = Valid.VarType.Other)
    protected Boolean IfCompleted;

    public FormEntity() {
        super();
        this.IfCompleted = false;
    }

    public Boolean getIfCompleted() {
        return IfCompleted;
    }

    public void setIfCompleted(Boolean ifCompleted) {
        IfCompleted = ifCompleted;
    }
}
