package cn.AssassinG.ScsyERP.WebBoss.security;

import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.User.facade.service.UserServiceFacade;
import cn.AssassinG.ScsyERP.WebBoss.enums.RetStatusType;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserServiceFacade userServiceFacade;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        JSONObject retObject = new JSONObject();
        retObject.put("status", RetStatusType.StatusSuccess.getStatus());
        retObject.put("msg", "登录成功");
        JSONObject contentObject = new JSONObject();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            User user = userServiceFacade.findUserByUname(((UserDetails)principal).getUsername());
            if(user != null && !user.getIfDeleted()){
                contentObject.put("Id", user.getId());
                contentObject.put("UserName", user.getUserName());
                contentObject.put("UserTypeName", user.getUserType().getName());
                contentObject.put("UserType", user.getUserType().getValue());
                contentObject.put("UserInfo", user.getUserInfo());
                contentObject.put("Corporation", user.getCorporation());
                contentObject.put("Phone", user.getPhone());
            }
        }
        retObject.put("content", contentObject);
        PrintWriter out = httpServletResponse.getWriter();
        out.write(retObject.toJSONString());
        out.flush();
        out.close();
    }
}
