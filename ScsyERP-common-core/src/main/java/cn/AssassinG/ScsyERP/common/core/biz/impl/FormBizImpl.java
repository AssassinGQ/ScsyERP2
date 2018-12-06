package cn.AssassinG.ScsyERP.common.core.biz.impl;

import cn.AssassinG.ScsyERP.common.core.biz.FormBiz;
import cn.AssassinG.ScsyERP.common.entity.FormEntity;
import cn.AssassinG.ScsyERP.common.exceptions.BizException;
import cn.AssassinG.ScsyERP.common.utils.ValidUtils;

public abstract class FormBizImpl<T extends FormEntity> extends BaseBizImpl<T> implements FormBiz<T> {

    @Override
    public void update(T formEntity) {
        ValidUtils.ValidationWithExp(formEntity);
        T formEntity_check = this.getById(formEntity.getId());
        if(formEntity_check == null || formEntity_check.getIfDeleted()){
            throw new BizException(00010000, "该表单已被删除，entityId: %d", formEntity.getId());
        }
        if(formEntity_check.getIfCompleted()){
            throw new BizException(00010001, "该表单已经完成，不能更新");
        }
        getDao().update(formEntity);
    }
}
