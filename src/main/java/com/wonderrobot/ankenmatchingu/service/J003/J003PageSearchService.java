package com.wonderrobot.ankenmatchingu.service.J003;
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
import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J003.DeleteJ003PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchByNameRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.dao.J003.J003PageSearchDao;

/**
 * Page Search Service
 */
@Service
public class J003PageSearchService {

	@Autowired
	private J003PageSearchDao J003PageSearchDao;



	/**
	 * 検索クエリの方法
	 * @param J003PageSearchRequestEntity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject queryJ003PageSearch(J003PageSearchRequestEntity J003PageSearchRequestEntity) throws Exception {
		// Query list
		List<J003PageSearchResponseEntity> data = J003PageSearchDao.queryJ003PageSearch(J003PageSearchRequestEntity.getTxt14(), J003PageSearchRequestEntity.getTxt18(), J003PageSearchRequestEntity.getTxt2(), J003PageSearchRequestEntity.getTxt10(), J003PageSearchRequestEntity.getTxt8(), J003PageSearchRequestEntity.getTxt16(), J003PageSearchRequestEntity.getTxt6(), J003PageSearchRequestEntity.getTxt4(), J003PageSearchRequestEntity.getTxt12());
		// Loop to construct mapListJson data
		ArrayList<String> mapListJson = new ArrayList<String>();
		for (J003PageSearchResponseEntity entity : data) {
			LinkedHashMap<String, String> jsonSelMap = new LinkedHashMap<String, String>();
			// 詳細ID
			jsonSelMap.put("txt14", StringUtil.changeNullToBlank(entity.getTxt14()));
			// メール送信時刻
			jsonSelMap.put("txt18", StringUtil.changeNullToBlank(entity.getTxt18()));
			// id
			jsonSelMap.put("txt2", StringUtil.changeNullToBlank(entity.getTxt2()));
			// 終了番号
			jsonSelMap.put("txt10", StringUtil.changeNullToBlank(entity.getTxt10()));
			// 開始番号
			jsonSelMap.put("txt8", StringUtil.changeNullToBlank(entity.getTxt8()));
			// タグコード
			jsonSelMap.put("txt16", StringUtil.changeNullToBlank(entity.getTxt16()));
			// タグID
			jsonSelMap.put("txt6", StringUtil.changeNullToBlank(entity.getTxt6()));
			// タグタイプ
			jsonSelMap.put("txt4", StringUtil.changeNullToBlank(entity.getTxt4()));
			// 値
			jsonSelMap.put("txt12", StringUtil.changeNullToBlank(entity.getTxt12()));
			mapListJson.add(JSONValue.toJSONString(jsonSelMap));
		}
		JSONWFCObject jsonObj = new JSONWFCObject();
		// Put the constructed json data into jsonObj
		jsonObj.setHtml("J003PageSearch", mapListJson.toString());
		return jsonObj;
	}

	/**
	 * 検索削除方法
	 * @param DeleteJ003PageSearchRequestEntity
	 * @throws Exception
	 */
	@Log
	public void deleteJ003PageSearch(DeleteJ003PageSearchRequestEntity DeleteJ003PageSearchRequestEntity) throws Exception {
		// Call delete sql 
		J003PageSearchDao.deleteJ003PageSearch(DeleteJ003PageSearchRequestEntity.getTxt2());
	}

}
