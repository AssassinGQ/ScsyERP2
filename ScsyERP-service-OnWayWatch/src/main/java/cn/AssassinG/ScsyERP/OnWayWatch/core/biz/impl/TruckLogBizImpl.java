package cn.AssassinG.ScsyERP.OnWayWatch.core.biz.impl;

import cn.AssassinG.ScsyERP.OnWayWatch.core.biz.TruckLogBiz;
import cn.AssassinG.ScsyERP.OnWayWatch.core.dao.TruckLogDao;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.entity.TruckLog;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("TruckLogBiz")
public class TruckLogBizImpl extends BaseBizImpl<TruckLog> implements TruckLogBiz {
    @Autowired
    private TruckLogDao truckLogDao;

    protected BaseDao<TruckLog> getDao() {
        return this.truckLogDao;
    }

    /**
     * @param entityId
     * @param paramMap 行车日志信息字段(啥都不能修改)
     */
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {

    }
}
