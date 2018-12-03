package cn.AssassinG.ScsyERP.Fee.facade.service.impl;

import cn.AssassinG.ScsyERP.Fee.core.biz.TransportContractBiz;
import cn.AssassinG.ScsyERP.Fee.facade.entity.TransportContract;
import cn.AssassinG.ScsyERP.Fee.facade.service.TransportContractServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransportContractServiceFacadeImpl extends BaseServiceImpl<TransportContract> implements TransportContractServiceFacade {
    @Autowired
    private TransportContractBiz transportContractBiz;
    protected BaseBiz<TransportContract> getBiz() {
        return this.transportContractBiz;
    }

    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        this.transportContractBiz.updateByMap(entityId, paramMap);
    }
}
