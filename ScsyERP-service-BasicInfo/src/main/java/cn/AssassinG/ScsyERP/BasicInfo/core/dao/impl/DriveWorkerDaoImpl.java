package cn.AssassinG.ScsyERP.BasicInfo.core.dao.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.DriveWorkerDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.DriveWorker;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="DriveWorkerDao")
public class DriveWorkerDaoImpl extends BaseDaoImpl<DriveWorker> implements DriveWorkerDao {
}
