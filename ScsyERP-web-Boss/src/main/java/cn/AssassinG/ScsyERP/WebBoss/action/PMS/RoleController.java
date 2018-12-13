package cn.AssassinG.ScsyERP.WebBoss.action.PMS;

import cn.AssassinG.ScsyERP.User.facade.entity.Role;
import cn.AssassinG.ScsyERP.WebBoss.base.BaseController;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {
    private static final long serialVersionUID = 2143900832034488834L;

    @Override
    protected BaseService<Role> getService() {
        return null;
    }

    @Override
    protected String getClassDesc() {
        return null;
    }
}
