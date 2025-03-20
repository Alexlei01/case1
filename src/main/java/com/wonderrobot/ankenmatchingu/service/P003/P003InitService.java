package com.wonderrobot.ankenmatchingu.service.P003;
// ControllerFormat.java
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.wonderfulfly.core.util.log.LoggerUtil;
import javax.servlet.http.HttpSession;

import com.wonderrobot.ankenmatchingu.entity.P003.P003PEOPLE_DETAILEntity;
import com.wonderrobot.ankenmatchingu.entity.ParamEntity;
import com.wonderrobot.ankenmatchingu.entity.S001.S001sms6grd1SmartSearchEntity;
import com.wonderrobot.ankenmatchingu.mapper.P003.P003PEOPLE_DETAILMapper;
import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.StringUtil;
import org.springframework.transaction.annotation.Transactional;
import com.wonderrobot.ankenmatchingu.entity.P003.P003Entity;
import com.wonderrobot.ankenmatchingu.aspect.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * Page Init
 * 案件マッチング
 * Page: 技術者一覧
 */
@Service
public class P003InitService {


	@Resource
	P003PEOPLE_DETAILMapper p003PEOPLEDetailMapper;

	/**
	 * 初期化フォーム
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void p003grd2pageInitGrid (JSONWFCObject jsonObj) throws Exception {

		jsonObj.setHtml("dragB2", null);

	}

   
	/**
	 * ページの初期化
	 * @param p003Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject sp003Init (P003Entity p003Entity) throws Exception {

		//mode
		String mode = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p003Entity.getMode())));
		if ("1".equals(mode)) {
			p003grd2pageInitGrid(jsonObj);
		}
		return jsonObj;

	}


	/**
	 * 模拟查询
	 * @param paramEntity
	 * @return
	 */
	public JSONWFCObject smartSearch(ParamEntity paramEntity) {
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
		configCode1 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(paramEntity.getConfigcode1())));
		value1 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(paramEntity.getValue1())));
		desc1 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(paramEntity.getDesc1())));
		description1 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(paramEntity.getDescription1())));

		List<P003PEOPLE_DETAILEntity> p003PEOPLEDetailEntities = p003PEOPLEDetailMapper.smartSearch(paramEntity.getEmailsendtimestart(),
				paramEntity.getInterviewtimeend(),
				paramEntity.getEntrytimestart(),
				paramEntity.getEntrytimeend(),
				paramEntity.getEmailsendtimestart(),
				paramEntity.getEmailsendtimeend(),
				paramEntity.getTxt10());

		mapList = new ArrayList<String>();
		if (p003PEOPLEDetailEntities != null && p003PEOPLEDetailEntities.size() > 0) {
			for (int i = 0;i < p003PEOPLEDetailEntities.size();i++) {
				P003PEOPLE_DETAILEntity p003PEOPLEDetailEntity = p003PEOPLEDetailEntities.get(i);
				selMap = new LinkedHashMap<String, String>();
				selMap.put("id", StringUtil.changeNullToBlank(p003PEOPLEDetailEntity.getId()));
				selMap.put("emailsender", StringUtil.changeNullToBlank(p003PEOPLEDetailEntity.getEmailsender()));
				selMap.put("emailtitle", StringUtil.changeNullToBlank(p003PEOPLEDetailEntity.getEmailtitle()));
				selMap.put("emailsendtime", StringUtil.changeNullToBlank(p003PEOPLEDetailEntity.getEmailsendtime()));
				mapToString = JSONValue.toJSONString(selMap);
				mapList.add(mapToString);
			}
		}
		jsonObj.setHtml("P003PageSearch", mapList.toString());

		return jsonObj;
	}
}