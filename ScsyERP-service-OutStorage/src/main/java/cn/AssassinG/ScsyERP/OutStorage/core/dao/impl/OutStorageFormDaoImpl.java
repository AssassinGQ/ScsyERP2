package cn.AssassinG.ScsyERP.OutStorage.core.dao.impl;

import cn.AssassinG.ScsyERP.OutStorage.core.dao.OutStorageFormDao;
import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="OutStorageFormDao")
public class OutStorageFormDaoImpl extends BaseDaoImpl<OutStorageForm> implements OutStorageFormDao {
}
