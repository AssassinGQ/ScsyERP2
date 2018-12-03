package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.WarehouseBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WarehouseDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.WarehouseBizException;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("WarehouseBiz")
public class WarehouseBizImpl extends UnLoginableBizImpl<Warehouse> implements WarehouseBiz {
    @Autowired
    private WarehouseDao warehouseDao;
    protected BaseDao<Warehouse> getDao() {
        return this.warehouseDao;
    }

    /**
     * @param entityId
     * @param paramMap 仓库基本信息字段(name,phone,address,admin)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "仓库基本信息主键不能为空");
        }
        Warehouse warehouse = this.getById(entityId);
        if(warehouse == null || warehouse.getIfDeleted()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_NOSUIT_RESULT, "没有符合条件的仓库基本信息，entityId: %d", entityId);
        }
        String name = (String) paramMap.get("name");
        String phone = (String) paramMap.get("phone");
        String address = (String) paramMap.get("address");
        Long admin = (Long) paramMap.get("admin");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            warehouse.setName(name);
            flag = true;
        }
        if(phone != null && !phone.isEmpty()) {
            warehouse.setPhone(phone);
            flag = true;
        }
        if(address != null && !address.isEmpty()) {
            warehouse.setAddress(address);
            flag = true;
        }
        if(admin != null) {
            warehouse.setAdmin(admin);
            flag = true;
        }
        if (flag) {
            this.update(warehouse);
        }
    }
}
