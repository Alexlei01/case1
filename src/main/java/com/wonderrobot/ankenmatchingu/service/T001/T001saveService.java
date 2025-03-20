package com.wonderrobot.ankenmatchingu.service.T001;
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
import com.wonderrobot.ankenmatchingu.entity.T001.T001Entity;
import com.wonderrobot.ankenmatchingu.dao.T001.T001InsertSaveDao;
import com.wonderrobot.ankenmatchingu.dao.T001.T001UpdateSaveDao;
/**
* class：T001saveService
 * Page：タグ管理
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class T001saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private T001InsertSaveDao T001InsertSaveDao;
	@Autowired
	private T001UpdateSaveDao T001UpdateSaveDao;

	/**
	 * セーブ機能を行う
	 * @param t001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sT001doSave(T001Entity t001Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(t001Entity.getActflg());
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
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(t001Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(t001Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		// id
		String id = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(t001Entity.getTxt2())));
		AlKeyData.add(new ArrayList<String>(Arrays.asList(new String[] { "txt2" , id })));
		// タグ名
		String tag_name = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(t001Entity.getTagname())));
		// タグタイプ
		String tag_type = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(t001Entity.getTagtype())));
		// 備考
		String remark = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(t001Entity.getRemark())));
		// タグコード
		String tag_code = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(t001Entity.getTagcode())));
		if (pageActionMode.equals("2")) {
			// Insert data to db.
			T001InsertSaveDao.t001InsertSaveData(id,tag_name,tag_type,remark,tag_code,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		} else if (pageActionMode.equals("1")) {
			// Update data to db.
			T001UpdateSaveDao.t001UpdateSaveData(id,tag_name,tag_type,remark,tag_code,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
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
