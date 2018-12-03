package cn.AssassinG.ScsyERP.OutStorage.core.biz.impl;

import cn.AssassinG.ScsyERP.OutStorage.core.biz.OutStorageFormBiz;
import cn.AssassinG.ScsyERP.OutStorage.core.dao.OutStorageFormDao;
import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.OutStorage.facade.exceptions.OutStorageFormBizException;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("OutStorageFormBiz")
public class OutStorageFormBizImpl extends BaseBizImpl<OutStorageForm> implements OutStorageFormBiz {
    @Autowired
    private OutStorageFormDao outStorageFormDao;
    protected BaseDao<OutStorageForm> getDao() {
        return this.outStorageFormDao;
    }

    /**
     * @param entityId
     * @param paramMap 出库单基本信息字段(warehouse,truck,pickWorker,lister,accountStatus,totalAmount,totalVolume,totalWeight)
     */
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        Long warehouse = (Long) paramMap.get("warehouse");
        Long truck = (Long) paramMap.get("truck");
        Long pickWorker = (Long) paramMap.get("pickWorker");
        Long lister = (Long) paramMap.get("lister");
        AccountStatus accountStatus = (AccountStatus) paramMap.get("accountStatus");
        Integer totalAmount = (Integer) paramMap.get("totalAmount");
        Double totalVolume = (Double) paramMap.get("totalVolume");
        Double totalWeight = (Double) paramMap.get("totalWeight");
        boolean flag = false;
        if(warehouse != null) {
            outStorageForm.setWarehouse(warehouse);
            flag = true;
        }
        if(truck != null) {
            outStorageForm.setWarehouse(truck);
            flag = true;
        }
        if(pickWorker != null) {
            outStorageForm.setWarehouse(pickWorker);
            flag = true;
        }
        if(lister != null) {
            outStorageForm.setWarehouse(lister);
            flag = true;
        }
        if(accountStatus != null) {
            outStorageForm.setAccountStatus(accountStatus);
            flag = true;
        }
        if(totalAmount != null) {
            outStorageForm.setTotalAmount(totalAmount);
            flag = true;
        }
        if(totalVolume != null) {
            outStorageForm.setTotalVolume(totalVolume);
            flag = true;
        }
        if(totalWeight != null) {
            outStorageForm.setTotalWeight(totalWeight);
            flag = true;
        }
        if (flag) {
            this.update(outStorageForm);
        }
    }
}
