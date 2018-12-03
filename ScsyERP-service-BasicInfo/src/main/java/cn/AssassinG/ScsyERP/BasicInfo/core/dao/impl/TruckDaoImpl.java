package cn.AssassinG.ScsyERP.BasicInfo.core.dao.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.TruckDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Truck;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="TruckDao")
public class TruckDaoImpl extends BaseDaoImpl<Truck> implements TruckDao {
}
