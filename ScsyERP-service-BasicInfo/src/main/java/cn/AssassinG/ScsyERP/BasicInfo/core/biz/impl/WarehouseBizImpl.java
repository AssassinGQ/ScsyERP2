package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.DriveWorkerBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.biz.LiftWorkerBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.biz.WarehouseBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WarehouseDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.DriveWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.LiftWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.WarehouseBizException;
import cn.AssassinG.ScsyERP.common.core.biz.impl.UnLoginableBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import com.alibaba.fastjson.JSONArray;
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

    @Autowired
    private DriveWorkerBiz driveWorkerBiz;

    @Transactional
    public void addDriveWorkers(Long entityId, String jsonArrayStr) {
        if(entityId == null){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "仓库基本信息主键不能为空");
        }
        if(jsonArrayStr == null || jsonArrayStr.isEmpty()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "行车工基本信息主键不能为空");
        }
        JSONArray jsonArray;
        try{
            jsonArray = JSONArray.parseArray(jsonArrayStr);
        }catch(Exception e){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "行车工基本信息主键格式不正确");
        }
        Warehouse warehouse = this.getById(entityId);
        if(warehouse == null || warehouse.getIfDeleted()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_NOSUIT_RESULT, "没有符合条件的仓库基本信息，entityId: %d", entityId);
        }
        boolean flag = true;
        for(int i = 0; i < jsonArray.size(); i++){
            DriveWorker driveWorker_tmp = driveWorkerBiz.getById(jsonArray.getLong(i));
            if(driveWorker_tmp == null || driveWorker_tmp.getIfDeleted()){
                flag = false;
            }else{
                warehouse.getDriveWorkers().add(driveWorker_tmp.getId());
            }
        }
        this.update(warehouse);
        if(!flag){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_UNKNOWN_ERROR, "一部分行车工主键没有对应的记录导致这部分主键没有添加到", entityId);
        }
    }

    @Transactional
    public void removeDriveWorker(Long entityId, Long driveWorkerId) {
        if(entityId == null){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "仓库基本信息主键不能为空");
        }
        if(driveWorkerId == null){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "行车工基本信息主键不能为空");
        }
        Warehouse warehouse = this.getById(entityId);
        if(warehouse == null || warehouse.getIfDeleted()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_NOSUIT_RESULT, "没有符合条件的仓库基本信息，entityId: %d", entityId);
        }
        DriveWorker driveWorker = driveWorkerBiz.getById(driveWorkerId);
        if(driveWorker == null || driveWorker.getIfDeleted()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_NOSUIT_RESULT, "没有符合条件的行车工基本信息，entityId: %d", entityId);
        }
        warehouse.getDriveWorkers().remove(driveWorker.getId());
        this.update(warehouse);
    }

    @Autowired
    private LiftWorkerBiz liftWorkerBiz;

    @Transactional
    public void addLiftWorkers(Long entityId, String jsonArrayStr) {
        if(entityId == null){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "仓库基本信息主键不能为空");
        }
        if(jsonArrayStr == null || jsonArrayStr.isEmpty()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "起重工基本信息主键不能为空");
        }
        JSONArray jsonArray;
        try{
            jsonArray = JSONArray.parseArray(jsonArrayStr);
        }catch(Exception e){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "起重工基本信息主键格式不正确");
        }
        Warehouse warehouse = this.getById(entityId);
        if(warehouse == null || warehouse.getIfDeleted()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_NOSUIT_RESULT, "没有符合条件的仓库基本信息，entityId: %d", entityId);
        }
        boolean flag = true;
        for(int i = 0; i < jsonArray.size(); i++){
            LiftWorker liftWorker_tmp = liftWorkerBiz.getById(jsonArray.getLong(i));
            if(liftWorker_tmp == null || liftWorker_tmp.getIfDeleted()){
                flag = false;
            }else{
                warehouse.getLiftWorkers().add(liftWorker_tmp.getId());
            }
        }
        this.update(warehouse);
        if(!flag){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_UNKNOWN_ERROR, "一部分起重工主键没有对应的记录导致这部分主键没有添加到", entityId);
        }
    }

    @Transactional
    public void removeLiftWorker(Long entityId, Long liftWorkerId) {
        if(entityId == null){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "仓库基本信息主键不能为空");
        }
        if(liftWorkerId == null){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_PARAMS_ILLEGAL, "起重工基本信息主键不能为空");
        }
        Warehouse warehouse = this.getById(entityId);
        if(warehouse == null || warehouse.getIfDeleted()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_NOSUIT_RESULT, "没有符合条件的仓库基本信息，entityId: %d", entityId);
        }
        LiftWorker liftWorker = liftWorkerBiz.getById(liftWorkerId);
        if(liftWorker == null || liftWorker.getIfDeleted()){
            throw new WarehouseBizException(WarehouseBizException.WAREHOUSEBIZ_NOSUIT_RESULT, "没有符合条件的起重工基本信息，entityId: %d", entityId);
        }
        warehouse.getLiftWorkers().remove(liftWorker.getId());
        this.update(warehouse);
    }
}
