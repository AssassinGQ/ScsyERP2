package cn.AssassinG.ScsyERP.BasicInfo.core.dao.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProjectDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="ProjectDao")
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {
}
