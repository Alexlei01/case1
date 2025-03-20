package com.wonderrobot.ankenmatchingu.aspect;
// ControllerAspect.vm
import com.wonderfulfly.core.util.log.LoggerUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * ControllerAspect
 */
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("execution(public * com.wonderrobot.ankenmatchingu.controller..*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //start time
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //Print request content
        String requestUri = request.getRequestURL().toString();
        // Request class method
        String method = request.getMethod();
        // Request class method parameters
        String args = proceedingJoinPoint.getArgs() != null ? Arrays.toString(proceedingJoinPoint.getArgs()) : "";
        // Front
        LoggerUtil.debug(method + ": ControllerAspect-------- start");
        Object result = proceedingJoinPoint.proceed();
        // Rear
        LoggerUtil.debug(method + ": ControllerAspect-------- end");
        return result;
    }

}