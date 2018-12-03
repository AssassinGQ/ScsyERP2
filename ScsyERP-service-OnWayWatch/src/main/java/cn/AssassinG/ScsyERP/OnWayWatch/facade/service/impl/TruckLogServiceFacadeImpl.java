package cn.AssassinG.ScsyERP.OnWayWatch.facade.service.impl;

import cn.AssassinG.ScsyERP.OnWayWatch.core.biz.TruckLogBiz;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.entity.TruckLog;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.service.TruckLogServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TruckLogServiceFacadeImpl extends BaseServiceImpl<TruckLog> implements TruckLogServiceFacade {
    @Autowired
    private TruckLogBiz truckLogBiz;
    protected BaseBiz<TruckLog> getBiz() {
        return this.truckLogBiz;
    }

    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        this.truckLogBiz.updateByMap(entityId, paramMap);
    }
}
