package com.wonderrobot.ankenmatchingu.service.P002;
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
import com.wonderrobot.ankenmatchingu.entity.P002.P002Entity;
import com.wonderrobot.ankenmatchingu.dao.P002.P002InsertSaveDao;
import com.wonderrobot.ankenmatchingu.dao.P002.P002UpdateSaveDao;
/**
* class：P002saveService
 * Page：技術者明細
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class P002saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private P002InsertSaveDao P002InsertSaveDao;
	@Autowired
	private P002UpdateSaveDao P002UpdateSaveDao;

	/**
	 * セーブ機能を行う
	 * @param p002Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sP002doSave(P002Entity p002Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(p002Entity.getActflg());
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
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		// id
		String id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getTxt2())));
		AlKeyData.add(new ArrayList<String>(Arrays.asList(new String[] { "txt2" , id })));
		// 名前
		String name = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getName())));
		// 性别
		String sex = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getSex())));
		// 年齢
		String age = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getAge())));
		// 住所
		String address = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getAddress())));
		// 単価
		String price = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getPrice())));
		// 現在の会社
		String company_current = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getCompanycurrent())));
		// 資格
		String certificate = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getCertificate())));
		// 紹介
		String introduction = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getIntroduction())));
		// 入場可能時間
		String entry_time = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getEntrytime())));
		// 面接可能時間
		String interview_time = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getInterviewtime())));
		// スキル
		String skills = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getSkills())));
		// コメント
		String remark = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getRemark())));
		// 連絡先
		String contact = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getContact())));
		// 連絡先メール
		String contact_mail = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getContactmail())));
		// 連絡先会社
		String contact_company = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getContactcompany())));
		// 連絡先tel
		String contact_phone = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getContactphone())));
		// 連絡先アドレス
		String contact_address = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getContactaddress())));
		// 送信者
		String email_sender = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getEmailsender())));
		// メール送信時刻
		String email_send_time = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getEmailsendtime())));
		// メールタイトル
		String email_title = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getEmailtitle())));
		// メールの内容
		String email_content = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getEmailcontent())));
		// メール添付パス
		String email_attachment = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getEmailattachment())));
		// 国籍
		String nationality = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(p002Entity.getTxt56())));
		if (pageActionMode.equals("2")) {
			// Insert data to db.
			P002InsertSaveDao.p002InsertSaveData(id,name,sex,age,address,price,company_current,certificate,introduction,entry_time,interview_time,skills,remark,contact,contact_mail,contact_company,contact_phone,contact_address,email_sender,email_send_time,email_title,email_content,email_attachment,nationality,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		} else if (pageActionMode.equals("1")) {
			// Update data to db.
			P002UpdateSaveDao.p002UpdateSaveData(id,name,sex,age,address,price,company_current,certificate,introduction,entry_time,interview_time,skills,remark,contact,contact_mail,contact_company,contact_phone,contact_address,email_sender,email_send_time,email_title,email_content,email_attachment,nationality,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
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
