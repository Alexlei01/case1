package com.wonderrobot.ankenmatchingu.service.P001;
// BasicService.vm
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;

import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.DateUtil;
import com.wonderfulfly.core.json.JSONWFCObject;

import com.wonderrobot.ankenmatchingu.aspect.Log;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.P001.DeleteP001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchByNameRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.dao.P001.P001PageSearchDao;

/**
 * Page Search Service
 */
@Service
public class P001PageSearchService {

	@Autowired
	private P001PageSearchDao P001PageSearchDao;



	/**
	 * 検索クエリの方法
	 * @param P001PageSearchRequestEntity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject queryP001PageSearch(P001PageSearchRequestEntity P001PageSearchRequestEntity) throws Exception {
		// Query list
		List<P001PageSearchResponseEntity> data = P001PageSearchDao.queryP001PageSearch(P001PageSearchRequestEntity.getTxt14(), P001PageSearchRequestEntity.getTxt18(), P001PageSearchRequestEntity.getTxt2(), P001PageSearchRequestEntity.getTxt10(), P001PageSearchRequestEntity.getTxt8(), P001PageSearchRequestEntity.getTxt16(), P001PageSearchRequestEntity.getTxt6(), P001PageSearchRequestEntity.getTxt4(), P001PageSearchRequestEntity.getTxt12());
		// Loop to construct mapListJson data
		ArrayList<String> mapListJson = new ArrayList<String>();
		for (P001PageSearchResponseEntity entity : data) {
			LinkedHashMap<String, String> jsonSelMap = new LinkedHashMap<String, String>();
			// 詳細ID
			jsonSelMap.put("txt14", StringUtil.changeNullToBlank(entity.getTxt14()));

			// メール送信時刻
			// 格式化时间
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String txt18 = entity.getTxt18();
			Date parse = sf.parse(txt18);
			String format = simpleDateFormat.format(parse);
			jsonSelMap.put("txt18", StringUtil.changeNullToBlank(format));
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
		jsonObj.setHtml("P001PageSearch", mapListJson.toString());
		return jsonObj;
	}

	/**
	 * 検索削除方法
	 * @param DeleteP001PageSearchRequestEntity
	 * @throws Exception
	 */
	@Log
	public void deleteP001PageSearch(DeleteP001PageSearchRequestEntity DeleteP001PageSearchRequestEntity) throws Exception {
		// Call delete sql 
		P001PageSearchDao.deleteP001PageSearch(DeleteP001PageSearchRequestEntity.getTxt2());
	}

}
