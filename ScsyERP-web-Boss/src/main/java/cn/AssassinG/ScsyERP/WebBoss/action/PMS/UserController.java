package cn.AssassinG.ScsyERP.WebBoss.action.PMS;

import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.User.facade.service.CorporationServiceFacade;
import cn.AssassinG.ScsyERP.User.facade.service.GovernmentServiceFacade;
import cn.AssassinG.ScsyERP.User.facade.service.UserServiceFacade;
import cn.AssassinG.ScsyERP.WebBoss.base.BaseController;
import cn.AssassinG.ScsyERP.WebBoss.enums.RetStatusType;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;
import cn.AssassinG.ScsyERP.common.exceptions.BizException;
import cn.AssassinG.ScsyERP.common.exceptions.DaoException;
import cn.AssassinG.ScsyERP.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller("UserController")
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserServiceFacade userServiceFacade;
    @Autowired
    private CorporationServiceFacade corporationServiceFacade;
    @Autowired
    private GovernmentServiceFacade governmentServiceFacade;

    @Override
    protected BaseService<User> getService() {
        return this.userServiceFacade;
    }

    @Override
    protected String getClassDesc() {
        return "登录信息";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)//测试页面
    public String toTest(ModelMap model){
        return "test/test";
    }

    @RequestMapping(value = "/getVcode", method = RequestMethod.GET)//获取验证码
    @ResponseBody
    public JSONObject toReg(@RequestParam("phone") String phone){
        User user = userServiceFacade.findUserByPhone(phone);
        String vcode = StringUtils.getRandomStr(6);
        if(user == null){
            User new_user = new User();
            new_user.setPhone(phone);
            new_user.setVcode(vcode);
            new_user.setVcodeTime(new Date());
            System.out.println(new_user);
            userServiceFacade.create(new_user);
        }else{
            user.setVcode(vcode);
            user.setVcodeTime(new Date());
            System.out.println(user);
            userServiceFacade.update(user);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 1);
        jsonObject.put("msg", "请求成功");
        JSONObject contentObject = new JSONObject();
        contentObject.put("vcode", vcode);
        jsonObject.put("data", contentObject);
        return jsonObject;
    }

    private static final int AccountTypeCorporation = 0;
    private static final int AccountTypeGovernment = 1;
    @RequestMapping(value = "/getAccount", method = RequestMethod.POST)//生成账号
    @ResponseBody
    public JSONObject getAccount(String token, Integer type, String Name, User user){
        if(type == null || (type != AccountTypeGovernment && type != AccountTypeCorporation)){
            return getResultJSON("请选择正确的申请账户类型");
        }else{
            try{
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("name", Name);
                Long Id;
                if(type == AccountTypeCorporation){
                    Id = corporationServiceFacade.create(token, user, paramMap);
                }else{
                    Id = governmentServiceFacade.create(token, user, paramMap);
                }
                if(Id == null || Id == -1L){
                    return getResultJSON("创建账户失败");
                }else{
                    JSONObject contentObject = new JSONObject();
                    contentObject.put("userId", Id);
                    return getResultJSON(RetStatusType.StatusSuccess, "创建账户成功", contentObject);
                }
            }catch (BizException | DaoException e) {
                return getResultJSON(e.getMessage());
            }

        }
    }

    @RequestMapping(value = "/getVcode", method = RequestMethod.POST)//获取验证码
    @ResponseBody
    public JSONObject getVcode(String Phone){
        try{
            String Vcode = userServiceFacade.getVcode(Phone);
            JSONObject contentObject = new JSONObject();
            contentObject.put("Vcode", Vcode);
            return getResultJSON(RetStatusType.StatusSuccess, "", contentObject);
        }catch(DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @Secured("ROLE_PAGE_HOME")
    @RequestMapping(value = "/changePsw", method = RequestMethod.POST)//修改密码
    @ResponseBody
    public JSONObject changePsw(String Phone, String Vcode, String newPassWord){
        try{
            userServiceFacade.ChangePSW(Phone, Vcode, newPassWord);
            return getResultJSON(RetStatusType.StatusSuccess, "密码修改成功", null);
        }catch(DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/changeUname", method = RequestMethod.POST)//修改用户名
    @ResponseBody
    public JSONObject changeUname(Long userId, String Vcode, String newUserName){
        try{
            userServiceFacade.ChangeUserName(userId, Vcode, newUserName);
            return getResultJSON(RetStatusType.StatusSuccess, "用户名修改成功", null);
        }catch(DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    @RequestMapping(value = "/changePhone", method = RequestMethod.POST)//修改手机号
    @ResponseBody
    public JSONObject changePhone(Long userId, String Vcode, String newPhone){
        try{
            userServiceFacade.ChangePhone(userId, Vcode, newPhone);
            return getResultJSON(RetStatusType.StatusSuccess, "手机号修改成功", null);
        }catch(DaoException | BizException e){
            return getResultJSON(e.getMessage());
        }
    }

    /**
     * 返回登录页面，不是登录处理，用于SpringSecurity
     * @param error
     * @param logout
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView toLogin(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout){
        logger.info("get login");
        ModelAndView model = new ModelAndView();
        if(error != null){
            model.addObject("login_info", "用户名或密码不正确!");
        }
        if(logout != null){
            model.addObject("login_info", "您已成功注销系统.");
        }
        model.setViewName("user/login");
        return model;
    }
    //    @RequestMapping(value = "/login", method = RequestMethod.POST)//登录
//    @ResponseBody
//    public JSONObject login(String UserName, String PassWord){
//        try{
//            if(userServiceFacade.login(UserName, PassWord)){
//                return getResultJSON(RetStatusType.StatusSuccess, "登录成功", null);
//            }else{
//                return getResultJSON("登录失败");
//            }
//        }catch(DaoException | BizException e){
//            return getResultJSON(e.getMessage());
//        }
//    }

//    @RequestMapping(value = "/reg", method = RequestMethod.POST)//提交注册
//    @ResponseBody
//    public JSONObject doReg(User user){
//        JSONObject jsonObject = new JSONObject();
//        if(user.getUserName() == null || user.getUserName().isEmpty()){
//            jsonObject.put("status", 0);
//            jsonObject.put("msg", "请输入用户名");
//            jsonObject.put("data", null);
//            return jsonObject;
//        }else{
//            User user_uname = userServiceFacade.findUserByUname(user.getUserName());
//            if(user_uname != null){
//                jsonObject.put("status", 0);
//                jsonObject.put("msg", "用户名不可用");
//                jsonObject.put("data", null);
//                return jsonObject;
//            }
//        }
//        if(user.getPassWord() == null || user.getPassWord().isEmpty()){
//            jsonObject.put("status", 0);
//            jsonObject.put("msg", "请输入密码");
//            jsonObject.put("data", null);
//            return jsonObject;
//        }
//        User p_user = userServiceFacade.findUserByPhone(user.getPhone());
//        if(p_user == null || (!p_user.getVcode().equals(user.getVcode()))){
//            jsonObject.put("status", 0);
//            jsonObject.put("msg", "验证码不正确");
//            jsonObject.put("data", null);
//            return jsonObject;
//        }else{
//            long vcodetime = p_user.getVcodeTime().getTime();
//            long nowtime = System.currentTimeMillis();
//            long dur = nowtime - vcodetime;
//            if(dur > 1000*60*5){
//                jsonObject.put("status", 0);
//                jsonObject.put("msg", "验证码已过期");
//                jsonObject.put("data", null);
//                return jsonObject;
//            }
//            p_user.setUserName(user.getUserName());
//            p_user.setPassWord(user.getPassWord());
//            userServiceFacade.update(p_user);
//            jsonObject.put("status", 1);
//            jsonObject.put("msg", "注册成功");
//            jsonObject.put("data", null);
//            return jsonObject;
//        }
//    }
}
