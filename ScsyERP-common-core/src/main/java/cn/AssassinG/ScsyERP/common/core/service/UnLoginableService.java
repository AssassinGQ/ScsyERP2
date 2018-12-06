package cn.AssassinG.ScsyERP.common.core.service;

import cn.AssassinG.ScsyERP.common.core.service.BaseService;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

public interface UnLoginableService<T extends UnLoginableEntity> extends BaseService<T> {
    Long createWithNameCheck(T entity);
}
