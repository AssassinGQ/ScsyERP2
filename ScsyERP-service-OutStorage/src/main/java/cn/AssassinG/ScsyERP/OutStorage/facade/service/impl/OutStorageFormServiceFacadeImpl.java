package cn.AssassinG.ScsyERP.OutStorage.facade.service.impl;

import cn.AssassinG.ScsyERP.OutStorage.core.biz.OutStorageFormBiz;
import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.OutStorage.facade.service.OutStorageFormServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.FormBiz;
import cn.AssassinG.ScsyERP.common.core.service.impl.FormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OutStorageFormServiceFacade")
public class OutStorageFormServiceFacadeImpl extends FormServiceImpl<OutStorageForm> implements OutStorageFormServiceFacade {
    @Autowired
    private OutStorageFormBiz outStorageFormBiz;

    @Override
    protected FormBiz<OutStorageForm> getFormBiz() {
        return this.outStorageFormBiz;
    }

    @Override
    public void addDriveWorkers(Long entityId, String jsonArrayStr) {
        this.outStorageFormBiz.addDriveWorkers(entityId, jsonArrayStr);
    }

    @Override
    public void removeDriveWorker(Long entityId, Long driveWorkerId) {
        this.outStorageFormBiz.removeDriveWorker(entityId, driveWorkerId);
    }

    @Override
    public void addLiftWorkers(Long entityId, String jsonArrayStr) {
        this.outStorageFormBiz.addLiftWorkers(entityId, jsonArrayStr);
    }

    @Override
    public void removeLiftWorker(Long entityId, Long liftWorkerId) {
        this.outStorageFormBiz.removeLiftWorker(entityId, liftWorkerId);
    }

    @Override
    public void addProduct(Long entityId, Long productId) {
        this.outStorageFormBiz.addProduct(entityId, productId);
    }

    @Override
    public void removeProduct(Long entityId, Long productId) {
        this.outStorageFormBiz.removeProduct(entityId, productId);
    }
}
