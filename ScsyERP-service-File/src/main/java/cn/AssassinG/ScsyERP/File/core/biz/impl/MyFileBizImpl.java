package cn.AssassinG.ScsyERP.File.core.biz.impl;

import cn.AssassinG.ScsyERP.File.core.biz.MyFileBiz;
import cn.AssassinG.ScsyERP.File.core.dao.MyFileDao;
import cn.AssassinG.ScsyERP.File.facade.entity.MyFile;
import cn.AssassinG.ScsyERP.common.core.biz.impl.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("MyFileBiz")
public class MyFileBizImpl extends BaseBizImpl<MyFile> implements MyFileBiz {
    @Autowired
    private MyFileDao myFileDao;
    protected BaseDao<MyFile> getDao() {
        return this.myFileDao;
    }

    //啥都不能修改
    public void updateByMap(Long entityId, Map<String, String> paramMap) {}
}
