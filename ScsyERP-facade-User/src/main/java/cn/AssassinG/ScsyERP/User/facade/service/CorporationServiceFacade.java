package cn.AssassinG.ScsyERP.User.facade.service;

import cn.AssassinG.ScsyERP.User.facade.entity.Corporation;
import cn.AssassinG.ScsyERP.User.facade.entity.User;

import java.util.Map;

public interface CorporationServiceFacade extends LoginableService<Corporation> {
    Long create(String token, User user, Map<String, Object> paramMap);
}