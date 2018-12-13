package cn.AssassinG.ScsyERP.WebBoss.action.InStorage;

import cn.AssassinG.ScsyERP.InStorage.facade.entity.InStorageForm;
import cn.AssassinG.ScsyERP.InStorage.facade.service.InStorageFormServiceFacade;
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
@RequestMapping("/InStorageForm")
public class InStorageFormController extends BaseController<InStorageForm> {
    private static final long serialVersionUID = -6911275633006355328L;
    @Autowired
    private InStorageFormServiceFacade inStorageFormServiceFacade;
    @Override
    protected BaseService<InStorageForm> getService() {
        return this.inStorageFormServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "入库单";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)//创建信息
    @ResponseBody
    public JSONObject create(InStorageForm inStorageForm){
        return super.createImpl(inStorageForm);
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
    public JSONObject addDriveWorkers(Long inStorageForm, String jsonArrayStr){
        try{
            inStorageFormServiceFacade.addDriveWorkers(inStorageForm, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单添加行车工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeDriveWorker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeDriveWorker(Long inStorageForm, Long driveWorkerId){
        try{
            inStorageFormServiceFacade.removeDriveWorker(inStorageForm, driveWorkerId);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单移除行车工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/addLiftWorkers", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addLiftWorkers(Long inStorageForm, String jsonArrayStr){
        try{
            inStorageFormServiceFacade.addLiftWorkers(inStorageForm, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单添加起重工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeLiftWorker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeLiftWorker(Long inStorageForm, Long liftWorkerId){
        try{
            inStorageFormServiceFacade.removeLiftWorker(inStorageForm, liftWorkerId);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单移除起重工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addProduct(Long inStorageForm, Long productId){
        try{
            inStorageFormServiceFacade.addProduct(inStorageForm, productId);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单添加货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeProduct(Long inStorageForm, Long productId){
        try{
            inStorageFormServiceFacade.removeProduct(inStorageForm, productId);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单移除货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/upload_location", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadLocation(Long warehouse, String location){
        try{
            inStorageFormServiceFacade.updateProductLocation(warehouse, location);
            return getResultJSON(RetStatusType.StatusSuccess, "设置货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject complete(Long inStorageForm){
        try{
            inStorageFormServiceFacade.complete(inStorageForm);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单已完成", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
}
