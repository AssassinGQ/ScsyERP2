package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.MaterialBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Material;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.MaterialServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.common.core.service.impl.UnLoginableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceFacadeImpl extends UnLoginableServiceImpl<Material> implements MaterialServiceFacade {
    @Autowired
    private MaterialBiz materialBiz;

    @Override
    protected UnLoginableBiz<Material> getUnLoginableBiz() {
        return this.materialBiz;
    }
//
//    @Override
//    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
//        this.materialBiz.updateByMap(entityId, paramMap);
//    }
}
