package cn.AssassinG.ScsyERP.common.core.biz.impl;

import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

public abstract class UnLoginableBizImpl<T extends UnLoginableEntity> extends BaseBizImpl<T> implements UnLoginableBiz<T> {

    public Long createWithNameCheck(T entity){
        if(entity.getName() == null || entity.getName().isEmpty()){
            entity.setName("-1");
        }
        Long id = this.create(entity);
        if(entity.getName().equals("-1")){
            entity.setName(entity.getClass().getSimpleName()+id);
            this.update(entity);
        }
        return id;
    }

//    public void deleteById(Long entityId) {
//
//    }
}
