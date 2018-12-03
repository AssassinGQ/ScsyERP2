package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

public class LiftWorker extends UnLoginableEntity {
    public LiftWorker() {
        super();
    }

    @Override
    public String toString() {
        return "LiftWorker{" +
                "Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
