package cn.AssassinG.ScsyERP.common.core.service;

import cn.AssassinG.ScsyERP.common.entity.FormEntity;

public interface FormService<T extends FormEntity> extends BaseService<T> {
    void complete(Long entityId);
}
