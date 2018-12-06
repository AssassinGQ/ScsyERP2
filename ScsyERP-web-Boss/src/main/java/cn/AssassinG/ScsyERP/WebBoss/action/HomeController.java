package cn.AssassinG.ScsyERP.WebBoss.action;

import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.WebBoss.base.BaseController;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends BaseController<User> {

    @Secured("ROLE_PAGE_HOME")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap model) {
        return "home";
    }

    @Override
    protected BaseService<User> getService() {
        return null;
    }

    @Override
    protected String getClassDesc() {
        return null;
    }
}
