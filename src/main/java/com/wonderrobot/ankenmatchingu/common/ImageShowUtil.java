package com.wonderrobot.ankenmatchingu.common;
// ImageShowUtilBuild.java
import com.wonderfulfly.core.util.StringUtil;

public class ImageShowUtil {
	public static String getImageShowUrlStr (String imageName) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		if (StringUtil.isNullOrBlank(imageName)) {
			sBuffer.append("../images/").append("nofile.gif");
		} else {
			sBuffer.append("../upload/").append(imageName);
		}
		return sBuffer.toString();
	}
}
