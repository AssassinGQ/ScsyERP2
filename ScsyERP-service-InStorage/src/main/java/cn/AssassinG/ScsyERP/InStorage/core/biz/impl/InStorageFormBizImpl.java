package cn.AssassinG.ScsyERP.InStorage.core.biz.impl;

import cn.AssassinG.ScsyERP.InStorage.core.biz.InStorageFormBiz;
import cn.AssassinG.ScsyERP.InStorage.core.dao.InStorageFormDao;
import cn.AssassinG.ScsyERP.InStorage.facade.entity.InStorageForm;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;
import cn.AssassinG.ScsyERP.InStorage.facade.exceptions.InStorageFormBizException;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("InStorageFormBiz")
public class InStorageFormBizImpl extends BaseBizImpl<InStorageForm> implements InStorageFormBiz {
    @Autowired
    private InStorageFormDao inStorageFormDao;
    protected BaseDao<InStorageForm> getDao() {
        return this.inStorageFormDao;
    }

    /**
     * @param entityId
     * @param paramMap 入库单基本信息字段(warehouse,truck,pickWorker,lister,accountStatus,totalAmount,totalVolume,totalWeight)
     */
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new InStorageFormBizException(InStorageFormBizException.INSTORAGEFORMBIZ_PARAMS_ILLEGAL, "入库单基本信息主键不能为空");
        }
        InStorageForm inStorageForm = this.getById(entityId);
        if(inStorageForm == null || inStorageForm.getIfDeleted()){
            throw new InStorageFormBizException(InStorageFormBizException.INSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的入库单基本信息，entityId: %d", entityId);
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
            inStorageForm.setWarehouse(warehouse);
            flag = true;
        }
        if(truck != null) {
            inStorageForm.setWarehouse(truck);
            flag = true;
        }
        if(pickWorker != null) {
            inStorageForm.setWarehouse(pickWorker);
            flag = true;
        }
        if(lister != null) {
            inStorageForm.setWarehouse(lister);
            flag = true;
        }
        if(accountStatus != null) {
            inStorageForm.setAccountStatus(accountStatus);
            flag = true;
        }
        if(totalAmount != null) {
            inStorageForm.setTotalAmount(totalAmount);
            flag = true;
        }
        if(totalVolume != null) {
            inStorageForm.setTotalVolume(totalVolume);
            flag = true;
        }
        if(totalWeight != null) {
            inStorageForm.setTotalWeight(totalWeight);
            flag = true;
        }
        if (flag) {
            this.update(inStorageForm);
        }
    }
}
