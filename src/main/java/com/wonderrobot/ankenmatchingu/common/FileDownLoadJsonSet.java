package com.wonderrobot.ankenmatchingu.common;
// FileDownLoadJsonSetBuild.java
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.StringUtil;

public class FileDownLoadJsonSet {

	public static void setFunctionPrintJsonObj (String fileIDStr, String pageID, String subID, JSONWFCObject jsonObj) throws Exception {
		jsonObj.setReturnID("v","WF_PRINTFILEID");
		jsonObj.setValue("WF_PRINTFILEID",fileIDStr);
		jsonObj.setValue("WF_JSON_TYPE", "excel");
		jsonObj.setScript("r", "printAjax('"+ StringUtil.escapeJSTags(pageID) + "', '"+ StringUtil.escapeJSTags(subID) + "');");
	}
	
}
