package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.TruckBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.TruckDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Truck;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.TruckBizException;
import cn.AssassinG.ScsyERP.common.core.biz.impl.UnLoginableBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("TruckBiz")
public class TruckBizImpl extends UnLoginableBizImpl<Truck> implements TruckBiz {
    @Autowired
    private TruckDao truckDao;
    protected BaseDao<Truck> getDao() {
        return this.truckDao;
    }

    public Long createWithNameCheck(Truck truck){
        if(truck.getName() == null || truck.getName().isEmpty()){
            truck.setName("-1");
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("CarNumber", truck.getCarNumber());
        queryMap.put("IfDeleted", false);
        List<Truck> trucks = this.listBy(queryMap);
        if(trucks.size() > 1){
            throw new TruckBizException(TruckBizException.TRUCKBIZ_PARAMS_ILLEGAL, "数据库存在多辆车牌号为%s的车辆", truck.getCarNumber());
        }else if(trucks.size() == 1){
            throw new TruckBizException(TruckBizException.TRUCKBIZ_PARAMS_ILLEGAL, "车牌号%s被占用", truck.getCarNumber());
        }else{
            Long id = this.create(truck);
            if(truck.getName().equals("-1")){
                truck.setName(truck.getClass().getSimpleName()+id);
                this.update(truck);
            }
            return id;
        }
    }

    /**
     * @param entityId
     * @param paramMap 车辆基本信息字段(name,phone,carNumber,carLicense,carId,affiliation,driver)
     */
    @Transactional
    public void updateByMap(Long entityId, Map<String, String> paramMap) {
        if(entityId == null){
            throw new TruckBizException(TruckBizException.TRUCKBIZ_PARAMS_ILLEGAL, "车辆基本信息主键不能为空");
        }
        Truck truck = this.getById(entityId);
        if(truck == null || truck.getIfDeleted()){
            throw new TruckBizException(TruckBizException.TRUCKBIZ_NOSUIT_RESULT, "没有符合条件的车辆基本信息，entityId: %d", entityId);
        }
        try{
            String name = paramMap.get("name");
            String phone = paramMap.get("phone");
            String carNumber = paramMap.get("carNumber");
            String carLicense = paramMap.get("carLicense");
            String carId = paramMap.get("carId");
            String affiliation = paramMap.get("affiliation");
            String driverStr = paramMap.get("driver");
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
            if(driverStr != null && !driverStr.isEmpty()) {
                truck.setDriver(Long.parseLong(driverStr));
                flag = true;
            }
            if (flag) {
                this.update(truck);
            }
        }catch (NumberFormatException e){
            throw new TruckBizException(TruckBizException.TRUCKBIZ_PARAMS_ILLEGAL, "参数格式错误："+e.getMessage());
        }
    }
}
