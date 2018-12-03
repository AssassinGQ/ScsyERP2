package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.MaterialBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.MaterialDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Material;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.MaterialBizException;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("MaterialBiz")
public class MaterialBizImpl extends BaseBizImpl<Material> implements MaterialBiz {
    @Autowired
    private MaterialDao materialDao;
    protected BaseDao<Material> getDao() {
        return this.materialDao;
    }

    /**
     * @param entityId
     * @param paramMap 物料基本信息字段(name,figureNumber)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new MaterialBizException(MaterialBizException.MATERIALBIZ_PARAMS_ILLEGAL, "物料基本信息主键不能为空");
        }
        Material project = this.getById(entityId);
        if(project == null || project.getIfDeleted()){
            throw new MaterialBizException(MaterialBizException.MATERIALBIZ_NOSUIT_RESULT, "没有符合条件的物料基本信息，entityId: %d", entityId);
        }
        String name = (String) paramMap.get("name");
        String figureNumber = (String) paramMap.get("figureNumber");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            project.setName(name);
            flag = true;
        }
        if(figureNumber != null && !figureNumber.isEmpty()) {
            project.setFigureNumber(figureNumber);
            flag = true;
        }
        if (flag) {
            this.update(project);
        }
    }
}
