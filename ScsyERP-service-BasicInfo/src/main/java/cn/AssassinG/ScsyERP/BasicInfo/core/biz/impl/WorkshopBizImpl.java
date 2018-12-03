package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.WorkshopBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WorkshopDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Workshop;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.WorkshopBizException;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("WorkshopBizImpl")
public class WorkshopBizImpl extends UnLoginableBizImpl<Workshop> implements WorkshopBiz {
    @Autowired
    private WorkshopDao workshopDao;
    protected BaseDao<Workshop> getDao() {
        return this.workshopDao;
    }

    /**
     * @param entityId
     * @param paramMap 生产厂家基本信息字段(name,phone,address,manufacturer,manName)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new WorkshopBizException(WorkshopBizException.WORKSHOPBIZ_PARAMS_ILLEGAL, "生产厂家基本信息主键不能为空");
        }
        Workshop workshop = this.getById(entityId);
        if(workshop == null || workshop.getIfDeleted()){
            throw new WorkshopBizException(WorkshopBizException.WORKSHOPBIZ_NOSUIT_RESULT, "没有符合条件的生产厂家基本信息，entityId: %d", entityId);
        }
        String name = (String) paramMap.get("name");
        String phone = (String) paramMap.get("phone");
        String address = (String) paramMap.get("address");
        Long manufacturer = (Long) paramMap.get("manufacturer");
        String manName = (String) paramMap.get("manName");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            workshop.setName(name);
            flag = true;
        }
        if(phone != null && !phone.isEmpty()) {
            workshop.setPhone(phone);
            flag = true;
        }
        if(address != null && !address.isEmpty()) {
            workshop.setAddress(address);
            flag = true;
        }
        if(manufacturer != null) {
            workshop.setManufacturer(manufacturer);
            flag = true;
        }
        if(manName != null && !manName.isEmpty()) {
            workshop.setManName(manName);
            flag = true;
        }
        if (flag) {
            this.update(workshop);
        }
    }
}
