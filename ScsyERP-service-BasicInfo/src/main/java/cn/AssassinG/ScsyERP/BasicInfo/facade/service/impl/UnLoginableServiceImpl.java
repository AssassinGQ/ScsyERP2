package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.UnLoginableService;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

import java.util.Map;

public abstract class UnLoginableServiceImpl<T extends UnLoginableEntity> extends BaseServiceImpl<T> implements UnLoginableService<T> {

    protected abstract UnLoginableBiz<T> getUnLoginableBiz();

    protected BaseBiz<T> getBiz(){
        return this.getUnLoginableBiz();
    }

    /**
     * 屏蔽create方法
     * @param entity
     * @return
     */
    public Long create(T entity){
        return -1L;
    }

    public Long createWithNameCheck(T entity){
        return getUnLoginableBiz().createWithNameCheck(entity);
    }
    public void updateByMap(Long entityId, Map<String, Object> paramMap){
        getUnLoginableBiz().updateByMap(entityId, paramMap);
    }
}
