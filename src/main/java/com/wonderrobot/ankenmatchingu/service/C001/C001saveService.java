package com.wonderrobot.ankenmatchingu.service.C001;
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
import com.wonderrobot.ankenmatchingu.entity.C001.C001Entity;
import com.wonderrobot.ankenmatchingu.dao.C001.C001InsertSaveDao;
import com.wonderrobot.ankenmatchingu.dao.C001.C001UpdateSaveDao;
/**
* class：C001saveService
 * Page：コミュニケーション
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class C001saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private C001InsertSaveDao C001InsertSaveDao;
	@Autowired
	private C001UpdateSaveDao C001UpdateSaveDao;

	/**
	 * セーブ機能を行う
	 * @param c001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sC001doSave(C001Entity c001Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(c001Entity.getActflg());
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
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c001Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c001Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		// id
		String id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c001Entity.getTxt2())));
		AlKeyData.add(new ArrayList<String>(Arrays.asList(new String[] { "txt2" , id })));
		// 案件ID
		String job_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c001Entity.getJobid())));
		// 技術者ID
		String people_id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c001Entity.getPeopleid())));
		// コメント
		String remark = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c001Entity.getRemark())));
		// ステータス
		String status = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(c001Entity.getStatus())));
		if (pageActionMode.equals("2")) {
			// Insert data to db.
			C001InsertSaveDao.c001InsertSaveData(id,job_id,people_id,remark,status,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		} else if (pageActionMode.equals("1")) {
			// Update data to db.
			C001UpdateSaveDao.c001UpdateSaveData(id,job_id,people_id,remark,status,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
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
