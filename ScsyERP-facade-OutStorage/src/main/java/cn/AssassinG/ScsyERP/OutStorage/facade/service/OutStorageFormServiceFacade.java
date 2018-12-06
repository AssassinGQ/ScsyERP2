package cn.AssassinG.ScsyERP.OutStorage.facade.service;

import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.common.core.service.FormService;

public interface OutStorageFormServiceFacade extends FormService<OutStorageForm> {
    void addDriveWorkers(Long entityId, String jsonArrayStr);
    void removeDriveWorker(Long entityId, Long driveWorkerId);
    void addLiftWorkers(Long entityId, String jsonArrayStr);
    void removeLiftWorker(Long entityId, Long liftWorkerId);
    void addProduct(Long entityId, Long productId);
    void removeProduct(Long entityId, Long productId);
}
