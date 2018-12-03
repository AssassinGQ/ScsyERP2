package cn.AssassinG.ScsyERP.InStorage.facade.service.impl;

import cn.AssassinG.ScsyERP.InStorage.core.biz.InStorageFormBiz;
import cn.AssassinG.ScsyERP.InStorage.facade.entity.InStorageForm;
import cn.AssassinG.ScsyERP.InStorage.facade.service.InStorageFormServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InStorageFormServiceFacadeImpl extends BaseServiceImpl<InStorageForm> implements InStorageFormServiceFacade {
    @Autowired
    private InStorageFormBiz inStorageFormBiz;
    protected BaseBiz<InStorageForm> getBiz() {
        return this.inStorageFormBiz;
    }

    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        this.inStorageFormBiz.updateByMap(entityId, paramMap);
    }
}
