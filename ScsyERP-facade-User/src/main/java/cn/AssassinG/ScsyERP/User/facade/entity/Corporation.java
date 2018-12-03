package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

public class Corporation extends LoginableEntity {
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
