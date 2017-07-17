package com.zhbit.car.service.core.exception;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomHandlerExceptionResolver extends SimpleMappingExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("e", ex);
        logger.error("**********************系统异常************************", ex);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        ResponseBody body = handlerMethod.getMethodAnnotation(ResponseBody.class);
        // 判断有没有@ResponseBody的注解没有的话调用父方法   
        if (body == null) {
            ModelAndView modelAndView = super.doResolveException(request, response, handlerMethod, ex);
            if(ex.getMessage() == null){
                return new ModelAndView("error/err", model);
            }
            if (null == modelAndView) {
                return new ModelAndView("error/500", model);
            }
        }


        //这里可根据不同异常引起类做不同处理方式，做不同返回页面。
        String viewName = ClassUtils.getShortName(ex.getClass());
        if (viewName != null) {
            //如果是异步请求
            if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
                try {
                    ModelAndView mv = new ModelAndView();
                    //设置状态码
                    response.setStatus(HttpStatus.OK.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Cache-Control", "no-cache, must-revalidate");
                    PrintWriter writer = response.getWriter();
                    Map map = new HashMap();
                    map.put("success", false);
                    map.put("data", "您没有权限执行此操作,请联系管理员！");
                    writer.write(JSON.toJSONString(map));
                    writer.close();
                    writer.flush();
                    return mv;
                } catch (IOException e) {
                }
            } else {
                return new ModelAndView("error/500", model);
            }
        }
        return null;
    }


}
