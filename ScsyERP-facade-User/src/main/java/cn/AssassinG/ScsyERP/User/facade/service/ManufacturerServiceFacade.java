package cn.AssassinG.ScsyERP.User.facade.service;

import cn.AssassinG.ScsyERP.User.facade.entity.Manufacturer;

public interface ManufacturerServiceFacade extends LoginableService<Manufacturer> {
    void addWorkshops(Long entityId, String jsonArrayStr);
    void removeWorkshop(Long entityId, Long workshopId);
}
