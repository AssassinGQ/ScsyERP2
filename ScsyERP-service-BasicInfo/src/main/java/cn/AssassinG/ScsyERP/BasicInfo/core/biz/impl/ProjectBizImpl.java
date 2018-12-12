package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.MaterialBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProjectBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProjectDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Material;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.ProjectBizException;
import cn.AssassinG.ScsyERP.common.core.biz.impl.UnLoginableBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("ProjectBiz")
public class ProjectBizImpl extends UnLoginableBizImpl<Project> implements ProjectBiz {
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
    public void updateByMap(Long entityId, Map<String, String> paramMap) {
        if(entityId == null){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_PARAMS_ILLEGAL, "工程基本信息主键不能为空");
        }
        Project project = this.getById(entityId);
        if(project == null || project.getIfDeleted()){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_NOSUIT_RESULT, "没有符合条件的工程基本信息，entityId: %d", entityId);
        }
        String name = paramMap.get("name");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            project.setName(name);
            flag = true;
        }
        if (flag) {
            this.update(project);
        }
    }

    @Autowired
    private MaterialBiz materialBiz;

    @Transactional
    public void addMaterials(Long entityId, String jsonArrayStr) {
        if(entityId == null){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_PARAMS_ILLEGAL, "工程基本信息主键不能为空");
        }
        if(jsonArrayStr == null || jsonArrayStr.isEmpty()){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_PARAMS_ILLEGAL, "物料基本信息主键不能为空");
        }
        JSONArray jsonArray;
        try{
            jsonArray = JSONArray.parseArray(jsonArrayStr);
        }catch(Exception e){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_PARAMS_ILLEGAL, "物料基本信息主键格式不正确");
        }
        Project project = this.getById(entityId);
        if(project == null || project.getIfDeleted()){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_NOSUIT_RESULT, "没有符合条件的工程基本信息，entityId: %d", entityId);
        }
        boolean flag = true;
        for(int i = 0; i < jsonArray.size(); i++){
            Material driveWorker_tmp = materialBiz.getById(jsonArray.getLong(i));
            if(driveWorker_tmp == null || driveWorker_tmp.getIfDeleted()){
                flag = false;
            }else{
                project.getMaterials().add(driveWorker_tmp.getId());
            }
        }
        this.update(project);
        if(!flag){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_UNKNOWN_ERROR, "一部分物料主键没有对应的记录导致这部分主键没有添加", entityId);
        }
    }

    @Transactional
    public void removeMaterial(Long entityId, Long productId) {
        if(entityId == null){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_PARAMS_ILLEGAL, "工程基本信息主键不能为空");
        }
        if(productId == null){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_PARAMS_ILLEGAL, "物料基本信息主键不能为空");
        }
        Project project = this.getById(entityId);
        if(project == null || project.getIfDeleted()){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_NOSUIT_RESULT, "没有符合条件的工程基本信息，entityId: %d", entityId);
        }
        Material material = materialBiz.getById(productId);
        if(material == null || material.getIfDeleted()){
            throw new ProjectBizException(ProjectBizException.PROJECTBIZ_NOSUIT_RESULT, "没有符合条件的物料基本信息，entityId: %d", entityId);
        }
        project.getMaterials().remove(material.getId());
        this.update(project);
    }
}
