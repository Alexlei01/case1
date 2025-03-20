package com.wonderrobot.ankenmatchingu.service.J001;
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
import com.wonderrobot.ankenmatchingu.entity.J001.J001Entity;
import com.wonderrobot.ankenmatchingu.entity.J001.J001JOB_DETAILEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.J001.J001JOB_DETAILDao;
import com.wonderfulfly.core.util.DateUtil;
import java.text.DecimalFormat;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Init
 * 案件マッチング
 * Page: 案件明細
 */
@Service
public class J001InitService {
	@Autowired
	private J001JOB_DETAILDao J001JOB_DETAILDao;

   
	/**
	 * データベースを介してページを初期化する
	 * @param J001JOB_DETAILEntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void j001pageInitValueSetByDB (List<J001JOB_DETAILEntity> J001JOB_DETAILEntityList, JSONWFCObject jsonObj) throws Exception {

		J001JOB_DETAILEntity J001JOB_DETAILEntity = null;
		if (J001JOB_DETAILEntityList != null && J001JOB_DETAILEntityList.size() == 1) {
			J001JOB_DETAILEntity = J001JOB_DETAILEntityList.get(0);
		}
		if (J001JOB_DETAILEntity != null) {
			//id
			jsonObj.setValue("txt2", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getId())));
			//項目
			jsonObj.setValue("project", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getProject())));
			//概要
			jsonObj.setValue("outline", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getOutline())));
			//機種
			jsonObj.setValue("projectmachine", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getProjectmachine())));
			//フェーズ
			jsonObj.setValue("description", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getDescription())));
			//募集要員
			jsonObj.setValue("recruitment", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getRecruitment())));
			//予定開始日
			jsonObj.setValue("projectcycle", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getProjectcycle())));
			//勤務先アドレス
			jsonObj.setValue("workaddress", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getWorkaddress())));
			//スキル要件
			jsonObj.setValue("skillrequired", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getSkillrequired())));
			//予算
			jsonObj.setValue("budget", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getBudget())));
			//備考
			jsonObj.setValue("remark", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getRemark())));
			//送信者
			jsonObj.setValue("emailsender", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getEmailsender())));
			//メールタイトル
			jsonObj.setValue("emailtitle", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getEmailtitle())));
			//メールの内容
			jsonObj.setValue("emailcontent", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getEmailcontent())));
			//メール送信時刻
			jsonObj.setValue("emailsendtime", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J001JOB_DETAILEntity.getEmailsendtime())));
		}

	}

   
	/**
	 * ページの初期化
	 * @param j001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sj001Init (J001Entity j001Entity) throws Exception {

		//mode
		String mode = null;
		//txt2
		String txt2 = null;
		List<J001JOB_DETAILEntity> J001JOB_DETAILEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getMode())));
		if ("1".equals(mode)) {
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getTxt2())));
			J001JOB_DETAILEntityList = J001JOB_DETAILDao.j001InitDepthZero(txt2);
			j001pageInitValueSetByDB(J001JOB_DETAILEntityList, jsonObj);
		}
		jsonObj.setScript("r", "F20230117222830328();");
		return jsonObj;

	}
}