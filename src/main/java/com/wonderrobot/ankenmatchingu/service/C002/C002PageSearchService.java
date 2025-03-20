package com.wonderrobot.ankenmatchingu.service.C002;
// BasicService.vm
import java.text.DateFormat;
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
import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.C002.DeleteC002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchByNameRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.dao.C002.C002PageSearchDao;

/**
 * Page Search Service
 */
@Service
public class C002PageSearchService {

	@Autowired
	private C002PageSearchDao C002PageSearchDao;



	/**
	 * 検索クエリの方法
	 * @param C002PageSearchRequestEntity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject queryC002PageSearch(C002PageSearchRequestEntity C002PageSearchRequestEntity) throws Exception {
		// Query list
		List<C002PageSearchResponseEntity> data = C002PageSearchDao.queryC002PageSearch(C002PageSearchRequestEntity.getTxt10(), C002PageSearchRequestEntity.getTxt6(), C002PageSearchRequestEntity.getTxt12(), C002PageSearchRequestEntity.getTxt14(), C002PageSearchRequestEntity.getTxt8());
		// Loop to construct mapListJson data
		ArrayList<String> mapListJson = new ArrayList<String>();
		for (C002PageSearchResponseEntity entity : data) {
			LinkedHashMap<String, String> jsonSelMap = new LinkedHashMap<String, String>();
			// メールの内容
			jsonSelMap.put("txt10", StringUtil.changeNullToBlank(entity.getTxt10()));
			// 受信者
			jsonSelMap.put("txt6", StringUtil.changeNullToBlank(entity.getTxt6()));
			// 送信者
			jsonSelMap.put("txt12", StringUtil.changeNullToBlank(entity.getTxt12()));
			// 送信時間
			// 格式化时间
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String txt14 = entity.getTxt14();
			Date parse = sf.parse(txt14);
			String format = simpleDateFormat.format(parse);
			jsonSelMap.put("txt14", StringUtil.changeNullToBlank(format));
			// メールタイトル
			jsonSelMap.put("txt8", StringUtil.changeNullToBlank(entity.getTxt8()));
			// id
			jsonSelMap.put("txt2", StringUtil.changeNullToBlank(entity.getTxt2()));
			mapListJson.add(JSONValue.toJSONString(jsonSelMap));
		}
		JSONWFCObject jsonObj = new JSONWFCObject();
		// Put the constructed json data into jsonObj
		jsonObj.setHtml("C002PageSearch", mapListJson.toString());
		return jsonObj;
	}

	/**
	 * 検索削除方法
	 * @param DeleteC002PageSearchRequestEntity
	 * @throws Exception
	 */
	@Log
	public void deleteC002PageSearch(DeleteC002PageSearchRequestEntity DeleteC002PageSearchRequestEntity) throws Exception {
		// Call delete sql 
		C002PageSearchDao.deleteC002PageSearch(DeleteC002PageSearchRequestEntity.getTxt2());
	}

}
