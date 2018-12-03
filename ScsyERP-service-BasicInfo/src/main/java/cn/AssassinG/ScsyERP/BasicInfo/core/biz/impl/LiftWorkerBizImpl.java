package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.LiftWorkerBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.LiftWorkerDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.LiftWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.DriveWorkerBizException;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("LiftWorkerBiz")
public class LiftWorkerBizImpl extends UnLoginableBizImpl<LiftWorker> implements LiftWorkerBiz {
    @Autowired
    private LiftWorkerDao liftWorkerDao;
    protected BaseDao<LiftWorker> getDao() {
        return this.liftWorkerDao;
    }

    /**
     * @param entityId
     * @param paramMap 起重工基本信息字段(name,phone)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new DriveWorkerBizException(DriveWorkerBizException.DRIVEWORKERBIZ_PARAMS_ILLEGAL, "起重工基本信息主键不能为空");
        }
        LiftWorker liftWorker = this.getById(entityId);
        if(liftWorker == null || liftWorker.getIfDeleted()){
            throw new DriveWorkerBizException(DriveWorkerBizException.DRIVEWORKERBIZ_NOSUIT_RESULT, "没有符合条件的起重工基本信息，entityId: %d", entityId);
        }
        String name = (String) paramMap.get("name");
        String phone = (String) paramMap.get("phone");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            liftWorker.setName(name);
            flag = true;
        }
        if(phone != null && !phone.isEmpty()) {
            liftWorker.setPhone(phone);
            flag = true;
        }
        if (flag) {
            this.update(liftWorker);
        }
    }
}
