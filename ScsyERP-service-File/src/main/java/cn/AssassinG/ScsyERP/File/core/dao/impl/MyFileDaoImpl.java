package cn.AssassinG.ScsyERP.File.core.dao.impl;

import cn.AssassinG.ScsyERP.File.core.dao.MyFileDao;
import cn.AssassinG.ScsyERP.File.facade.entity.MyFile;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="MyFileDao")
public class MyFileDaoImpl extends BaseDaoImpl<MyFile> implements MyFileDao {
    @Override
    public void update(MyFile entity) {}

    @Override
    public int update(List<MyFile> list) {return 0;}
}
