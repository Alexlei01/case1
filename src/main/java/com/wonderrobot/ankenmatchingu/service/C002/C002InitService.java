package com.wonderrobot.ankenmatchingu.service.C002;
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
import com.wonderrobot.ankenmatchingu.entity.C002.C002Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.entity.C002.C002COMMUNICATION_RECORDEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.C002.C002COMMUNICATION_RECORDDao;
import com.wonderfulfly.core.util.DateUtil;
import java.text.DecimalFormat;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Init
 * 案件マッチング
 * Page: コミュニケーション記録
 */
@Service
public class C002InitService {
	@Autowired
	private C002COMMUNICATION_RECORDDao C002COMMUNICATION_RECORDDao;

   
	/**
	 * DropListの初期化
	 * @param c002Entity
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void c002recordTypeInit (C002Entity c002Entity, JSONWFCObject jsonObj) throws Exception {

		StringBuffer sBuffer = new StringBuffer();
		String opValue = null;
		String opText = null;
		ArrayList<String> mapList = null;
		ArrayList<String> indexList = null;
		mapList = new ArrayList<String>();
		indexList = new ArrayList<String>();
		
		opValue = StringUtil.changeNullToBlank("1");
		opText = StringUtil.changeNullToBlank("人");
		indexList.add("\""+opValue+"\"");
		mapList.add("\""+opText+"\"");
		// Assemble opValue and opText
		sBuffer.append(opValue).append("#").append(opText).append(",");
		opValue = StringUtil.changeNullToBlank("2");
		opText = StringUtil.changeNullToBlank("案件");
		indexList.add("\""+opValue+"\"");
		mapList.add("\""+opText+"\"");
		// Assemble opValue and opText
		sBuffer.append(opValue).append("#").append(opText).append(",");
		// レコードタイプ
		jsonObj.setValue("recordtype",mapList.toString());
		jsonObj.setValue("recordtype_INDEX",indexList.toString());

	}

   
	/**
	 * DropListの選択値の初期化
	 * @param selectedVaule
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void c002recordTypeInitSelected (String selectedVaule, JSONWFCObject jsonObj) throws Exception {

		// レコードタイプ
		jsonObj.setValue("recordtype_DEFAULT",StringUtil.changeNullToBlank(selectedVaule));

	}

   
	/**
	 * データベースを介してページを初期化する
	 * @param C002COMMUNICATION_RECORDEntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void c002pageInitValueSetByDB (List<C002COMMUNICATION_RECORDEntity> C002COMMUNICATION_RECORDEntityList, JSONWFCObject jsonObj) throws Exception {

		C002COMMUNICATION_RECORDEntity C002COMMUNICATION_RECORDEntity = null;
		if (C002COMMUNICATION_RECORDEntityList != null && C002COMMUNICATION_RECORDEntityList.size() == 1) {
			C002COMMUNICATION_RECORDEntity = C002COMMUNICATION_RECORDEntityList.get(0);
		}
		if (C002COMMUNICATION_RECORDEntity != null) {
			//id
			jsonObj.setValue("txt2", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C002COMMUNICATION_RECORDEntity.getId())));
			c002recordTypeInitSelected(C002COMMUNICATION_RECORDEntity.getRecordtype(), jsonObj);
			//受信者
			jsonObj.setValue("emailreceiver", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C002COMMUNICATION_RECORDEntity.getEmailreceiver())));
			//メールタイトル
			jsonObj.setValue("emailtitle", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C002COMMUNICATION_RECORDEntity.getEmailtitle())));
			//メールの内容
			jsonObj.setValue("emailcontent", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C002COMMUNICATION_RECORDEntity.getEmailcontent())));
			//送信者
			jsonObj.setValue("emailsender", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C002COMMUNICATION_RECORDEntity.getEmailsender())));
			//送信時間
			jsonObj.setValue("emailsendtime", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C002COMMUNICATION_RECORDEntity.getEmailsendtime())));
			//マッチングID
			jsonObj.setValue("matchid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C002COMMUNICATION_RECORDEntity.getMatchid())));
			//コミュニケーションID
			jsonObj.setValue("txt26", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C002COMMUNICATION_RECORDEntity.getCid())));
		}

	}

   
	/**
	 * ページの初期化
	 * @param c002Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sc002Init (C002Entity c002Entity) throws Exception {

		//mode
		String mode = null;
		//txt2
		String txt2 = null;
		List<C002COMMUNICATION_RECORDEntity> C002COMMUNICATION_RECORDEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		c002recordTypeInit(c002Entity, jsonObj);
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getMode())));
		if ("1".equals(mode)) {
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getTxt2())));
			C002COMMUNICATION_RECORDEntityList = C002COMMUNICATION_RECORDDao.c002InitDepthZero(txt2);
			c002pageInitValueSetByDB(C002COMMUNICATION_RECORDEntityList, jsonObj);
		}
		return jsonObj;

	}
}