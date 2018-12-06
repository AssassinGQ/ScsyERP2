package cn.AssassinG.ScsyERP.OnWayWatch.facade.service;

import cn.AssassinG.ScsyERP.OnWayWatch.facade.entity.TruckLog;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.entity.Warn;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;

public interface TruckLogServiceFacade extends BaseService<TruckLog> {
    Long createWithWarn(TruckLog truckLog, Warn warn);
}
