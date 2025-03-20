package com.wonderrobot.ankenmatchingu.common;
// LogFourJUtlilBuild.java
import org.slf4j.MDC;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.wonderfulfly.core.constant.SessionConstant;
import com.wonderfulfly.core.util.StringUtil;

public class LogFourJUtil {
	public static void putMDC(String mdcID, String mdcValue) {
		MDC.put(mdcID, mdcValue);
	}

	public static void putMDC(String pageName) {
		putMDC("PAGENAME", pageName);
	}

	public static void putMDC(String pageName, HttpServletRequest request) {
		putMDC("PAGENAME", pageName);
		HttpSession session = request.getSession();
		String loginID  = StringUtil.changeNullToBlank((String)session.getAttribute(SessionConstant.USER_ID));
		if (!StringUtil.isNullOrBlank(loginID)) {
			putMDC(SessionConstant.USER_ID, loginID);
		}
	}

}
