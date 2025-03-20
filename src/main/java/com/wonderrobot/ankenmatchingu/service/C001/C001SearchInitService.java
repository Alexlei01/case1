package com.wonderrobot.ankenmatchingu.service.C001;
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
import com.wonderrobot.ankenmatchingu.entity.C001.C001Entity;
import com.wonderrobot.ankenmatchingu.entity.C001.C001COMMUNICATIONEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.C001.C001COMMUNICATIONDao;
import com.wonderfulfly.core.util.DateUtil;
import java.text.DecimalFormat;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Search Init
 * 案件マッチング
 * Page: コミュニケーション
 */
@Service
public class C001SearchInitService {
	@Autowired
	private C001COMMUNICATIONDao C001COMMUNICATIONDao;

   
	/**
	 * 標準検索の初期化
	 * @param null
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void c001pageInitValueSetByDB (List<C001COMMUNICATIONEntity> C001COMMUNICATIONEntityList, JSONWFCObject jsonObj) throws Exception {

		C001COMMUNICATIONEntity C001COMMUNICATIONEntity = null;
		if (C001COMMUNICATIONEntityList != null && C001COMMUNICATIONEntityList.size() == 1) {
			C001COMMUNICATIONEntity = C001COMMUNICATIONEntityList.get(0);
		}
		if (C001COMMUNICATIONEntity != null) {
			//id
			jsonObj.setValue("txt2", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C001COMMUNICATIONEntity.getId())));
			//案件ID
			jsonObj.setValue("jobid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C001COMMUNICATIONEntity.getJobid())));
			//技術者ID
			jsonObj.setValue("peopleid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C001COMMUNICATIONEntity.getPeopleid())));
			//コメント
			jsonObj.setValue("remark", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C001COMMUNICATIONEntity.getRemark())));
			//ステータス
			jsonObj.setValue("status", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(C001COMMUNICATIONEntity.getStatus())));
		}

	}

   
	/**
	 * 標準検索の初期化
	 * @param C001COMMUNICATIONEntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sc001SearchInit (C001Entity c001Entity) throws Exception {

		//mode
		String mode = null;
		//txt2
		String txt2 = null;
		List<C001COMMUNICATIONEntity> C001COMMUNICATIONEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getMode())));
		if ("1".equals(mode)) {
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getTxt2())));
			C001COMMUNICATIONEntityList = C001COMMUNICATIONDao.c001SearchInitDepthZero(txt2);
			c001pageInitValueSetByDB(C001COMMUNICATIONEntityList, jsonObj);
		}
		return jsonObj;

	}
}