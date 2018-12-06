package cn.AssassinG.ScsyERP.WebBoss.action.UnLoginableInfo;

import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Material;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.MaterialServiceFacade;
import cn.AssassinG.ScsyERP.common.core.service.UnLoginableService;
import cn.AssassinG.ScsyERP.WebBoss.base.UnLoginableBaseController;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/basic_info/material")
public class MaterialController extends UnLoginableBaseController<Material> {
    @Autowired
    private MaterialServiceFacade materialServiceFacade;

    @Override
    protected UnLoginableService<Material> getUnLoginableService() {
        return this.materialServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "物料";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)//创建信息
    @ResponseBody
    public JSONObject create(Material material){
        return super.createImpl(material);
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
