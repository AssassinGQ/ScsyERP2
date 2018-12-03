package cn.AssassinG.ScsyERP.BasicInfo.core.dao.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProductDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Product;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository(value="ProductDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {
}
