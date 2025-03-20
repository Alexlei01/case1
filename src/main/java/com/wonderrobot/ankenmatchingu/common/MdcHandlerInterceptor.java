package com.wonderrobot.ankenmatchingu.common;
// MdcHandlerInterceptor.vm
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * MDC Interceptor USER_ID
 */
public class MdcHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	LogFourJUtil.putMDC("USER_ID", request);
        return true;
    }

    /**
     * MDC clear
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        MDC.clear();
    }
}
