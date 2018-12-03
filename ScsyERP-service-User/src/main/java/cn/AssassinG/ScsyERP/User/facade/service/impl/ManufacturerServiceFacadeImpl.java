package cn.AssassinG.ScsyERP.User.facade.service.impl;

import cn.AssassinG.ScsyERP.User.core.biz.ManufacturerBiz;
import cn.AssassinG.ScsyERP.User.core.biz.LoginableBiz;
import cn.AssassinG.ScsyERP.User.facade.entity.Manufacturer;
import cn.AssassinG.ScsyERP.User.facade.service.ManufacturerServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceFacadeImpl extends LoginableServiceImpl<Manufacturer> implements ManufacturerServiceFacade {
    @Autowired
    private ManufacturerBiz manufacturerBiz;
    @Override
    protected LoginableBiz<Manufacturer> getLoginableBiz() {
        return this.manufacturerBiz;
    }
}
