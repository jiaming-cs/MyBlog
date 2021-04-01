package com.jiaming.blog.intercepor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                
        if (request.getSession().getAttribute("user") == null){
            response.sendRedirect("/admin");
            return false;
        }else{
            return true;
        }
    }
     
}
