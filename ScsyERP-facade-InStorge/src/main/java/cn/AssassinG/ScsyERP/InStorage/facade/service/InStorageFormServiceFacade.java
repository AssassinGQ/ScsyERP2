package cn.AssassinG.ScsyERP.InStorage.facade.service;

import cn.AssassinG.ScsyERP.InStorage.facade.entity.InStorageForm;
import cn.AssassinG.ScsyERP.common.core.service.FormService;

public interface InStorageFormServiceFacade extends FormService<InStorageForm> {
    void addDriveWorkers(Long entityId, String jsonArrayStr);
    void removeDriveWorker(Long entityId, Long driveWorkerId);
    void addLiftWorkers(Long entityId, String jsonArrayStr);
    void removeLiftWorker(Long entityId, Long liftWorkerId);
    void addProduct(Long entityId, Long productId);
    void removeProduct(Long entityId, Long productId);
    void updateProductLocation(Long entityId, String Location);
}
