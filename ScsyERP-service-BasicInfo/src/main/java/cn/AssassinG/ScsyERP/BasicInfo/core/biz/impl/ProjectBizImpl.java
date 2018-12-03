package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProjectBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProjectDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.ProjectBizException;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("ProjectBiz")
public class ProjectBizImpl extends BaseBizImpl<Project> implements ProjectBiz {
    @Autowired
    private ProjectDao projectDao;
    protected BaseDao<Project> getDao() {
        return this.projectDao;
    }

    /**
     * @param entityId
     * @param paramMap 工程基本信息字段(name)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_PARAMS_ILLEGAL, "工程基本信息主键不能为空");
        }
        Project project = this.getById(entityId);
        if(project == null || project.getIfDeleted()){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_NOSUIT_RESULT, "没有符合条件的工程基本信息，entityId: %d", entityId);
        }
        String name = (String) paramMap.get("name");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            project.setName(name);
            flag = true;
        }
        if (flag) {
            this.update(project);
        }
    }
}
