package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.WarehouseBiz;
import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.WarehouseServiceFacade;
import cn.AssassinG.ScsyERP.common.core.service.impl.UnLoginableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceFacadeImpl extends UnLoginableServiceImpl<Warehouse> implements WarehouseServiceFacade {
    @Autowired
    private WarehouseBiz warehouseBiz;
    @Override
    protected UnLoginableBiz<Warehouse> getUnLoginableBiz() {
        return this.warehouseBiz;
    }

    @Override
    public void addDriveWorkers(Long entityId, String jsonArrayStr) {
        this.warehouseBiz.addDriveWorkers(entityId, jsonArrayStr);
    }

    @Override
    public void removeDriveWorker(Long entityId, Long driveWorkerId) {
        this.warehouseBiz.removeDriveWorker(entityId, driveWorkerId);
    }

    @Override
    public void addLiftWorkers(Long entityId, String jsonArrayStr) {
        this.warehouseBiz.addLiftWorkers(entityId, jsonArrayStr);
    }

    @Override
    public void removeLiftWorker(Long entityId, Long liftWorkerId) {
        this.warehouseBiz.removeLiftWorker(entityId, liftWorkerId);
    }
}
