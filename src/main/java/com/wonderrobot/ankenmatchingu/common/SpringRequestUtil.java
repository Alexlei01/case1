package com.wonderrobot.ankenmatchingu.common;
// SpringRequestUtilBuild.java
import javax.servlet.http.HttpServletRequest;
import com.wonderfulfly.core.util.StringUtil;
public class SpringRequestUtil {
	public static String getParameterByUTF8(HttpServletRequest request, String iParameter) throws Exception {
		String paramValue = null;
		try {
			paramValue = StringUtil.escapeSQLTags(request.getParameter(iParameter));
			if (paramValue == null)
				return null;
			return new String(paramValue.getBytes("iso-8859-1"), "utf-8").trim();
		} catch (Exception e) {
			throw e;
		}
	}
}
