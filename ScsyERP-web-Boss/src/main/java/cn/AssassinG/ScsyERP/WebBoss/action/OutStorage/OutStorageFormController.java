package cn.AssassinG.ScsyERP.WebBoss.action.OutStorage;

import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.OutStorage.facade.service.OutStorageFormServiceFacade;
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
@RequestMapping("/out_storage_info")
public class OutStorageFormController extends BaseController<OutStorageForm> {
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
    public JSONObject addDriveWorkers(Long OutStorageForm, String jsonArrayStr){
        try{
            outStorageFormServiceFacade.addDriveWorkers(OutStorageForm, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单添加行车工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeDriveWorker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeDriveWorker(Long OutStorageForm, Long driveWorkerId){
        try{
            outStorageFormServiceFacade.removeDriveWorker(OutStorageForm, driveWorkerId);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单移除行车工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/addLiftWorkers", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addLiftWorkers(Long OutStorageForm, String jsonArrayStr){
        try{
            outStorageFormServiceFacade.addLiftWorkers(OutStorageForm, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单添加起重工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeLiftWorker", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeLiftWorker(Long OutStorageForm, Long liftWorkerId){
        try{
            outStorageFormServiceFacade.removeLiftWorker(OutStorageForm, liftWorkerId);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单移除起重工信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addProduct(Long OutStorageForm, Long productId){
        try{
            outStorageFormServiceFacade.addProduct(OutStorageForm, productId);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单添加货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeProduct(Long OutStorageForm, Long productId){
        try{
            outStorageFormServiceFacade.removeProduct(OutStorageForm, productId);
            return getResultJSON(RetStatusType.StatusSuccess, "出库单移除货物信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
}
