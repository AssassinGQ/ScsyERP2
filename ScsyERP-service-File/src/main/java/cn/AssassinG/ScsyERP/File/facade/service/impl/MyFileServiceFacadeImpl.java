package cn.AssassinG.ScsyERP.File.facade.service.impl;

import cn.AssassinG.ScsyERP.File.core.biz.MyFileBiz;
import cn.AssassinG.ScsyERP.File.facade.entity.MyFile;
import cn.AssassinG.ScsyERP.File.facade.service.MyFileServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("MyFileServiceFacade")
public class MyFileServiceFacadeImpl extends BaseServiceImpl<MyFile> implements MyFileServiceFacade {
    @Autowired
    private MyFileBiz myFileBiz;
    protected BaseBiz<MyFile> getBiz() {
        return this.myFileBiz;
    }

    public void updateByMap(Long entityId, Map<String, String> paramMap) {}
}
