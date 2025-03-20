package com.wonderrobot.ankenmatchingu.service.J004;
// ControllerFormat.java
import javax.servlet.http.HttpServletRequest;
import com.wonderfulfly.core.util.log.LoggerUtil;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.StringUtil;
import org.springframework.transaction.annotation.Transactional;
import com.wonderrobot.ankenmatchingu.entity.J004.J004Entity;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Init
 * 案件マッチング
 * Page: 案件一覧
 */
@Service
public class J004InitService {

   
	/**
	 * 初期化フォーム
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void j004grd2pageInitGrid (JSONWFCObject jsonObj) throws Exception {

		jsonObj.setHtml("dragB2", null);

	}

   
	/**
	 * ページの初期化
	 * @param j004Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sj004Init (J004Entity j004Entity) throws Exception {

		//mode
		String mode = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j004Entity.getMode())));
		if ("1".equals(mode)) {
			j004grd2pageInitGrid(jsonObj);
		}
		jsonObj.setScript("r", "F20230130172718605();");
		return jsonObj;

	}
}