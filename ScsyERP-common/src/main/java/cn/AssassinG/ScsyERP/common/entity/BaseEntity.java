package cn.AssassinG.ScsyERP.common.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7382559001417714129L;
    @Valid(varType = Valid.VarType.Number, nullAble = true)
    protected Long Id;
    @Valid(varType = Valid.VarType.Number, minValue = -1)
    protected Long Corporation;//承运方和政府所属的承运方统一为-1L
    @Valid(varType = Valid.VarType.Other)
    protected Date CreateTime;
    @Valid(varType = Valid.VarType.Other)
    protected Date UpdateTime;
    protected Date DeleteTime;
    @Valid(varType = Valid.VarType.Other)
    protected Boolean IfDeleted;

    public BaseEntity() {
        IfDeleted = false;
        Date date = new Date();
        CreateTime = date;
        UpdateTime = date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getCorporation() {
        return Corporation;
    }

    public void setCorporation(Long corporation) {
        Corporation = corporation;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        this.CreateTime = createTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.UpdateTime = updateTime;
    }

    public Date getDeleteTime() {
        return DeleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.DeleteTime = deleteTime;
    }

    public Boolean getIfDeleted() {
        return IfDeleted;
    }

    public void setIfDeleted(Boolean ifDeleted) {
        IfDeleted = ifDeleted;
    }
}
