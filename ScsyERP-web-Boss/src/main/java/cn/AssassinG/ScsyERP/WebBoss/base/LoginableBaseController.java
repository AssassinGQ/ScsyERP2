package cn.AssassinG.ScsyERP.WebBoss.base;

import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.User.facade.service.LoginableService;
import cn.AssassinG.ScsyERP.WebBoss.enums.RetStatusType;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;
import cn.AssassinG.ScsyERP.common.entity.LoginableEntity;
import cn.AssassinG.ScsyERP.common.exceptions.BizException;
import cn.AssassinG.ScsyERP.common.exceptions.DaoException;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public abstract class LoginableBaseController<T extends LoginableEntity> extends BaseController<T> {

    protected abstract LoginableService<T> getLoginableService();//todo pom.xml中能够不引入service工程（在idea中，如果不引入，会报错：spring无法autowired。测试一下是不是是idea的问题，实际运行没有问题）

    @Override
    protected BaseService<T> getService() {
        return getLoginableService();
    }

    //todo 存在安全隐患，用户知道字段名后，可以在创建时制定一些受限制的字段的值
    protected JSONObject createImpl(T entity, User user){//todo 测试Converter能够对entity中的某个属性生效
        try{
            getLoginableService().createWithUser(entity, user);
            JSONObject contentObject = new JSONObject();
            return getResultJSON(RetStatusType.StatusSuccess, "创建"+getClassDesc()+"信息成功", contentObject);
        }catch(DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    protected JSONObject updateImpl(Long entityId, Map<String, Object> paramMap){
        try{
            getLoginableService().updateByMap(entityId, paramMap);
            return getResultJSON(RetStatusType.StatusSuccess, "修改"+getClassDesc()+"信息成功", null);
        }catch(DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    protected JSONObject deleteImpl(Long userId){
        try{
            getLoginableService().deleteByUserId(userId);
            return getResultJSON(RetStatusType.StatusSuccess, "删除"+getClassDesc()+"信息成功", null);
        }catch(DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
//
//    protected JSONObject queryImpl(Map<String, Object> paramMap){
//        try{
//            Integer limit = (Integer) paramMap.get("limit");
//            Integer page = (Integer)paramMap.get("page");
//            if(limit != null || page != null){
//                if(page == null)
//                    page = 1;
//                if(limit == null)
//                    limit = 20;
//                PageParam pageParam = new PageParam(page, limit);
//                paramMap.remove("limit");
//                paramMap.remove("page");
//                return getResultJSON("查询"+getClassDesc()+"信息成功", getLoginableService().listPage(pageParam, paramMap));
//            }else{
//                return getResultJSON("查询"+getClassDesc()+"信息成功", getLoginableService().listBy(paramMap));
//            }
//        }catch (DaoException | BizException e){
//            return getResultJSON(e.getMessage());
//        }
//    }

}
