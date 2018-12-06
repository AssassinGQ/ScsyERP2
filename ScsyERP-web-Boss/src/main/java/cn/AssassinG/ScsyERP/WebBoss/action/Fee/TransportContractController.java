package cn.AssassinG.ScsyERP.WebBoss.action.Fee;

import cn.AssassinG.ScsyERP.Fee.facade.entity.TransportContract;
import cn.AssassinG.ScsyERP.Fee.facade.service.TransportContractServiceFacade;
import cn.AssassinG.ScsyERP.WebBoss.base.BaseController;
import cn.AssassinG.ScsyERP.WebBoss.enums.RetStatusType;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;
import cn.AssassinG.ScsyERP.common.exceptions.BizException;
import cn.AssassinG.ScsyERP.common.exceptions.DaoException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/TransportContract")
public class TransportContractController extends BaseController<TransportContract> {
    @Autowired
    private TransportContractServiceFacade transportContractServiceFacade;
    @Override
    protected BaseService<TransportContract> getService() {
        return this.transportContractServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "运输合同";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)//创建信息
    @ResponseBody
    public JSONObject create(TransportContract transportContract){
        return super.createImpl(transportContract);
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

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject complete(Long transportContract){
        try{
            transportContractServiceFacade.complete(transportContract);
            return getResultJSON(RetStatusType.StatusSuccess, "运输合同已完成", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
}
