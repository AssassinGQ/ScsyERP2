package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.biz.WorkshopBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Workshop;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.WorkshopServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopServiceFacadeImpl extends UnLoginableServiceImpl<Workshop> implements WorkshopServiceFacade {
    @Autowired
    private WorkshopBiz workshopBiz;
    @Override
    protected UnLoginableBiz<Workshop> getUnLoginableBiz() {
        return this.workshopBiz;
    }
}
