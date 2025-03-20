package com.wonderrobot.ankenmatchingu.common;
// LoginCheckUtilBuild.java
import com.wonderfulfly.core.constant.SessionConstant;
import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.constant.JsonConstant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckUtil {
	public static boolean hasUserID(HttpServletRequest request, JSONWFCObject jsonObj) {
		HttpSession session = request.getSession();
		String loginID  = StringUtil.changeNullToBlank((String)session.getAttribute(SessionConstant.USER_ID));
		if (StringUtil.isNullOrBlank(loginID)) {
			jsonObj.setScript(JsonConstant.JSONID_MSG, "長時間利用されていないため、タイムアウトしました。再度ログインしてください。;location.href='logout'");
			return false;
		}
		return true;
	}
	
	public static String hasUserID(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loginID  = StringUtil.changeNullToBlank((String)session.getAttribute(SessionConstant.USER_ID));
		if (StringUtil.isNullOrBlank(loginID)) {
			return "長時間利用されていないため、タイムアウトしました。再度ログインしてください。";
		}
		return null;
	}
}
