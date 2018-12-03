package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

public class DriveWorker extends UnLoginableEntity {

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
