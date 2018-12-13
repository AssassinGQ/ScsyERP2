package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

import javax.persistence.Entity;

@Entity
public class LiftWorker extends UnLoginableEntity {
    private static final long serialVersionUID = 2012928188927455406L;

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
