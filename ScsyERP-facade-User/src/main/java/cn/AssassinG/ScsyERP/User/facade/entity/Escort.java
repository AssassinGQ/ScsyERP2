package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

public class Escort extends LoginableEntity {
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
