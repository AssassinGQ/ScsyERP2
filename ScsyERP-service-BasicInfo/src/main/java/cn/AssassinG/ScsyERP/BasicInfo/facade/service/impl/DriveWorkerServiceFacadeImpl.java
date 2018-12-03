package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.DriveWorkerBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.DriveWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.DriveWorkerServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriveWorkerServiceFacadeImpl extends UnLoginableServiceImpl<DriveWorker> implements DriveWorkerServiceFacade {
    @Autowired
    private DriveWorkerBiz driveWorkerBiz;
    @Override
    protected UnLoginableBiz<DriveWorker> getUnLoginableBiz() {
        return this.driveWorkerBiz;
    }
}
