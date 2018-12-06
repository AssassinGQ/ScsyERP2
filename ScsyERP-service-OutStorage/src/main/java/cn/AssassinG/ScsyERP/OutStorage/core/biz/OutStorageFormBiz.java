package cn.AssassinG.ScsyERP.OutStorage.core.biz;

import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.common.core.biz.FormBiz;

public interface OutStorageFormBiz extends FormBiz<OutStorageForm> {
    void addDriveWorkers(Long entityId, String jsonArrayStr);
    void removeDriveWorker(Long entityId, Long driveWorkerId);
    void addLiftWorkers(Long entityId, String jsonArrayStr);
    void removeLiftWorker(Long entityId, Long liftWorkerId);
    void addProduct(Long entityId, Long productId);
    void removeProduct(Long entityId, Long productId);
}
