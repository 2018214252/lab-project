package com.example.labteacherservice.interceptor;

import com.example.labteacherservice.common.EncryptComponent;
import com.example.labteacherservice.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private EncryptComponent encryptComponent;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle){
        String token = request.getHeader("token");
        if(token == null){
            throw new MyException(401, "未登录");
        }
        Map<String, Object> result = encryptComponent.decrypt(token);
        request.setAttribute("uid",result.get("uid"));
        request.setAttribute("role",result.get("role"));
        return true;
    }
}
