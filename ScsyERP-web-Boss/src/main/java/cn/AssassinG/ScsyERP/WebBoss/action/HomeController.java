package cn.AssassinG.ScsyERP.WebBoss.action;

import cn.AssassinG.ScsyERP.WebBoss.base.BaseController;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController extends BaseController {

    @Secured("ROLE_PAGE_HOME")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap model) {
        return "home";
    }
}
