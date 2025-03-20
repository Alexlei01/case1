package com.wonderrobot.ankenmatchingu.service.P002;
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
import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.P002.DeleteP002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchByNameRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.dao.P002.P002PageSearchDao;

/**
 * Page Search Service
 */
@Service
public class P002PageSearchService {

	@Autowired
	private P002PageSearchDao P002PageSearchDao;



	/**
	 * 検索クエリの方法
	 * @param P002PageSearchRequestEntity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject queryP002PageSearch(P002PageSearchRequestEntity P002PageSearchRequestEntity) throws Exception {
		// Query list
		List<P002PageSearchResponseEntity> data = P002PageSearchDao.queryP002PageSearch(P002PageSearchRequestEntity.getTxt40(), P002PageSearchRequestEntity.getTxt42(), P002PageSearchRequestEntity.getTxt2());
		// Loop to construct mapListJson data
		ArrayList<String> mapListJson = new ArrayList<String>();
		for (P002PageSearchResponseEntity entity : data) {
			LinkedHashMap<String, String> jsonSelMap = new LinkedHashMap<String, String>();
			// メール送信時刻
			jsonSelMap.put("txt40", StringUtil.changeNullToBlank(entity.getTxt40()));
			// メールタイトル
			jsonSelMap.put("txt42", StringUtil.changeNullToBlank(entity.getTxt42()));
			// id
			jsonSelMap.put("txt2", StringUtil.changeNullToBlank(entity.getTxt2()));
			mapListJson.add(JSONValue.toJSONString(jsonSelMap));
		}
		JSONWFCObject jsonObj = new JSONWFCObject();
		// Put the constructed json data into jsonObj
		jsonObj.setHtml("P002PageSearch", mapListJson.toString());
		return jsonObj;
	}

	/**
	 * 検索削除方法
	 * @param DeleteP002PageSearchRequestEntity
	 * @throws Exception
	 */
	@Log
	public void deleteP002PageSearch(DeleteP002PageSearchRequestEntity DeleteP002PageSearchRequestEntity) throws Exception {
		// Call delete sql 
		P002PageSearchDao.deleteP002PageSearch(DeleteP002PageSearchRequestEntity.getTxt2());
	}

}
