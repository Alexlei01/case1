package com.wonderrobot.ankenmatchingu.service.J002;
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
import com.wonderrobot.ankenmatchingu.entity.J002.J002Entity;
import com.wonderrobot.ankenmatchingu.entity.J002.J002JOB_MATCHEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.J002.J002JOB_MATCHDao;
import com.wonderfulfly.core.util.DateUtil;
import java.text.DecimalFormat;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Init
 * 案件マッチング
 * Page: 案件マッチング
 */
@Service
public class J002InitService {
	@Autowired
	private J002JOB_MATCHDao J002JOB_MATCHDao;

   
	/**
	 * データベースを介してページを初期化する
	 * @param J002JOB_MATCHEntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void j002pageInitValueSetByDB (List<J002JOB_MATCHEntity> J002JOB_MATCHEntityList, JSONWFCObject jsonObj) throws Exception {

		J002JOB_MATCHEntity J002JOB_MATCHEntity = null;
		if (J002JOB_MATCHEntityList != null && J002JOB_MATCHEntityList.size() == 1) {
			J002JOB_MATCHEntity = J002JOB_MATCHEntityList.get(0);
		}
		if (J002JOB_MATCHEntity != null) {
			//id
			jsonObj.setValue("txt2", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J002JOB_MATCHEntity.getId())));
			//案件ID
			jsonObj.setValue("jobid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J002JOB_MATCHEntity.getJobid())));
			//案件名
			jsonObj.setValue("jobname", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J002JOB_MATCHEntity.getJobname())));
			//技術者ID
			jsonObj.setValue("peopleid", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J002JOB_MATCHEntity.getPeopleid())));
			//技術者名
			jsonObj.setValue("peoplename", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J002JOB_MATCHEntity.getPeoplename())));
			//マッチング率
			jsonObj.setValue("matchpercent", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J002JOB_MATCHEntity.getMatchpercent())));
			//マッチングコード
			jsonObj.setValue("matchcode", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(J002JOB_MATCHEntity.getMatchcode())));
		}

	}

   
	/**
	 * ページの初期化
	 * @param j002Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sj002Init (J002Entity j002Entity) throws Exception {

		//mode
		String mode = null;
		//txt2
		String txt2 = null;
		List<J002JOB_MATCHEntity> J002JOB_MATCHEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getMode())));
		if ("1".equals(mode)) {
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getTxt2())));
			J002JOB_MATCHEntityList = J002JOB_MATCHDao.j002InitDepthZero(txt2);
			j002pageInitValueSetByDB(J002JOB_MATCHEntityList, jsonObj);
		}
		return jsonObj;

	}
}