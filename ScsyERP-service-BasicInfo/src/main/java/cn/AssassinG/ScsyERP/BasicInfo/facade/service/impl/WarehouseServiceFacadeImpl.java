package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.WarehouseBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.WarehouseServiceFacade;
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
}
