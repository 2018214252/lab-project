package com.example.labadminservice.interceptor;

import com.example.labadminservice.common.MyException;
import com.example.labadminservice.common.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle){
        if(Integer.parseInt(String.valueOf(request.getAttribute("role")))< Role.ADMIN){
            throw new MyException(403, "无权限");
        }
        return true;
    }
}
