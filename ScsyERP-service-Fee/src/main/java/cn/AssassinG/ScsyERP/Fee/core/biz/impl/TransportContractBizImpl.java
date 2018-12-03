package cn.AssassinG.ScsyERP.Fee.core.biz.impl;

import cn.AssassinG.ScsyERP.Fee.core.biz.TransportContractBiz;
import cn.AssassinG.ScsyERP.Fee.core.dao.TransportContractDao;
import cn.AssassinG.ScsyERP.Fee.facade.entity.TransportContract;
import cn.AssassinG.ScsyERP.Fee.facade.enums.OilCardType;
import cn.AssassinG.ScsyERP.Fee.facade.exceptions.TransportContractBizException;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("TransportContractBiz")
public class TransportContractBizImpl extends BaseBizImpl<TransportContract> implements TransportContractBiz {
    @Autowired
    private TransportContractDao transportContractDao;
    protected BaseDao<TransportContract> getDao() {
        return this.transportContractDao;
    }

    /**
     * @param entityId
     * @param paramMap 运输合同字段(supplier,productInsurance,realWeight,prePay,oilCardType,oilCardNumber,oilCardMoney,preRepairFee)
     */
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new TransportContractBizException(TransportContractBizException.TRANSPORTCONTRACTBIZ_PARAMS_ILLEGAL, "入库单基本信息主键不能为空");
        }
        TransportContract inStorageForm = this.getById(entityId);
        if(inStorageForm == null || inStorageForm.getIfDeleted()){
            throw new TransportContractBizException(TransportContractBizException.TRANSPORTCONTRACTBIZ_NOSUIT_RESULT, "没有符合条件的入库单基本信息，entityId: %d", entityId);
        }
        String supplier = (String) paramMap.get("supplier");
        Double productInsurance = (Double) paramMap.get("productInsurance");
        Double realWeight = (Double) paramMap.get("realWeight");
        Double prePay = (Double) paramMap.get("prePay");
        OilCardType oilCardType = (OilCardType) paramMap.get("oilCardType");
        String oilCardNumber = (String) paramMap.get("oilCardNumber");
        Double oilCardMoney = (Double) paramMap.get("oilCardMoney");
        Double preRepairFee = (Double) paramMap.get("preRepairFee");
        boolean flag = false;
        if(supplier != null && !supplier.isEmpty()) {
            inStorageForm.setSupplier(supplier);
            flag = true;
        }
        if(productInsurance != null) {
            inStorageForm.setProductInsurance(productInsurance);
            flag = true;
        }
        if(realWeight != null) {
            inStorageForm.setRealWeight(realWeight);
            flag = true;
        }
        if(prePay != null) {
            inStorageForm.setPrePay(prePay);
            flag = true;
        }
        if(oilCardType != null) {
            inStorageForm.setOilCardType(oilCardType);
            flag = true;
        }
        if(oilCardNumber != null && !oilCardNumber.isEmpty()) {
            inStorageForm.setOilCardNumber(oilCardNumber);
            flag = true;
        }
        if(oilCardMoney != null) {
            inStorageForm.setOilCardMoney(oilCardMoney);
            flag = true;
        }
        if(preRepairFee != null) {
            inStorageForm.setPreRepairFee(preRepairFee);
            flag = true;
        }
        if (flag) {
            this.update(inStorageForm);
        }
    }
}
