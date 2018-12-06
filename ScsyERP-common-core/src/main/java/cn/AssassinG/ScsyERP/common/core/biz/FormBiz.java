package cn.AssassinG.ScsyERP.common.core.biz;

import cn.AssassinG.ScsyERP.common.entity.FormEntity;

public interface FormBiz<T extends FormEntity> extends BaseBiz<T> {
    void update(T formEntity);
    void complete(Long entityId);
}
