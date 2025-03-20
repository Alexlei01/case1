package com.wonderrobot.ankenmatchingu.service.P002;
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
import com.wonderrobot.ankenmatchingu.entity.P002.P002Entity;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PEOPLE_DETAILEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.P002.P002PEOPLE_DETAILDao;
import com.wonderfulfly.core.util.DateUtil;
import java.text.DecimalFormat;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Search Init
 * 案件マッチング
 * Page: 技術者明細
 */
@Service
public class P002SearchInitService {
	@Autowired
	private P002PEOPLE_DETAILDao P002PEOPLE_DETAILDao;

   
	/**
	 * 標準検索の初期化
	 * @param null
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void p002pageInitValueSetByDB (List<P002PEOPLE_DETAILEntity> P002PEOPLE_DETAILEntityList, JSONWFCObject jsonObj) throws Exception {

		P002PEOPLE_DETAILEntity P002PEOPLE_DETAILEntity = null;
		if (P002PEOPLE_DETAILEntityList != null && P002PEOPLE_DETAILEntityList.size() == 1) {
			P002PEOPLE_DETAILEntity = P002PEOPLE_DETAILEntityList.get(0);
		}
		if (P002PEOPLE_DETAILEntity != null) {
			//id
			jsonObj.setValue("txt2", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getId())));
			//名前
			jsonObj.setValue("name", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getName())));
			//性别
			jsonObj.setValue("sex", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getSex())));
			//年齢
			jsonObj.setValue("age", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getAge())));
			//住所
			jsonObj.setValue("address", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getAddress())));
			//単価
			jsonObj.setValue("price", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getPrice())));
			//現在の会社
			jsonObj.setValue("companycurrent", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getCompanycurrent())));
			//資格
			jsonObj.setValue("certificate", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getCertificate())));
			//紹介
			jsonObj.setValue("introduction", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getIntroduction())));
			//入場可能時間
			jsonObj.setValue("entrytime", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getEntrytime())));
			//面接可能時間
			jsonObj.setValue("interviewtime", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getInterviewtime())));
			//スキル
			jsonObj.setValue("skills", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getSkills())));
			//コメント
			jsonObj.setValue("remark", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getRemark())));
			//連絡先
			jsonObj.setValue("contact", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getContact())));
			//連絡先メール
			jsonObj.setValue("contactmail", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getContactmail())));
			//連絡先会社
			jsonObj.setValue("contactcompany", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getContactcompany())));
			//連絡先tel
			jsonObj.setValue("contactphone", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getContactphone())));
			//連絡先アドレス
			jsonObj.setValue("contactaddress", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getContactaddress())));
			//送信者
			jsonObj.setValue("emailsender", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getEmailsender())));
			//メール送信時刻
			jsonObj.setValue("emailsendtime", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getEmailsendtime())));
			//メールタイトル
			jsonObj.setValue("emailtitle", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getEmailtitle())));
			//メールの内容
			jsonObj.setValue("emailcontent", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getEmailcontent())));
			//メール添付パス
			jsonObj.setValue("emailattachment", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getEmailattachment())));
			//国籍
			jsonObj.setValue("txt56", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P002PEOPLE_DETAILEntity.getNationality())));
		}

	}

   
	/**
	 * 標準検索の初期化
	 * @param P002PEOPLE_DETAILEntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sp002SearchInit (P002Entity p002Entity) throws Exception {

		//mode
		String mode = null;
		//txt2
		String txt2 = null;
		List<P002PEOPLE_DETAILEntity> P002PEOPLE_DETAILEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getMode())));
		if ("1".equals(mode)) {
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getTxt2())));
			P002PEOPLE_DETAILEntityList = P002PEOPLE_DETAILDao.p002SearchInitDepthZero(txt2);
			p002pageInitValueSetByDB(P002PEOPLE_DETAILEntityList, jsonObj);
		}
		return jsonObj;

	}
}