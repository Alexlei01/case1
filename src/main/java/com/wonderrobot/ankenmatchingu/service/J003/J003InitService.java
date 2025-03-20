package com.wonderrobot.ankenmatchingu.service.J003;
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
import com.wonderrobot.ankenmatchingu.entity.J003.J003Entity;
import com.wonderrobot.ankenmatchingu.entity.J003.J003JOB_TAGEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.J003.J003JOB_TAGDao;
import com.wonderfulfly.core.util.DateUtil;
import java.text.DecimalFormat;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Init
 * 案件マッチング
 * Page: 案件タグ
 */
@Service
public class J003InitService {
	@Autowired
	private J003JOB_TAGDao J003JOB_TAGDao;

   
	/**
	 * データベースを介してページを初期化する
	 * @param J003JOB_TAGEntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void j003pageInitValueSetByDB (List<J003JOB_TAGEntity> J003JOB_TAGEntityList, JSONWFCObject jsonObj) throws Exception {

		J003JOB_TAGEntity J003JOB_TAGEntity = null;
		if (J003JOB_TAGEntityList != null && J003JOB_TAGEntityList.size() == 1) {
			J003JOB_TAGEntity = J003JOB_TAGEntityList.get(0);
		}
		if (J003JOB_TAGEntity != null) {
			//id
			jsonObj.setValue("txt2", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getId())));
			//タグタイプ
			jsonObj.setValue("tagtype", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getTagtype())));
			//タグID
			jsonObj.setValue("tagid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getTagid())));
			//開始番号
			jsonObj.setValue("numberstart", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getNumberstart())));
			//終了番号
			jsonObj.setValue("numberend", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getNumberend())));
			//値
			jsonObj.setValue("value", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getValue())));
			//詳細ID
			jsonObj.setValue("detailid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getDetailid())));
			//タグコード
			jsonObj.setValue("tagcode", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getTagcode())));
			//メール送信時刻
			jsonObj.setValue("emailsendtime", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J003JOB_TAGEntity.getEmailsendtime())));
		}

	}

   
	/**
	 * ページの初期化
	 * @param j003Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sj003Init (J003Entity j003Entity) throws Exception {

		//mode
		String mode = null;
		//txt2
		String txt2 = null;
		List<J003JOB_TAGEntity> J003JOB_TAGEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j003Entity.getMode())));
		if ("1".equals(mode)) {
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j003Entity.getTxt2())));
			J003JOB_TAGEntityList = J003JOB_TAGDao.j003InitDepthZero(txt2);
			j003pageInitValueSetByDB(J003JOB_TAGEntityList, jsonObj);
		}
		return jsonObj;

	}
}