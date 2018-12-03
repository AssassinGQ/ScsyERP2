package cn.AssassinG.ScsyERP.BasicInfo.core.biz;

import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

public interface UnLoginableBiz<T extends UnLoginableEntity> extends BaseBiz<T> {
    Long createWithNameCheck(T entity);
}
