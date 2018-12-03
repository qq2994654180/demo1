package com.example.demo1.common;

import com.example.demo1.common.customsection.LoginRequired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 自定义拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            HttpSession session = request.getSession(true);
            //判断用户ID是否存在，不存在就跳转到登录界面
            if(session.getAttribute("user") == null){
                response.sendRedirect(request.getContextPath()+"/login");
                return false;
            }else{
                return true;
            }
        }
        return true;
    }
}
