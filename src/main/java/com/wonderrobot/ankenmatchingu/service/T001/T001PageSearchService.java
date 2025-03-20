package com.wonderrobot.ankenmatchingu.service.T001;
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
import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.T001.DeleteT001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchByNameRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.dao.T001.T001PageSearchDao;

/**
 * Page Search Service
 */
@Service
public class T001PageSearchService {

	@Autowired
	private T001PageSearchDao T001PageSearchDao;



	/**
	 * 検索クエリの方法
	 * @param T001PageSearchRequestEntity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject queryT001PageSearch(T001PageSearchRequestEntity T001PageSearchRequestEntity) throws Exception {
		// Query list
		List<T001PageSearchResponseEntity> data = T001PageSearchDao.queryT001PageSearch(T001PageSearchRequestEntity.getTxt2(), T001PageSearchRequestEntity.getTxt8(), T001PageSearchRequestEntity.getTxt10(), T001PageSearchRequestEntity.getTxt4(), T001PageSearchRequestEntity.getTxt6());
		// Loop to construct mapListJson data
		ArrayList<String> mapListJson = new ArrayList<String>();
		for (T001PageSearchResponseEntity entity : data) {
			LinkedHashMap<String, String> jsonSelMap = new LinkedHashMap<String, String>();
			// id
			jsonSelMap.put("txt2", StringUtil.changeNullToBlank(entity.getTxt2()));
			// 備考
			jsonSelMap.put("txt8", StringUtil.changeNullToBlank(entity.getTxt8()));
			// タグコード
			jsonSelMap.put("txt10", StringUtil.changeNullToBlank(entity.getTxt10()));
			// タグ名
			jsonSelMap.put("txt4", StringUtil.changeNullToBlank(entity.getTxt4()));
			// タグタイプ
			jsonSelMap.put("txt6", StringUtil.changeNullToBlank(entity.getTxt6()));
			mapListJson.add(JSONValue.toJSONString(jsonSelMap));
		}
		JSONWFCObject jsonObj = new JSONWFCObject();
		// Put the constructed json data into jsonObj
		jsonObj.setHtml("T001PageSearch", mapListJson.toString());
		return jsonObj;
	}

	/**
	 * 検索削除方法
	 * @param DeleteT001PageSearchRequestEntity
	 * @throws Exception
	 */
	@Log
	public void deleteT001PageSearch(DeleteT001PageSearchRequestEntity DeleteT001PageSearchRequestEntity) throws Exception {
		// Call delete sql 
		T001PageSearchDao.deleteT001PageSearch(DeleteT001PageSearchRequestEntity.getTxt2());
	}

}
