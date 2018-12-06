package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProjectBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.ProjectServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.common.core.service.impl.UnLoginableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceFacadeImpl extends UnLoginableServiceImpl<Project> implements ProjectServiceFacade {
    @Autowired
    private ProjectBiz projectBiz;

    @Override
    protected UnLoginableBiz<Project> getUnLoginableBiz() {
        return this.projectBiz;
    }

//    @Override
//    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
//        this.projectBiz.updateByMap(entityId, paramMap);
//    }

    @Override
    public void addMaterials(Long entityId, String jsonArrayStr) {
        this.projectBiz.addMaterials(entityId, jsonArrayStr);
    }

    @Override
    public void removeMaterial(Long entityId, Long productId) {
        this.projectBiz.removeMaterial(entityId, productId);
    }
}
