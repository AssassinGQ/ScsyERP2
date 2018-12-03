package cn.AssassinG.ScsyERP.BasicInfo.core.dao.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.MaterialDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Material;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="MaterialDao")
public class MaterialDaoImpl extends BaseDaoImpl<Material> implements MaterialDao {
}
