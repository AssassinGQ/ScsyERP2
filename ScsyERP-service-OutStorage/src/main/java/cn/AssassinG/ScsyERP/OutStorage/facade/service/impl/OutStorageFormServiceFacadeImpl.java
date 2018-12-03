package cn.AssassinG.ScsyERP.OutStorage.facade.service.impl;

import cn.AssassinG.ScsyERP.OutStorage.core.biz.OutStorageFormBiz;
import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.OutStorage.facade.service.OutStorageFormServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OutStorageFormServiceFacadeImpl extends BaseServiceImpl<OutStorageForm> implements OutStorageFormServiceFacade {
    @Autowired
    private OutStorageFormBiz outStorageFormBiz;
    protected BaseBiz<OutStorageForm> getBiz() {
        return this.outStorageFormBiz;
    }

    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        this.outStorageFormBiz.updateByMap(entityId, paramMap);
    }
}
