package com.wonderrobot.ankenmatchingu.service.S001;
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
import com.wonderrobot.ankenmatchingu.entity.S001.S001Entity;
import com.wonderrobot.ankenmatchingu.entity.S001.S001grd1Entity;
import com.wonderrobot.ankenmatchingu.dao.S001.S001Delete1GridSaveDao;
import com.wonderrobot.ankenmatchingu.dao.S001.S001Update1GridSaveDao;
import com.wonderrobot.ankenmatchingu.dao.S001.S001Insert1GridSaveDao;
/**
* class：S001saveService
 * Page：共通設定管理
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class S001saveService {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	@Autowired
	private Properties springSystemProperties;
	@Autowired
	private S001Update1GridSaveDao S001Update1GridSaveDao;
	@Autowired
	private S001Delete1GridSaveDao S001Delete1GridSaveDao;
	@Autowired
	private S001Insert1GridSaveDao S001Insert1GridSaveDao;

	/**
	 * セーブ機能を行う
	 * @param s001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sS001doSave(S001Entity s001Entity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		ArrayList<ArrayList<String>> AlKeyData = null;
		ArrayList<ArrayList<String>> alGridCount = null;
		AlKeyData = new ArrayList<ArrayList<String>>();
		int actFlg = StringUtil.changeStringToInt(s001Entity.getActflg());
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
		String FIRST_REG_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(s001Entity.getUserId())));
		String FIRST_REG_DTM = DateUtil.getPatternDateForDb();
		String LAST_UPDATE_ID = StringUtil.changeBlankToNull(StringUtil.escapeSQLTags(String.valueOf(s001Entity.getUserId())));
		String LAST_UPDATE_DTM = DateUtil.getPatternDateForDb();
		String gridOpFlg = null;
		ArrayList<S001grd1Entity> s001grd1List = new ArrayList<S001grd1Entity>();
		s001grd1List = (ArrayList<S001grd1Entity>) s001Entity.getGrid1();
		if(s001grd1List != null) {
			for(S001grd1Entity s001grd1Entity : s001grd1List) {
				gridOpFlg = s001grd1Entity.getGridOpFlag();
				String config_code = s001grd1Entity.getConfigcode();
				String description = s001grd1Entity.getDescription();
				String value = s001grd1Entity.getValue();
				String id = s001grd1Entity.getId();
				if (!StringUtil.isNullOrBlank(gridOpFlg) && "0".equals(gridOpFlg)) { 
					S001Delete1GridSaveDao.s001Delete1GridSaveData(id);
				} else if (!StringUtil.isNullOrBlank(gridOpFlg) && "1".equals(gridOpFlg)) { 
					S001Update1GridSaveDao.s001Update1GridSaveData(config_code,description,value,id,LAST_UPDATE_ID,LAST_UPDATE_DTM,id);
				}  else if (!StringUtil.isNullOrBlank(gridOpFlg) && "2".equals(gridOpFlg)) { 
					S001Insert1GridSaveDao.s001Insert1GridSaveData(config_code,description,value,id,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
				}
			}
		}
		jsonObj.setMessageValue("i", "保存が完了しました。");
		jsonObj.setValue("WF_RUNRESULT", "1");
		jsonObj.setReturnID("v", "WF_RUNRESULT");
		jsonObj.setValue("actflg", "2");
		jsonObj.setValue("mode", "1");
		jsonObj.setReturnID("v", "actflg");

		String mapToString = null;
		ArrayList<String> mapList = null;
		LinkedHashMap<String, String> selMap = null;
		mapList = new ArrayList<String>();
		if (s001grd1List != null && s001grd1List.size() > 0) {
			for (int i = 0; i < s001grd1List.size(); i++) {
				S001grd1Entity s001grd1Entity = s001grd1List.get(i);
				selMap = new LinkedHashMap<String, String>();
				if("1".equals(gridOpFlg) || "2".equals(gridOpFlg)) {
					selMap.put("configcode", StringUtil.changeNullToBlank(s001grd1Entity.getConfigcode()));
					selMap.put("description", StringUtil.changeNullToBlank(s001grd1Entity.getDescription()));
					selMap.put("value", StringUtil.changeNullToBlank(s001grd1Entity.getValue()));
					selMap.put("id", StringUtil.changeNullToBlank(s001grd1Entity.getId()));
					selMap.put("rowindex", StringUtil.changeNullToBlank(s001grd1Entity.getRowindex()));
					mapToString = JSONValue.toJSONString(selMap);
					mapList.add(mapToString);
				}
			}
		}
		jsonObj.setHtml("dragB1", mapList.toString());
		return jsonObj;
	}
}
