package com.wonderrobot.ankenmatchingu.common;
// AccessDeniedExceptionHandler.vm
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.log.LoggerUtil;

@ControllerAdvice
public class AccessDeniedExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestURI = request.getRequestURI();
        LoggerUtil.error(String.format("Rikuestadores'%s',exception'%s'", requestURI, e.getMessage()), e);
        JSONWFCObject jsonObj = new JSONWFCObject();
        jsonObj.setScript(JsonConstant.JSONID_MSG, "アクセス権限がありません。");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(jsonObj.toJSONString());
    }
}