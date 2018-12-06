package cn.AssassinG.ScsyERP.BasicInfo.core.biz;

import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;

public interface WarehouseBiz extends UnLoginableBiz<Warehouse> {
    void addDriveWorkers(Long entityId, String jsonArrayStr);
    void removeDriveWorker(Long entityId, Long driveWorkerId);
    void addLiftWorkers(Long entityId, String jsonArrayStr);
    void removeLiftWorker(Long entityId, Long liftWorkerId);
}
