package com.wonderrobot.ankenmatchingu.service.T001;
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
import com.wonderrobot.ankenmatchingu.entity.T001.T001Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.entity.T001.T001TAGEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.dao.T001.T001TAGDao;
import com.wonderfulfly.core.util.DateUtil;
import java.text.DecimalFormat;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page Search Init
 * 案件マッチング
 * Page: タグ管理
 */
@Service
public class T001SearchInitService {
	@Autowired
	private T001TAGDao T001TAGDao;

   
	/**
	 * DropListの初期化
	 * @param t001Entity
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void t001tagNameInit (T001Entity t001Entity, JSONWFCObject jsonObj) throws Exception {

		StringBuffer sBuffer = new StringBuffer();
		String opValue = null;
		String opText = null;
		ArrayList<String> mapList = null;
		ArrayList<String> indexList = null;
		mapList = new ArrayList<String>();
		indexList = new ArrayList<String>();
		
		opValue = StringUtil.changeNullToBlank("0");
		opText = StringUtil.changeNullToBlank("時間範囲");
		indexList.add("\""+opValue+"\"");
		mapList.add("\""+opText+"\"");
		// Assemble opValue and opText
		sBuffer.append(opValue).append("#").append(opText).append(",");
		opValue = StringUtil.changeNullToBlank("1");
		opText = StringUtil.changeNullToBlank("数値範囲");
		indexList.add("\""+opValue+"\"");
		mapList.add("\""+opText+"\"");
		// Assemble opValue and opText
		sBuffer.append(opValue).append("#").append(opText).append(",");
		// タグ名
		jsonObj.setValue("tagname",mapList.toString());
		jsonObj.setValue("tagname_INDEX",indexList.toString());

	}

   
	/**
	 * DropListの選択値の初期化
	 * @param selectedVaule
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void t001tagNameInitSelected (String selectedVaule, JSONWFCObject jsonObj) throws Exception {

		// タグ名
		jsonObj.setValue("tagname_DEFAULT",StringUtil.changeNullToBlank(selectedVaule));

	}

   
	/**
	 * 標準検索の初期化
	 * @param null
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	private void t001pageInitValueSetByDB (List<T001TAGEntity> T001TAGEntityList, JSONWFCObject jsonObj) throws Exception {

		T001TAGEntity T001TAGEntity = null;
		if (T001TAGEntityList != null && T001TAGEntityList.size() == 1) {
			T001TAGEntity = T001TAGEntityList.get(0);
		}
		if (T001TAGEntity != null) {
			//id
			jsonObj.setValue("txt2", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(T001TAGEntity.getId())));
			t001tagNameInitSelected(T001TAGEntity.getTagname(), jsonObj);
			//タグタイプ
			jsonObj.setValue("tagtype", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(T001TAGEntity.getTagtype())));
			//備考
			jsonObj.setValue("remark", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(T001TAGEntity.getRemark())));
			//タグコード
			jsonObj.setValue("tagcode", StringUtil.escapeValueTags(StringUtil.changeNullToBlank(T001TAGEntity.getTagcode())));
		}

	}

   
	/**
	 * 標準検索の初期化
	 * @param T001TAGEntityList
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject st001SearchInit (T001Entity t001Entity) throws Exception {

		//mode
		String mode = null;
		//txt2
		String txt2 = null;
		List<T001TAGEntity> T001TAGEntityList = null;
		JSONWFCObject jsonObj = new JSONWFCObject();
		t001tagNameInit(t001Entity, jsonObj);
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(t001Entity.getMode())));
		if ("1".equals(mode)) {
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(t001Entity.getTxt2())));
			T001TAGEntityList = T001TAGDao.t001SearchInitDepthZero(txt2);
			t001pageInitValueSetByDB(T001TAGEntityList, jsonObj);
		}
		return jsonObj;

	}
}