package com.wonderrobot.ankenmatchingu.aspect;
// LogAspect.vm
import com.wonderfulfly.core.util.log.LoggerUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * LogAspect
 */
@Aspect
@Component
public class LogAspect {

    /**
     * Before advice
     *
     * @param joinPoint
     */
    @Before(value = "@annotation(logAnnotation)")
    public void methodBefore(JoinPoint joinPoint, Log logAnnotation) {
        //start time
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //Print request content
        String requestUri = request.getRequestURL().toString();
        // Request class method
        String method = request.getMethod();
        // Request class method parameters
        String args = joinPoint.getArgs() != null ? Arrays.toString(joinPoint.getArgs()) : "";
        LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": start");
    }

    /**
     * Execute after processing the request
     *
     * @param joinPoint Tangent point
     */
    @AfterReturning(pointcut = "@annotation(logAnnotation)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Log logAnnotation, Object jsonResult) {
        LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": end");
    }

    /**
     * Intercept abnormal operation
     *
     * @param joinPoint Tangent point
     * @param e  abnormal
     */
    @AfterThrowing(value = "@annotation(logAnnotation)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Log logAnnotation, Exception e) throws Exception {
        LoggerUtil.error(Thread.currentThread().getStackTrace()[1].getMethodName() + ":", e);
        throw e;
    }

}