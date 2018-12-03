package cn.AssassinG.ScsyERP.User.facade.service;

import cn.AssassinG.ScsyERP.User.facade.entity.Government;
import cn.AssassinG.ScsyERP.User.facade.entity.User;

import java.util.Map;

public interface GovernmentServiceFacade extends LoginableService<Government> {
    Long create(String token, User user, Map<String, Object> paramMap);
}
