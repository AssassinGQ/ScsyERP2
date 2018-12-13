package cn.AssassinG.ScsyERP.WebBoss.Intercepts;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestIntercepter implements HandlerInterceptor {

        public static final String MAPKEY = "ParamMap";
        /**
         * 在请求处理之前执行，
         * 该方法主要是用于准备资源数据的，
         * 然后可以把它们当做请求属性放到Request中
         * @param request
         * @throws Exception
         */
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            System.out.println("HttpRequestIntercepter====>preHandle");
            if(request.getRequestURI().endsWith("update")){
                Enumeration<String> paramNames = request.getParameterNames();
                Map<String, String> paramMap = new HashMap<>();
                while(paramNames.hasMoreElements()){
                    String name = paramNames.nextElement();//得到参数名
                    String value = request.getParameter(name);//通过参数名获取对应的值
                    paramMap.put(name, value);
                }
                request.setAttribute(MAPKEY, paramMap);
            }

            String originHeader = "Access-Control-Allow-Origin";
            if(!response.containsHeader(originHeader)) {
                String origin = request.getHeader("Origin");
                if(origin == null) {
                    String referer = request.getHeader("Referer");
                    if(referer != null) {
                        origin = referer.substring(0, referer.indexOf("/", 7));
                    }
                }
                response.setHeader("Access-Control-Allow-Origin", origin);
            }

            String methodsHeader = "Access-Control-Allow-Methods";
            response.setHeader(methodsHeader, "*");

            String headerHeader = "Access-Control-Allow-Headers";
            if(!response.containsHeader(headerHeader)){
                response.setHeader(headerHeader, "X-Requested-With,accept,origin,content-type");
            }else{
                response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
                response.setHeader("Access-Control-Expose-Headers", request.getHeader("Access-Control-Request-Headers"));
            }
            // 预检命令（OPTIONS）缓存时间，单位：秒
            response.setHeader("Access-Control-Max-Age", "3600");
            // 明确许可客户端发送Cookie，不允许删除字段即可
            String credentialHeader = "Access-Control-Allow-Credentials";
            response.setHeader(credentialHeader, "true");

            String method= request.getMethod();
            if (method.equals("OPTIONS")){
                response.setStatus(200);
                return false;
            }
            return true;
        }
        /**
         * 该方法将在Controller执行之后，
         * 返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在
         * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。
         */
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//            System.out.println("AppRequestInterceptor====>preHandle");
        }

        /**
         * 该方法将在整个请求完成之后，
         * 也就是说在视图渲染之后进行调用，
         * 主要用于进行一些资源的释放
         */
        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//            System.out.println("AppRequestInterceptor====>preHandle");
        }
}
