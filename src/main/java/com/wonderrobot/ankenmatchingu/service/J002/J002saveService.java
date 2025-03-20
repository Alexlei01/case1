package com.wonderrobot.ankenmatchingu.service.J002;
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
import com.wonderrobot.ankenmatchingu.entity.J002.J002Entity;
import com.wonderrobot.ankenmatchingu.dao.J002.J002InsertSaveDao;
import com.wonderrobot.ankenmatchingu.dao.J002.J002UpdateSaveDao;
/**
* class：J002saveService
 * Page：案件マッチング
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class J002saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private J002InsertSaveDao J002InsertSaveDao;
	@Autowired
	private J002UpdateSaveDao J002UpdateSaveDao;

	/**
	 * セーブ機能を行う
	 * @param j002Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sJ002doSave(J002Entity j002Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(j002Entity.getActflg());
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
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		// id
		String id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getTxt2())));
		AlKeyData.add(new ArrayList<String>(Arrays.asList(new String[] { "txt2" , id })));
		// 案件ID
		String job_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getJobid())));
		// 案件名
		String job_name = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getJobname())));
		// 技術者ID
		String people_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getPeopleid())));
		// 技術者名
		String people_name = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getPeoplename())));
		// マッチング率
		String match_percent = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getMatchpercent())));
		// マッチングコード
		String match_code = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(j002Entity.getMatchcode())));
		if (pageActionMode.equals("2")) {
			// Insert data to db.
			J002InsertSaveDao.j002InsertSaveData(id,job_id,job_name,people_id,people_name,match_percent,match_code,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		} else if (pageActionMode.equals("1")) {
			// Update data to db.
			J002UpdateSaveDao.j002UpdateSaveData(id,job_id,job_name,people_id,people_name,match_percent,match_code,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
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
