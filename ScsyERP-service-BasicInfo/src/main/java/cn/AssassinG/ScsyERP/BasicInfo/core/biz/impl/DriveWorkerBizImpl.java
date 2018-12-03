package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.DriveWorkerBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.DriveWorkerDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.DriveWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.DriveWorkerBizException;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("DriveWorkerBiz")
public class DriveWorkerBizImpl extends UnLoginableBizImpl<DriveWorker> implements DriveWorkerBiz {
    @Autowired
    private DriveWorkerDao driveWorkerDao;
    protected BaseDao<DriveWorker> getDao() {
        return this.driveWorkerDao;
    }

    /**
     * @param entityId
     * @param paramMap 行车工基本信息字段(name,phone)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new DriveWorkerBizException(DriveWorkerBizException.DRIVEWORKERBIZ_PARAMS_ILLEGAL, "行车工基本信息主键不能为空");
        }
        DriveWorker driveWorker = this.getById(entityId);
        if(driveWorker == null || driveWorker.getIfDeleted()){
            throw new DriveWorkerBizException(DriveWorkerBizException.DRIVEWORKERBIZ_NOSUIT_RESULT, "没有符合条件的行车工基本信息，entityId: %d", entityId);
        }
        String name = (String) paramMap.get("name");
        String phone = (String) paramMap.get("phone");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            driveWorker.setName(name);
            flag = true;
        }
        if(phone != null && !phone.isEmpty()) {
            driveWorker.setPhone(phone);
            flag = true;
        }
        if (flag) {
            this.update(driveWorker);
        }
    }
}
