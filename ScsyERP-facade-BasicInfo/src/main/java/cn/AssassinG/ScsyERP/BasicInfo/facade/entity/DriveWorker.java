package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

import javax.persistence.Entity;

@Entity
public class DriveWorker extends UnLoginableEntity {
    private static final long serialVersionUID = 2175767730937590200L;
    public DriveWorker() {
        super();
    }

    @Override
    public String toString() {
        return "DriveWorker{" +
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
