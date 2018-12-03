package cn.AssassinG.ScsyERP.User.facade.service;

import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;

public interface LoginableService<T extends LoginableEntity> extends BaseService<T> {
    Long createWithUser(T entity, User user);
    void deleteByUserId(Long userId);
}
