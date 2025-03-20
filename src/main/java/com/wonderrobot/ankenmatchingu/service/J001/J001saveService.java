package com.wonderrobot.ankenmatchingu.service.J001;
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
import com.wonderrobot.ankenmatchingu.entity.J001.J001Entity;
import com.wonderrobot.ankenmatchingu.dao.J001.J001InsertSaveDao;
import com.wonderrobot.ankenmatchingu.dao.J001.J001UpdateSaveDao;
/**
* class：J001saveService
 * Page：案件明細
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class J001saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private J001InsertSaveDao J001InsertSaveDao;
	@Autowired
	private J001UpdateSaveDao J001UpdateSaveDao;

	/**
	 * セーブ機能を行う
	 * @param j001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sJ001doSave(J001Entity j001Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(j001Entity.getActflg());
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
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		// id
		String id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getTxt2())));
		AlKeyData.add(new ArrayList<String>(Arrays.asList(new String[] { "txt2" , id })));
		// 項目
		String project = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getProject())));
		// 概要
		String outline = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getOutline())));
		// 機種
		String project_machine = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getProjectmachine())));
		// フェーズ
		String description = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getDescription())));
		// 募集要員
		String recruitment = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getRecruitment())));
		// 予定開始日
		String project_cycle = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getProjectcycle())));
		// 勤務先アドレス
		String work_address = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getWorkaddress())));
		// スキル要件
		String skill_required = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getSkillrequired())));
		// 予算
		String budget = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getBudget())));
		// 備考
		String remark = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getRemark())));
		// 送信者
		String email_sender = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getEmailsender())));
		// メールタイトル
		String email_title = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getEmailtitle())));
		// メールの内容
		String email_content = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getEmailcontent())));
		// メール送信時刻
		String email_send_time = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j001Entity.getEmailsendtime())));
		if (pageActionMode.equals("2")) {
			// Insert data to db.
			J001InsertSaveDao.j001InsertSaveData(id,project,outline,project_machine,description,recruitment,project_cycle,work_address,skill_required,budget,remark,email_sender,email_title,email_content,email_send_time,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		} else if (pageActionMode.equals("1")) {
			// Update data to db.
			J001UpdateSaveDao.j001UpdateSaveData(id,project,outline,project_machine,description,recruitment,project_cycle,work_address,skill_required,budget,remark,email_sender,email_title,email_content,email_send_time,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
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
