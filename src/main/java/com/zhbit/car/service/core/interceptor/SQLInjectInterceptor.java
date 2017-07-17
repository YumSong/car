package com.zhbit.car.service.core.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by lz on 2016/9/1 10:37.
 */
public class SQLInjectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String[] values = request.getParameterValues(name);
            for(String value : values){
                value = clearXss(value);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private String clearXss(String value){
        if(value == null || "".equals(value)){
            return value;
        }
        value = value.replaceAll("<","&lt;").replaceAll(">","&gt;");
        value = value.replaceAll("\\(","(").replaceAll("\\)",")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)","");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']","\"\"");
        value = value.replace("script","");
        return value;




    }

}
