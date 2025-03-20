package com.wonderrobot.ankenmatchingu.service.C001;
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
import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.C001.DeleteC001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchByNameRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.dao.C001.C001PageSearchDao;

/**
 * Page Search Service
 */
@Service
public class C001PageSearchService {

	@Autowired
	private C001PageSearchDao C001PageSearchDao;



	/**
	 * 検索クエリの方法
	 * @param C001PageSearchRequestEntity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject queryC001PageSearch(C001PageSearchRequestEntity C001PageSearchRequestEntity) throws Exception {
		// Query list
		List<C001PageSearchResponseEntity> data = C001PageSearchDao.queryC001PageSearch(C001PageSearchRequestEntity.getTxt2(), C001PageSearchRequestEntity.getTxt4(), C001PageSearchRequestEntity.getTxt6(), C001PageSearchRequestEntity.getTxt8(), C001PageSearchRequestEntity.getTxt10());
		// Loop to construct mapListJson data
		ArrayList<String> mapListJson = new ArrayList<String>();
		for (C001PageSearchResponseEntity entity : data) {
			LinkedHashMap<String, String> jsonSelMap = new LinkedHashMap<String, String>();
			// id
			jsonSelMap.put("txt2", StringUtil.changeNullToBlank(entity.getTxt2()));
			// 案件ID
			jsonSelMap.put("txt4", StringUtil.changeNullToBlank(entity.getTxt4()));
			// 技術者ID
			jsonSelMap.put("txt6", StringUtil.changeNullToBlank(entity.getTxt6()));
			// コメント
			jsonSelMap.put("txt8", StringUtil.changeNullToBlank(entity.getTxt8()));
			// ステータス
			jsonSelMap.put("txt10", StringUtil.changeNullToBlank(entity.getTxt10()));
			mapListJson.add(JSONValue.toJSONString(jsonSelMap));
		}
		JSONWFCObject jsonObj = new JSONWFCObject();
		// Put the constructed json data into jsonObj
		jsonObj.setHtml("C001PageSearch", mapListJson.toString());
		return jsonObj;
	}

	/**
	 * 検索削除方法
	 * @param DeleteC001PageSearchRequestEntity
	 * @throws Exception
	 */
	@Log
	public void deleteC001PageSearch(DeleteC001PageSearchRequestEntity DeleteC001PageSearchRequestEntity) throws Exception {
		// Call delete sql 
		C001PageSearchDao.deleteC001PageSearch(DeleteC001PageSearchRequestEntity.getTxt2());
	}

}
