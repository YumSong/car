package com.zhbit.car.service.core.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lz on 2016/9/1 10:37.
 */
public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("Referer: " + request.getHeader("Referer"));
//        if ((request.getHeader("Referer") == null || request.getHeader("Referer").indexOf("localhost") > -1
//                || request.getHeader("Referer").indexOf("taxi.zhthinkjoy.com") > -1)) {
            return true;
//        }
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/plain;charset=utf-8");
//        response.getWriter().write("{\"success\":false,\"message\":\"您的请求存在错误!\"}");
//        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
