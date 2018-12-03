package cn.AssassinG.ScsyERP.BasicInfo.core.dao.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WorkshopDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Workshop;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="WorkshopDao")
public class WorkshopDaoImpl extends BaseDaoImpl<Workshop> implements WorkshopDao {
}
