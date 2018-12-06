package cn.AssassinG.ScsyERP.WebBoss.action.InStorage;

import cn.AssassinG.ScsyERP.InStorage.facade.entity.InStorageForm;
import cn.AssassinG.ScsyERP.InStorage.facade.service.InStorageFormServiceFacade;
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
@RequestMapping("/in_storage_info")
public class InStorageFormController extends BaseController<InStorageForm> {
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

    @RequestMapping(value = "/addDriveWorkers", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addDriveWorkers(Long InStorageForm, String jsonArrayStr){
        try{
            inStorageFormServiceFacade.addDriveWorkers(InStorageForm, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单添加行车工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeDriveWorker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeDriveWorker(Long InStorageForm, Long driveWorkerId){
        try{
            inStorageFormServiceFacade.removeDriveWorker(InStorageForm, driveWorkerId);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单移除行车工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/addLiftWorkers", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addLiftWorkers(Long InStorageForm, String jsonArrayStr){
        try{
            inStorageFormServiceFacade.addLiftWorkers(InStorageForm, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单添加起重工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeLiftWorker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeLiftWorker(Long InStorageForm, Long liftWorkerId){
        try{
            inStorageFormServiceFacade.removeLiftWorker(InStorageForm, liftWorkerId);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单移除起重工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addProduct(Long InStorageForm, Long productId){
        try{
            inStorageFormServiceFacade.addProduct(InStorageForm, productId);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单添加货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeProduct(Long InStorageForm, Long productId){
        try{
            inStorageFormServiceFacade.removeProduct(InStorageForm, productId);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单移除货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/upload_location", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadLocation(Long Warehouse, String Location){
        try{
            inStorageFormServiceFacade.updateProductLocation(Warehouse, Location);
            return getResultJSON(RetStatusType.StatusSuccess, "设置货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/complete", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject complete(Long InStorageForm){
        try{
            inStorageFormServiceFacade.complete(InStorageForm);
            return getResultJSON(RetStatusType.StatusSuccess, "入库单已完成", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
}
