package cn.AssassinG.ScsyERP.BasicInfo.core.biz;

import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;

public interface ProjectBiz extends UnLoginableBiz<Project> {
    void addMaterials(Long entityId, String jsonArrayStr);
    void removeMaterial(Long entityId, Long productId);
}
