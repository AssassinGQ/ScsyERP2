package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProductBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Product;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.ProductServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;
import cn.AssassinG.ScsyERP.common.core.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductServiceFacadeImpl extends BaseServiceImpl<Product> implements ProductServiceFacade {
    @Autowired
    private ProductBiz productBiz;

    @Override
    protected BaseBiz<Product> getBiz() {
        return this.productBiz;
    }

    @Override
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        this.productBiz.updateByMap(entityId, paramMap);
    }
}
