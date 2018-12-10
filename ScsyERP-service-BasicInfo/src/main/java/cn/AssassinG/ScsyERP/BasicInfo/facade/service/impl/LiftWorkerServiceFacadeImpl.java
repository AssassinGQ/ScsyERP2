package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.LiftWorkerBiz;
import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.LiftWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.LiftWorkerServiceFacade;
import cn.AssassinG.ScsyERP.common.core.service.impl.UnLoginableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LiftWorkerServiceFacade")
public class LiftWorkerServiceFacadeImpl extends UnLoginableServiceImpl<LiftWorker> implements LiftWorkerServiceFacade {
    @Autowired
    private LiftWorkerBiz liftWorkerBiz;
    @Override
    protected UnLoginableBiz<LiftWorker> getUnLoginableBiz() {
        return this.liftWorkerBiz;
    }
}
