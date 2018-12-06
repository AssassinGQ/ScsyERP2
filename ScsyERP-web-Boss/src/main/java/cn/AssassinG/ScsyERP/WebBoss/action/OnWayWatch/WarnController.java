package cn.AssassinG.ScsyERP.WebBoss.action.OnWayWatch;

import cn.AssassinG.ScsyERP.OnWayWatch.facade.entity.Warn;
import cn.AssassinG.ScsyERP.OnWayWatch.facade.service.WarnServiceFacade;
import cn.AssassinG.ScsyERP.WebBoss.base.BaseController;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/warn")
public class WarnController extends BaseController<Warn> {
    @Autowired
    private WarnServiceFacade warnServiceFacade;
    @Override
    protected BaseService<Warn> getService() {
        return this.warnServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "异常";
    }

//    @RequestMapping(value = "/create", method = RequestMethod.POST)//创建信息
//    @ResponseBody
//    public JSONObject create(Warn warn){
//        return super.createImpl(warn);
//    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)//更新信息
    @ResponseBody
    public JSONObject update(Long EntityId, Map<String, Object> paramMap){
        return super.updateImpl(EntityId, paramMap);
    }

//    @RequestMapping(value = "/delete", method = RequestMethod.POST)//删除信息
//    @ResponseBody
//    public JSONObject delete(Long EntityId){
//        return super.deleteImpl(EntityId);
//    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)//查询信息
    @ResponseBody
    public JSONObject query(Map<String, Object> paramMap){
        return super.queryImpl(paramMap);
    }
}
