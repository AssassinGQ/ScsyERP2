package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.TruckBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Truck;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.TruckServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckServiceFacadeImpl extends UnLoginableServiceImpl<Truck> implements TruckServiceFacade {
    @Autowired
    private TruckBiz truckBiz;
    @Override
    protected UnLoginableBiz<Truck> getUnLoginableBiz() {
        return this.truckBiz;
    }
}
