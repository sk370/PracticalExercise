package iceriver.mall.computermall.interceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * 创建登录拦截器：防止未登录通过浏览器地址栏直接访问
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/10 9:30
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局session有无uid数据，有则放行，没有则重定向至登录界面
     * @param request
     * @param response
     * @param handler 处理器 url+Controller
     * @return true放行，false拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object uid = request.getSession().getAttribute("uid");
        if(uid == null){
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }
}
