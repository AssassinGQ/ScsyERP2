package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.TruckBiz;
import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Truck;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.TruckServiceFacade;
import cn.AssassinG.ScsyERP.common.core.service.impl.UnLoginableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TruckServiceFacade")
public class TruckServiceFacadeImpl extends UnLoginableServiceImpl<Truck> implements TruckServiceFacade {
    @Autowired
    private TruckBiz truckBiz;
    @Override
    protected UnLoginableBiz<Truck> getUnLoginableBiz() {
        return this.truckBiz;
    }
}
