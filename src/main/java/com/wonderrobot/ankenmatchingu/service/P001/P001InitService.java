package com.wonderrobot.ankenmatchingu.service.P001;
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
import com.wonderrobot.ankenmatchingu.entity.P001.P001Entity;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PEOPLE_TAGEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.P001.P001PEOPLE_TAGDao;
import com.wonderfulfly.core.util.DateUtil;
import java.text.DecimalFormat;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Init
 * 案件マッチング
 * Page: 技術者タグ
 */
@Service
public class P001InitService {
	@Autowired
	private P001PEOPLE_TAGDao P001PEOPLE_TAGDao;

   
	/**
	 * データベースを介してページを初期化する
	 * @param P001PEOPLE_TAGEntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void p001pageInitValueSetByDB (List<P001PEOPLE_TAGEntity> P001PEOPLE_TAGEntityList, JSONWFCObject jsonObj) throws Exception {

		P001PEOPLE_TAGEntity P001PEOPLE_TAGEntity = null;
		if (P001PEOPLE_TAGEntityList != null && P001PEOPLE_TAGEntityList.size() == 1) {
			P001PEOPLE_TAGEntity = P001PEOPLE_TAGEntityList.get(0);
		}
		if (P001PEOPLE_TAGEntity != null) {
			//id
			jsonObj.setValue("txt2", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getId())));
			//タグタイプ
			jsonObj.setValue("tagtype", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getTagtype())));
			//タグID
			jsonObj.setValue("tagid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getTagid())));
			//開始番号
			jsonObj.setValue("numberstart", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getNumberstart())));
			//終了番号
			jsonObj.setValue("numberend", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getNumberend())));
			//値
			jsonObj.setValue("value", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getValue())));
			//詳細ID
			jsonObj.setValue("detailid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getDetailid())));
			//タグコード
			jsonObj.setValue("tagcode", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getTagcode())));
			//メール送信時刻
			jsonObj.setValue("emailsendtime", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(P001PEOPLE_TAGEntity.getEmailsendtime())));
		}

	}

   
	/**
	 * ページの初期化
	 * @param p001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sp001Init (P001Entity p001Entity) throws Exception {

		//mode
		String mode = null;
		//txt2
		String txt2 = null;
		List<P001PEOPLE_TAGEntity> P001PEOPLE_TAGEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getMode())));
		if ("1".equals(mode)) {
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getTxt2())));
			P001PEOPLE_TAGEntityList = P001PEOPLE_TAGDao.p001InitDepthZero(txt2);
			p001pageInitValueSetByDB(P001PEOPLE_TAGEntityList, jsonObj);
		}
		return jsonObj;

	}
}