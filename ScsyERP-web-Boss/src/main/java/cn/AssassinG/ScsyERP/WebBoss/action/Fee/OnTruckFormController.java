package cn.AssassinG.ScsyERP.WebBoss.action.Fee;

import cn.AssassinG.ScsyERP.Fee.facade.entity.OnTruckForm;
import cn.AssassinG.ScsyERP.Fee.facade.service.OnTruckFormServiceFacade;
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
@RequestMapping("/OnTruckForm")
public class OnTruckFormController extends BaseController<OnTruckForm> {
    @Autowired
    private OnTruckFormServiceFacade onTruckFormServiceFacade;
    @Override
    protected BaseService<OnTruckForm> getService() {
        return this.onTruckFormServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "随车清单";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)//创建信息
    @ResponseBody
    public JSONObject create(OnTruckForm onTruckForm){
        return super.createImpl(onTruckForm);
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

    @RequestMapping(value = "/addPicture", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addPicture(Long OnTruckForm, Long pictureId){
        try{
            onTruckFormServiceFacade.addPicture(OnTruckForm, pictureId);
            return getResultJSON(RetStatusType.StatusSuccess, "随车清单添加图片信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removePicture", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removePicture(Long OnTruckForm, Long pictureId){
        try{
            onTruckFormServiceFacade.removePicture(OnTruckForm, pictureId);
            return getResultJSON(RetStatusType.StatusSuccess, "随车清单移除图片信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject complete(Long OnTruckForm){
        try{
            onTruckFormServiceFacade.complete(OnTruckForm);
            return getResultJSON(RetStatusType.StatusSuccess, "随车清单已完成", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
}
