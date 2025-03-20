package com.wonderrobot.ankenmatchingu.service.C002;
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
import com.wonderrobot.ankenmatchingu.entity.C002.C002Entity;
import com.wonderrobot.ankenmatchingu.dao.C002.C002InsertSaveDao;
import com.wonderrobot.ankenmatchingu.dao.C002.C002UpdateSaveDao;
/**
* class：C002saveService
 * Page：コミュニケーション記録
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class C002saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private C002InsertSaveDao C002InsertSaveDao;
	@Autowired
	private C002UpdateSaveDao C002UpdateSaveDao;

	/**
	 * セーブ機能を行う
	 * @param c002Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sC002doSave(C002Entity c002Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(c002Entity.getActflg());
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
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		// id
		String id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getTxt2())));
		AlKeyData.add(new ArrayList<String>(Arrays.asList(new String[] { "txt2" , id })));
		// レコードタイプ
		String record_type = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getRecordtype())));
		// 受信者
		String email_receiver = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getEmailreceiver())));
		// メールタイトル
		String email_title = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getEmailtitle())));
		// メールの内容
		String email_content = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getEmailcontent())));
		// 送信者
		String email_sender = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getEmailsender())));
		// 送信時間
		String email_send_time = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getEmailsendtime())));
		// マッチングID
		String match_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getMatchid())));
		// コミュニケーションID
		String c_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c002Entity.getTxt26())));
		if (pageActionMode.equals("2")) {
			// Insert data to db.
			C002InsertSaveDao.c002InsertSaveData(id,record_type,email_receiver,email_title,email_content,email_sender,email_send_time,match_id,c_id,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		} else if (pageActionMode.equals("1")) {
			// Update data to db.
			C002UpdateSaveDao.c002UpdateSaveData(id,record_type,email_receiver,email_title,email_content,email_sender,email_send_time,match_id,c_id,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
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
