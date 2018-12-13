package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

import javax.persistence.Entity;

@Entity
public class Corporation extends LoginableEntity {
    private static final long serialVersionUID = 5559163118022293000L;

    public Corporation() {
        super();
        super.Corporation = -1L;
    }

    @Override
    public String toString() {
        return "Corporation{" +
                "Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
