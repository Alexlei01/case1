package com.wonderrobot.ankenmatchingu.service.P001;
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
import com.wonderrobot.ankenmatchingu.entity.P001.P001Entity;
import com.wonderrobot.ankenmatchingu.dao.P001.P001InsertSaveDao;
import com.wonderrobot.ankenmatchingu.dao.P001.P001UpdateSaveDao;
/**
* class：P001saveService
 * Page：技術者タグ
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class P001saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private P001InsertSaveDao P001InsertSaveDao;
	@Autowired
	private P001UpdateSaveDao P001UpdateSaveDao;

	/**
	 * セーブ機能を行う
	 * @param p001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sP001doSave(P001Entity p001Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(p001Entity.getActflg());
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
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		// id
		String id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getTxt2())));
		AlKeyData.add(new ArrayList<String>(Arrays.asList(new String[] { "txt2" , id })));
		// タグタイプ
		String tag_type = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getTagtype())));
		// タグID
		String tag_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getTagid())));
		// 開始番号
		String number_start = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getNumberstart())));
		// 終了番号
		String number_end = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getNumberend())));
		// 値
		String value = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getValue())));
		// 詳細ID
		String detail_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getDetailid())));
		// タグコード
		String tag_code = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getTagcode())));
		// メール送信時刻
		String email_send_time = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p001Entity.getEmailsendtime())));
		if (pageActionMode.equals("2")) {
			// Insert data to db.
			P001InsertSaveDao.p001InsertSaveData(id,tag_type,tag_id,number_start,number_end,value,detail_id,tag_code,email_send_time,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		} else if (pageActionMode.equals("1")) {
			// Update data to db.
			P001UpdateSaveDao.p001UpdateSaveData(id,tag_type,tag_id,number_start,number_end,value,detail_id,tag_code,email_send_time,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
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
