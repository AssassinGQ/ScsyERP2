package cn.AssassinG.ScsyERP.WebBoss.action.OutStorage;

import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.OutStorage.facade.service.OutStorageFormServiceFacade;
import cn.AssassinG.ScsyERP.WebBoss.Intercepts.HttpRequestIntercepter;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/OutStorageForm")
public class OutStorageFormController extends BaseController<OutStorageForm> {
    private static final long serialVersionUID = 2317417190265586252L;
    @Autowired
    private OutStorageFormServiceFacade outStorageFormServiceFacade;
    @Override
    protected BaseService<OutStorageForm> getService() {
        return this.outStorageFormServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "出库单";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)//创建信息
    @ResponseBody
    public JSONObject create(OutStorageForm outStorageForm){
        return super.createImpl(outStorageForm);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)//更新信息
    @ResponseBody
    public JSONObject update(Long entityId, HttpServletRequest request){
        Map<String, String> paramMap = (Map<String, String>) request.getAttribute(HttpRequestIntercepter.MAPKEY);
        return super.updateImpl(entityId, paramMap);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)//删除信息
    @ResponseBody
    public JSONObject delete(Long entityId){
        return super.deleteImpl(entityId);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)//查询信息
    @ResponseBody
    public JSONObject query(Map<String, Object> paramMap){
        return super.queryImpl(paramMap);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)//查询信息
    @ResponseBody
    public JSONObject getById(Long entityId){
        return super.getByIdImpl(entityId);
    }

    @RequestMapping(value = "/addDriveWorkers", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addDriveWorkers(Long outStorageForm, String jsonArrayStr){
        try{
            outStorageFormServiceFacade.addDriveWorkers(outStorageForm, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单添加行车工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeDriveWorker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeDriveWorker(Long outStorageForm, Long driveWorkerId){
        try{
            outStorageFormServiceFacade.removeDriveWorker(outStorageForm, driveWorkerId);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单移除行车工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/addLiftWorkers", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addLiftWorkers(Long outStorageForm, String jsonArrayStr){
        try{
            outStorageFormServiceFacade.addLiftWorkers(outStorageForm, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单添加起重工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeLiftWorker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeLiftWorker(Long outStorageForm, Long liftWorkerId){
        try{
            outStorageFormServiceFacade.removeLiftWorker(outStorageForm, liftWorkerId);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单移除起重工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addProduct(Long outStorageForm, Long productId){
        try{
            outStorageFormServiceFacade.addProduct(outStorageForm, productId);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单添加货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeProduct(Long outStorageForm, Long productId){
        try{
            outStorageFormServiceFacade.removeProduct(outStorageForm, productId);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单移除货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
}
