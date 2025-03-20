package com.wonderrobot.ankenmatchingu.security;
// AuthenticationEntryPointImpl.vm
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.log.LoggerUtil;

/**
 * Permission Authentication Failure Handling Class
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException {
        LoggerUtil.error("AuthenticationEntryPointImpl--------UnAuthorized--------");

        // post method for ajax
        if ("POST".equals(request.getMethod())) {
        	JSONWFCObject jsonObj = new JSONWFCObject();
        	jsonObj.setScript(JsonConstant.JSONID_RUN_SCRIPT, "alert('長時間利用されていないため、タイムアウトしました。再度ログインしてください。');");
        	jsonObj.setScript(JsonConstant.JSONID_RUN_SCRIPT, "location.href='login'");
        	response.setContentType("text/plain;charset=UTF-8");
        	response.setHeader("X-Session-Expired", "true");
        	response.getWriter().print(jsonObj.toJSONString());

        	return;
        }

        // other method
        response.sendRedirect("/login");
    }
}