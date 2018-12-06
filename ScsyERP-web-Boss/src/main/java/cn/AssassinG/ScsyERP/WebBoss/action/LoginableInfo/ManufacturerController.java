package cn.AssassinG.ScsyERP.WebBoss.action.LoginableInfo;

import cn.AssassinG.ScsyERP.User.facade.entity.Manufacturer;
import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.User.facade.service.ManufacturerServiceFacade;
import cn.AssassinG.ScsyERP.User.facade.service.LoginableService;
import cn.AssassinG.ScsyERP.WebBoss.base.LoginableBaseController;
import cn.AssassinG.ScsyERP.WebBoss.enums.RetStatusType;
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
@RequestMapping("/basic_info/manufacturer")
public class ManufacturerController extends LoginableBaseController<Manufacturer> {
    @Autowired
    private ManufacturerServiceFacade manufacturerServiceFacade;

    @Override
    protected LoginableService<Manufacturer> getLoginableService() {
        return this.manufacturerServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "生产厂家";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)//创建信息
    @ResponseBody
    public JSONObject create(Manufacturer manufacturer, User user){
        return super.createImpl(manufacturer, user);
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

    @RequestMapping(value = "/addWorkshops", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addWorkshops(Long Manufacturer, String jsonArrayStr){
        try{
            manufacturerServiceFacade.addWorkshops(Manufacturer, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "生产厂家添加生产车间信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeWorkshop", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeWorkshop(Long Manufacturer, Long workshopId){
        try{
            manufacturerServiceFacade.removeWorkshop(Manufacturer, workshopId);
            return getResultJSON(RetStatusType.StatusSuccess, "生产厂家移除生产车间信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
}
