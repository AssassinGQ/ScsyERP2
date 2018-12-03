package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProjectBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.ProjectServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProjectServiceFacadeImpl extends BaseServiceImpl<Project> implements ProjectServiceFacade {
    @Autowired
    private ProjectBiz projectBiz;

    @Override
    protected BaseBiz<Project> getBiz() {
        return this.projectBiz;
    }

    @Override
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        this.projectBiz.updateByMap(entityId, paramMap);
    }
}
