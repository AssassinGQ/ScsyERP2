package cn.AssassinG.ScsyERP.WebBoss.action.LoginableInfo;

import cn.AssassinG.ScsyERP.User.facade.entity.Corporation;
import cn.AssassinG.ScsyERP.User.facade.service.CorporationServiceFacade;
import cn.AssassinG.ScsyERP.User.facade.service.LoginableService;
import cn.AssassinG.ScsyERP.WebBoss.base.LoginableBaseController;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/BasicInfo/Corporation")
public class CorporationController extends LoginableBaseController<Corporation> {
    @Autowired
    private CorporationServiceFacade corporationServiceFacade;

    @Override
    protected LoginableService<Corporation> getLoginableService() {
        return this.corporationServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "承运方";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)//更新信息
    @ResponseBody
    public JSONObject update(Long EntityId, Map<String, Object> paramMap){
        return super.updateImpl(EntityId, paramMap);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)//删除信息
    @ResponseBody
    public JSONObject delete(Long EntityId){
        return super.deleteImpl(EntityId);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)//查询信息
    @ResponseBody
    public JSONObject query(Map<String, Object> paramMap){
        return super.queryImpl(paramMap);
    }
}
