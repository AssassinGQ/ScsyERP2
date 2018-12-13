package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

import javax.persistence.Entity;

@Entity
public class Escort extends LoginableEntity {
    private static final long serialVersionUID = 4703065980555263253L;

    public Escort() {
        super();
    }

    @Override
    public String toString() {
        return "Escort{" +
                "Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
