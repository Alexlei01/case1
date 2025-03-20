package com.wonderrobot.ankenmatchingu.service.S001;
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
import com.wonderrobot.ankenmatchingu.entity.S001.S001Entity;
import com.wonderrobot.ankenmatchingu.entity.S001.S001sms6grd1SmartSearchEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.S001.S001sms6grd1SmartSearchDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.simple.JSONValue;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Smart Search Service
 * 案件マッチング
 * Page: 共通設定管理
 */
@Service
public class S001sms6grd1SmartSearchService {
	@Autowired
	private S001sms6grd1SmartSearchDao S001sms6grd1SmartSearchDao;

   
	/**
	 * Smart検索の初期化
	 * @param s001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sS001sms6grd1SmartSearch (S001Entity s001Entity) throws Exception {

		//configCode1
		String configCode1 = null;
		//value1
		String value1 = null;
		//desc1
		String desc1 = null;
		//description1
		String description1 = null;
		List<S001sms6grd1SmartSearchEntity> S001sms6grd1SmartSearchEntityList = null;
		
		
		String mapToString = null;
		
		
		ArrayList<String> mapList = null;
		
		
		LinkedHashMap<String, String> selMap = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		configCode1 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(s001Entity.getConfigcode1())));
		value1 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(s001Entity.getValue1())));
		desc1 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(s001Entity.getDesc1())));
		description1 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(s001Entity.getDescription1())));
		S001sms6grd1SmartSearchEntityList = S001sms6grd1SmartSearchDao.s001sms6grd1SmartSearch(configCode1, value1, desc1, description1);
		
		 mapList = new ArrayList<String>();
		if (S001sms6grd1SmartSearchEntityList != null && S001sms6grd1SmartSearchEntityList.size() > 0) {
			for (int i = 0;i < S001sms6grd1SmartSearchEntityList.size();i++) {
				S001sms6grd1SmartSearchEntity S001sms6grd1SmartSearchEntity_i = S001sms6grd1SmartSearchEntityList.get(i);
				selMap = new LinkedHashMap<String, String>();
				selMap.put("id", StringUtil.changeNullToBlank(S001sms6grd1SmartSearchEntity_i.getA1id()));
				selMap.put("configcode", StringUtil.changeNullToBlank(S001sms6grd1SmartSearchEntity_i.getA1configcode()));
				selMap.put("value", StringUtil.changeNullToBlank(S001sms6grd1SmartSearchEntity_i.getA1value()));
				selMap.put("description", StringUtil.changeNullToBlank(S001sms6grd1SmartSearchEntity_i.getA1description()));
				mapToString = JSONValue.toJSONString(selMap);
				mapList.add(mapToString);
			}
		}
		jsonObj.setHtml("dragB1", mapList.toString());
		
		return jsonObj;

	}
}