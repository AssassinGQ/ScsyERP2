package cn.AssassinG.ScsyERP.Fee.facade.service.impl;

import cn.AssassinG.ScsyERP.Fee.core.biz.OnTruckFormBiz;
import cn.AssassinG.ScsyERP.Fee.facade.entity.OnTruckForm;
import cn.AssassinG.ScsyERP.Fee.facade.service.OnTruckFormServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OnTruckFormServiceFacadeImpl extends BaseServiceImpl<OnTruckForm> implements OnTruckFormServiceFacade {
    @Autowired
    private OnTruckFormBiz onTruckFormBiz;
    protected BaseBiz<OnTruckForm> getBiz() {
        return this.onTruckFormBiz;
    }

    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        this.onTruckFormBiz.updateByMap(entityId, paramMap);
    }
}
