package cn.AssassinG.ScsyERP.Fee.core.biz.impl;

import cn.AssassinG.ScsyERP.Fee.core.biz.OnTruckFormBiz;
import cn.AssassinG.ScsyERP.Fee.core.dao.OnTruckFormDao;
import cn.AssassinG.ScsyERP.Fee.facade.entity.OnTruckForm;
import cn.AssassinG.ScsyERP.Fee.facade.exceptions.OnTruckFormBizException;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

@Component("OnTruckFormBiz")
public class OnTruckFormBizImpl extends BaseBizImpl<OnTruckForm> implements OnTruckFormBiz {
    @Autowired
    private OnTruckFormDao onTruckFormDao;
    protected BaseDao<OnTruckForm> getDao() {
        return this.onTruckFormDao;
    }

    /**
     * @param entityId
     * @param paramMap 随车清单字段(tallyMan,qualityTestMan,signMan,signTime,accountStatus)
     */
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new OnTruckFormBizException(OnTruckFormBizException.ONTRUCKFORMBIZ_PARAMS_ILLEGAL, "入库单基本信息主键不能为空");
        }
        OnTruckForm inStorageForm = this.getById(entityId);
        if(inStorageForm == null || inStorageForm.getIfDeleted()){
            throw new OnTruckFormBizException(OnTruckFormBizException.ONTRUCKFORMBIZ_NOSUIT_RESULT, "没有符合条件的入库单基本信息，entityId: %d", entityId);
        }
        Long tallyMan = (Long) paramMap.get("tallyMan");
        Long qualityTestMan = (Long) paramMap.get("qualityTestMan");
        String signMan = (String) paramMap.get("signMan");
        Date signTime = (Date) paramMap.get("signTime");
        AccountStatus accountStatus = (AccountStatus) paramMap.get("accountStatus");
        boolean flag = false;
        if(tallyMan != null) {
            inStorageForm.setTallyMan(tallyMan);
            flag = true;
        }
        if(qualityTestMan != null) {
            inStorageForm.setQualityTestMan(qualityTestMan);
            flag = true;
        }
        if(signMan != null && !signMan.isEmpty()) {
            inStorageForm.setSignMan(signMan);
            flag = true;
        }
        if(signTime != null) {
            inStorageForm.setSignTime(signTime);
            flag = true;
        }
        if(accountStatus != null) {
            inStorageForm.setAccountStatus(accountStatus);
            flag = true;
        }
        if (flag) {
            this.update(inStorageForm);
        }
    }
}
