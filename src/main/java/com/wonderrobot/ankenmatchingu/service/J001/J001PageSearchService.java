package com.wonderrobot.ankenmatchingu.service.J001;
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
import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J001.DeleteJ001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchByNameRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.dao.J001.J001PageSearchDao;

/**
 * Page Search Service
 */
@Service
public class J001PageSearchService {

	@Autowired
	private J001PageSearchDao J001PageSearchDao;



	/**
	 * 検索クエリの方法
	 * @param J001PageSearchRequestEntity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject queryJ001PageSearch(J001PageSearchRequestEntity J001PageSearchRequestEntity) throws Exception {
		// Query list
		List<J001PageSearchResponseEntity> data = J001PageSearchDao.queryJ001PageSearch(J001PageSearchRequestEntity.getTxt24(), J001PageSearchRequestEntity.getTxt28(), J001PageSearchRequestEntity.getTxt2(), J001PageSearchRequestEntity.getTxt12());
		// Loop to construct mapListJson data
		ArrayList<String> mapListJson = new ArrayList<String>();
		for (J001PageSearchResponseEntity entity : data) {
			LinkedHashMap<String, String> jsonSelMap = new LinkedHashMap<String, String>();
			// 送信者
			jsonSelMap.put("txt24", StringUtil.changeNullToBlank(entity.getTxt24()));
			// メールタイトル
			jsonSelMap.put("txt28", StringUtil.changeNullToBlank(entity.getTxt28()));
			// id
			jsonSelMap.put("txt2", StringUtil.changeNullToBlank(entity.getTxt2()));
			// 募集要員
			jsonSelMap.put("txt12", StringUtil.changeNullToBlank(entity.getTxt12()));
			mapListJson.add(JSONValue.toJSONString(jsonSelMap));
		}
		JSONWFCObject jsonObj = new JSONWFCObject();
		// Put the constructed json data into jsonObj
		jsonObj.setHtml("J001PageSearch", mapListJson.toString());
		return jsonObj;
	}

	/**
	 * 検索削除方法
	 * @param DeleteJ001PageSearchRequestEntity
	 * @throws Exception
	 */
	@Log
	public void deleteJ001PageSearch(DeleteJ001PageSearchRequestEntity DeleteJ001PageSearchRequestEntity) throws Exception {
		// Call delete sql 
		J001PageSearchDao.deleteJ001PageSearch(DeleteJ001PageSearchRequestEntity.getTxt2());
	}

}
