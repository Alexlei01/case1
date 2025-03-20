package com.wonderrobot.ankenmatchingu.common;
// GlobalExceptionHandler.vm
import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.log.LoggerUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestURI = request.getRequestURI();
        LoggerUtil.error(String.format("リクエストURL'%s',例外'%s'", requestURI, e.getMessage()), e);
        JSONWFCObject jsonObj = new JSONWFCObject();
        jsonObj.setScript(JsonConstant.JSONID_MSG, "システムエラーです。システム管理者にご連絡ください。");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(jsonObj.toJSONString());
    }
}