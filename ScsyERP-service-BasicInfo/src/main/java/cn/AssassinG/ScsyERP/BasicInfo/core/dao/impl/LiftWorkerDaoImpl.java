package cn.AssassinG.ScsyERP.BasicInfo.core.dao.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.LiftWorkerDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.LiftWorker;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="LiftWorkerDao")
public class LiftWorkerDaoImpl extends BaseDaoImpl<LiftWorker> implements LiftWorkerDao {
}
