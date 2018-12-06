package cn.AssassinG.ScsyERP.Fee.facade.service;

import cn.AssassinG.ScsyERP.Fee.facade.entity.OnTruckForm;
import cn.AssassinG.ScsyERP.common.core.service.FormService;

public interface OnTruckFormServiceFacade extends FormService<OnTruckForm> {
    void addPicture(Long entityId, Long pictureId);
    void removePicture(Long entityId, Long pictureId);
}
