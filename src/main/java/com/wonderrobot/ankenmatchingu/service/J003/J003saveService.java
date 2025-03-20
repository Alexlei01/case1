package com.wonderrobot.ankenmatchingu.service.J003;
import com.wonderrobot.ankenmatchingu.aspect.Log;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.log.LoggerUtil;
import com.wonderfulfly.core.util.DateUtil;
import java.util.LinkedHashMap;
import org.json.simple.JSONValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.wonderrobot.ankenmatchingu.common.GetAutonum;
import com.wonderrobot.ankenmatchingu.dao.GetMaxNumValueDao;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.wonderrobot.ankenmatchingu.entity.J003.J003Entity;
import com.wonderrobot.ankenmatchingu.dao.J003.J003InsertSaveDao;
import com.wonderrobot.ankenmatchingu.dao.J003.J003UpdateSaveDao;
/**
* class：J003saveService
 * Page：案件タグ
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class J003saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private J003InsertSaveDao J003InsertSaveDao;
	@Autowired
	private J003UpdateSaveDao J003UpdateSaveDao;

	/**
	 * セーブ機能を行う
	 * @param j003Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sJ003doSave(J003Entity j003Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(j003Entity.getActflg());
		String pageActionMode = "";
		if (actFlg == 1) {
			// Insert
			pageActionMode = "2";
		} else if (actFlg == 2) { 
			// Update
			pageActionMode = "1";
		} else if (actFlg == 0) { 
			pageActionMode = "2";
		}
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		// id
		String id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getTxt2())));
		AlKeyData.add(new ArrayList<String>(Arrays.asList(new String[] { "txt2" , id })));
		// タグタイプ
		String tag_type = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getTagtype())));
		// タグID
		String tag_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getTagid())));
		// 開始番号
		String number_start = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getNumberstart())));
		// 終了番号
		String number_end = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getNumberend())));
		// 値
		String value = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getValue())));
		// 詳細ID
		String detail_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getDetailid())));
		// タグコード
		String tag_code = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getTagcode())));
		// メール送信時刻
		String email_send_time = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j003Entity.getEmailsendtime())));
		if (pageActionMode.equals("2")) {
			// Insert data to db.
			J003InsertSaveDao.j003InsertSaveData(id,tag_type,tag_id,number_start,number_end,value,detail_id,tag_code,email_send_time,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		} else if (pageActionMode.equals("1")) {
			// Update data to db.
			J003UpdateSaveDao.j003UpdateSaveData(id,tag_type,tag_id,number_start,number_end,value,detail_id,tag_code,email_send_time,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
		}
		jsonObj.setMessageValue("i", "保存が完了しました。");
		jsonObj.setValue("WF_RUNRESULT", "1");
		jsonObj.setReturnID("v", "WF_RUNRESULT");
		jsonObj.setValue("actflg", "2");
		jsonObj.setValue("mode", "1");
		jsonObj.setReturnID("v", "actflg");

		return jsonObj;
	}
}
