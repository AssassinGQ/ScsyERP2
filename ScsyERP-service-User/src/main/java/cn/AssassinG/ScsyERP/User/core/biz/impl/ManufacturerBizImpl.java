package cn.AssassinG.ScsyERP.User.core.biz.impl;

import cn.AssassinG.ScsyERP.User.core.biz.ManufacturerBiz;
import cn.AssassinG.ScsyERP.User.core.dao.ManufacturerDao;
import cn.AssassinG.ScsyERP.User.facade.entity.Manufacturer;
import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.User.facade.enums.UserType;
import cn.AssassinG.ScsyERP.User.facade.exceptions.ManufacturerBizException;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("ManufacturerBiz")
public class ManufacturerBizImpl extends LoginableBizImpl<Manufacturer> implements ManufacturerBiz {

    @Autowired
    private ManufacturerDao manufacturerDao;

    @Override
    protected BaseDao<Manufacturer> getDao() {
        return this.manufacturerDao;
    }


    /**
     * @param entityId
     * @param paramMap 生产厂家基本信息字段(name,address,manName)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, Object> paramMap) {
        if(entityId == null){
            throw new ManufacturerBizException(ManufacturerBizException.MANUFACTURERBIZ_PARAMS_ILLEGAL, "生产厂家基本信息主键不能为空");
        }
        Manufacturer manufacturer = this.getById(entityId);
        if(manufacturer == null || manufacturer.getIfDeleted()){
            throw new ManufacturerBizException(ManufacturerBizException.MANUFACTURERBIZ_NOSUIT_RESULT, "没有符合条件的生产厂家基本信息，entityId: %d", entityId);
        }
        String name = (String) paramMap.get("name");
        String address = (String) paramMap.get("address");
        String manName = (String) paramMap.get("manName");
        boolean flag = false;
        if(name != null && !name.isEmpty()) {
            manufacturer.setName(name);
            flag = true;
        }
        if(address != null && !address.isEmpty()) {
            manufacturer.setAddress(address);
            flag = true;
        }
        if(manName != null && !manName.isEmpty()) {
            manufacturer.setManName(manName);
            flag = true;
        }
        if(flag) {
            this.update(manufacturer);
        }
    }

    @Override
    @Transactional
    public void deleteByUserId(Long userId) {
        if(userId == null){
            throw new ManufacturerBizException(ManufacturerBizException.MANUFACTURERBIZ_PARAMS_ILLEGAL, "用户登录信息主键不能为空");
        }
        User user = userBiz.getById(userId);
        if(user == null || user.getIfDeleted() || user.getUserType().getValue().intValue() != UserType.Manufacturer.getValue().intValue()){
            throw new ManufacturerBizException(ManufacturerBizException.MANUFACTURERBIZ_NOSUIT_RESULT, "没有符合条件的用户登录信息，userId: %d", userId);
        }
        Manufacturer manufacturer = this.getById(user.getUserInfo());
        if(manufacturer == null || manufacturer.getIfDeleted()){
            throw new ManufacturerBizException(ManufacturerBizException.MANUFACTURERBIZ_NOSUIT_RESULT, "没有对应的生产厂家基本信息，userId: %d", userId);
        }
        this.delete(manufacturer);
        userBiz.delete(user);
    }

}
