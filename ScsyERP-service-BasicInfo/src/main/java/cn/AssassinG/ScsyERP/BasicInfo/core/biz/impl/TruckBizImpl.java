package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.TruckBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.TruckDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Truck;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.TruckBizException;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("TruckBiz")
public class TruckBizImpl extends UnLoginableBizImpl<Truck> implements TruckBiz {
    @Autowired
    private TruckDao truckDao;
    protected BaseDao<Truck> getDao() {
        return this.truckDao;
    }

    /**
     * @param entityId
     * @param paramMap 车辆基本信息字段(name,phone,carNumber,carLicense,carId,affiliation,driver)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new TruckBizException(TruckBizException.TRUCKBIZ_PARAMS_ILLEGAL, "车辆基本信息主键不能为空");
        }
        Truck truck = this.getById(entityId);
        if(truck == null || truck.getIfDeleted()){
            throw new TruckBizException(TruckBizException.TRUCKBIZ_NOSUIT_RESULT, "没有符合条件的车辆基本信息，entityId: %d", entityId);
        }
        String name = (String) paramMap.get("name");
        String phone = (String) paramMap.get("phone");
        String carNumber = (String) paramMap.get("carNumber");
        String carLicense = (String) paramMap.get("carLicense");
        String carId = (String) paramMap.get("carId");
        String affiliation = (String) paramMap.get("affiliation");
        Long driver = (Long) paramMap.get("driver");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            truck.setName(name);
            flag = true;
        }
        if(phone != null && !phone.isEmpty()) {
            truck.setPhone(phone);
            flag = true;
        }
        if(carNumber != null && !carNumber.isEmpty()) {
            truck.setCarNumber(carNumber);
            flag = true;
        }
        if(carLicense != null && !carLicense.isEmpty()) {
            truck.setCarLicense(carLicense);
            flag = true;
        }
        if(carId != null && !carId.isEmpty()) {
            truck.setCarId(carId);
            flag = true;
        }
        if(affiliation != null && !affiliation.isEmpty()) {
            truck.setAffiliation(affiliation);
            flag = true;
        }
        if(driver != null) {
            truck.setDriver(driver);
            flag = true;
        }
        if (flag) {
            this.update(truck);
        }
    }
}
