package cn.AssassinG.ScsyERP.BasicInfo.facade.service;


import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.common.core.service.UnLoginableService;

public interface WarehouseServiceFacade extends UnLoginableService<Warehouse> {
    void addDriveWorkers(Long entityId, String jsonArrayStr);
    void removeDriveWorker(Long entityId, Long driveWorkerId);
    void addLiftWorkers(Long entityId, String jsonArrayStr);
    void removeLiftWorker(Long entityId, Long liftWorkerId);
}
