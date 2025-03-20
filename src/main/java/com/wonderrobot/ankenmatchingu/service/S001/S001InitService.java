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
import com.wonderrobot.ankenmatchingu.entity.S001.S001grd1SYS_CONFIGEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.S001.S001grd1SYS_CONFIGDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.simple.JSONValue;
import com.wonderrobot.ankenmatchingu.dao.S001.S001SYS_CONFIGDao;
import com.wonderrobot.ankenmatchingu.entity.S001.S001SYS_CONFIGEntity;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Init
 * 案件マッチング
 * Page: 共通設定管理
 */
@Service
public class S001InitService {
	@Autowired
	private S001grd1SYS_CONFIGDao S001grd1SYS_CONFIGDao;
	@Autowired
	private S001SYS_CONFIGDao S001SYS_CONFIGDao;

   
	/**
	 * データベースを介してテーブルを初期化する
	 * @param S0011EntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void s001grd1pageInitGridValueSetByDB (List<S001grd1SYS_CONFIGEntity> S001grd1SYS_CONFIGEntityList, JSONWFCObject jsonObj) throws Exception {

		
		
		String mapToString = null;
		
		
		ArrayList<String> mapList = null;
		
		
		LinkedHashMap<String, String> selMap = null;
		
		 mapList = new ArrayList<String>();
		if (S001grd1SYS_CONFIGEntityList != null && S001grd1SYS_CONFIGEntityList.size() > 0) {
			for (int i = 0;i < S001grd1SYS_CONFIGEntityList.size();i++) {
				S001grd1SYS_CONFIGEntity S001grd1SYS_CONFIGEntity_i = S001grd1SYS_CONFIGEntityList.get(i);
				selMap = new LinkedHashMap<String, String>();
				selMap.put("configcode", StringUtil.changeNullToBlank(S001grd1SYS_CONFIGEntity_i.getConfigcode()));
				selMap.put("description", StringUtil.changeNullToBlank(S001grd1SYS_CONFIGEntity_i.getDescription()));
				selMap.put("value", StringUtil.changeNullToBlank(S001grd1SYS_CONFIGEntity_i.getValue()));
				selMap.put("id", StringUtil.changeNullToBlank(S001grd1SYS_CONFIGEntity_i.getId()));
				mapToString = JSONValue.toJSONString(selMap);
				mapList.add(mapToString);
			}
		}
		jsonObj.setHtml("dragB1", mapList.toString());

	}

   
	/**
	 * ページの初期化
	 * @param s001Entity
	 * @return json data
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject ss001Init (S001Entity s001Entity) throws Exception {

		//mode
		String mode = null;
		List<S001grd1SYS_CONFIGEntity> S001grd1SYS_CONFIGEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(s001Entity.getMode())));
		if ("".equals(mode) || StringUtil.isNullOrBlank(mode)) {
			mode = "1";
		}
		if ("1".equals(mode)) {
			S001grd1SYS_CONFIGEntityList = S001grd1SYS_CONFIGDao.s001InitGrid();
		}
		s001grd1pageInitGridValueSetByDB(S001grd1SYS_CONFIGEntityList, jsonObj);
		return jsonObj;

	}
}