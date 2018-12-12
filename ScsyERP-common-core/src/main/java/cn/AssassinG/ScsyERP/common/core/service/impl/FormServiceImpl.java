package cn.AssassinG.ScsyERP.common.core.service.impl;

import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.biz.FormBiz;
import cn.AssassinG.ScsyERP.common.core.service.FormService;
import cn.AssassinG.ScsyERP.common.entity.FormEntity;

import java.util.Map;

public abstract class FormServiceImpl<T extends FormEntity> extends BaseServiceImpl<T> implements FormService<T> {

    protected abstract FormBiz<T> getFormBiz();

    protected BaseBiz<T> getBiz(){
        return this.getFormBiz();
    }

    public void updateByMap(Long entityId, Map<String, String> paramMap){
        getFormBiz().updateByMap(entityId, paramMap);
    }

    @Override
    public void complete(Long entityId) {
        getFormBiz().complete(entityId);
    }
}
