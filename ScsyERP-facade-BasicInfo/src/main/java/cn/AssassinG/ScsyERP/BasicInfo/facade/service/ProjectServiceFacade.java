package cn.AssassinG.ScsyERP.BasicInfo.facade.service;


import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.common.core.service.UnLoginableService;

public interface ProjectServiceFacade extends UnLoginableService<Project> {
    void addMaterials(Long entityId, String jsonArrayStr);
    void removeMaterial(Long entityId, Long productId);
}
