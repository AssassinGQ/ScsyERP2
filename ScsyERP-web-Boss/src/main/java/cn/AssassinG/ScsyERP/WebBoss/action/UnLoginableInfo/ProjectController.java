package cn.AssassinG.ScsyERP.WebBoss.action.UnLoginableInfo;

import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.ProjectServiceFacade;
import cn.AssassinG.ScsyERP.common.core.service.UnLoginableService;
import cn.AssassinG.ScsyERP.WebBoss.base.UnLoginableBaseController;
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
@RequestMapping("/basic_info/project")
public class ProjectController extends UnLoginableBaseController<Project> {
    @Autowired
    private ProjectServiceFacade projectServiceFacade;

    @Override
    protected UnLoginableService<Project> getUnLoginableService() {
        return this.projectServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "工程";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)//创建信息
    @ResponseBody
    public JSONObject create(Project project){
        return super.createImpl(project);
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

    @RequestMapping(value = "/addMaterials", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addMaterials(Long Project, String jsonArrayStr){
        try{
            projectServiceFacade.addMaterials(Project, jsonArrayStr);
            return getResultJSON(RetStatusType.StatusSuccess, "工程添加物料信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/removeMaterial", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject removeMaterial(Long Project, Long materialId){
        try{
            projectServiceFacade.removeMaterial(Project, materialId);
            return getResultJSON(RetStatusType.StatusSuccess, "工程移除物料信息成功", null);
        }catch (DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }
}
