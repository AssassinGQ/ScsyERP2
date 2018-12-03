package cn.AssassinG.ScsyERP.OnWayWatch.facade.service.impl;

import cn.AssassinG.ScsyERP.OnWayWatch.core.biz.WarnBiz;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.entity.Warn;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.service.WarnServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WarnServiceFacadeImpl extends BaseServiceImpl<Warn> implements WarnServiceFacade {
    @Autowired
    private WarnBiz warnBiz;
    protected BaseBiz<Warn> getBiz() {
        return this.warnBiz;
    }

    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        this.warnBiz.updateByMap(entityId, paramMap);
    }
}
