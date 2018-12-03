package cn.AssassinG.ScsyERP.BasicInfo.core.dao.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WarehouseDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="WarehouseDao")
public class WarehouseDaoImpl extends BaseDaoImpl<Warehouse> implements WarehouseDao {
}
