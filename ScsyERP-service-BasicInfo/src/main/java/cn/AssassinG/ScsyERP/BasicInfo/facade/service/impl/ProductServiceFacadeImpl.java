package cn.AssassinG.ScsyERP.BasicInfo.facade.service.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProductBiz;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Product;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.ProductServiceFacade;
import cn.AssassinG.ScsyERP.common.core.biz.UnLoginableBiz;
import cn.AssassinG.ScsyERP.common.core.service.impl.UnLoginableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceFacadeImpl extends UnLoginableServiceImpl<Product> implements ProductServiceFacade {
    @Autowired
    private ProductBiz productBiz;


    @Override
    protected UnLoginableBiz<Product> getUnLoginableBiz() {
        return this.productBiz;
    }

}
