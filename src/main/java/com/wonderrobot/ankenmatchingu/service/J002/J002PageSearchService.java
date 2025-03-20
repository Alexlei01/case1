package com.wonderrobot.ankenmatchingu.service.J002;
// BasicService.vm
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;

import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.DateUtil;
import com.wonderfulfly.core.json.JSONWFCObject;

import com.wonderrobot.ankenmatchingu.aspect.Log;
import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J002.DeleteJ002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchByNameRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.dao.J002.J002PageSearchDao;

/**
 * Page Search Service
 */
@Service
public class J002PageSearchService {

	@Autowired
	private J002PageSearchDao J002PageSearchDao;



	/**
	 * 検索クエリの方法
	 * @param J002PageSearchRequestEntity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject queryJ002PageSearch(J002PageSearchRequestEntity J002PageSearchRequestEntity) throws Exception {
		// Query list
		List<J002PageSearchResponseEntity> data = J002PageSearchDao.queryJ002PageSearch(J002PageSearchRequestEntity.getTxt2(), J002PageSearchRequestEntity.getTxt4(), J002PageSearchRequestEntity.getTxt6(), J002PageSearchRequestEntity.getTxt14(), J002PageSearchRequestEntity.getTxt12(), J002PageSearchRequestEntity.getTxt8(), J002PageSearchRequestEntity.getTxt10());
		// Loop to construct mapListJson data
		ArrayList<String> mapListJson = new ArrayList<String>();
		for (J002PageSearchResponseEntity entity : data) {
			LinkedHashMap<String, String> jsonSelMap = new LinkedHashMap<String, String>();
			// id
			jsonSelMap.put("txt2", StringUtil.changeNullToBlank(entity.getTxt2()));
			// 案件ID
			jsonSelMap.put("txt4", StringUtil.changeNullToBlank(entity.getTxt4()));
			// 案件名
			jsonSelMap.put("txt6", StringUtil.changeNullToBlank(entity.getTxt6()));
			// マッチングコード
			jsonSelMap.put("txt14", StringUtil.changeNullToBlank(entity.getTxt14()));
			// マッチング率
			jsonSelMap.put("txt12", StringUtil.changeNullToBlank(entity.getTxt12()));
			// 技術者ID
			jsonSelMap.put("txt8", StringUtil.changeNullToBlank(entity.getTxt8()));
			// 技術者名
			jsonSelMap.put("txt10", StringUtil.changeNullToBlank(entity.getTxt10()));
			mapListJson.add(JSONValue.toJSONString(jsonSelMap));
		}
		JSONWFCObject jsonObj = new JSONWFCObject();
		// Put the constructed json data into jsonObj
		jsonObj.setHtml("J002PageSearch", mapListJson.toString());
		return jsonObj;
	}

	/**
	 * 検索削除方法
	 * @param DeleteJ002PageSearchRequestEntity
	 * @throws Exception
	 */
	@Log
	public void deleteJ002PageSearch(DeleteJ002PageSearchRequestEntity DeleteJ002PageSearchRequestEntity) throws Exception {
		// Call delete sql 
		J002PageSearchDao.deleteJ002PageSearch(DeleteJ002PageSearchRequestEntity.getTxt2());
	}

}
