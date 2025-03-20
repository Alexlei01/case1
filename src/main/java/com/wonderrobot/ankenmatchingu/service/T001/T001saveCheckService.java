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
import com.wonderrobot.ankenmatchingu.common.SaveDataCheckUtil;
import com.wonderrobot.ankenmatchingu.entity.T001.T001TAGRepeatCheckEntity;
import com.wonderrobot.ankenmatchingu.dao.T001.T001TAGRepeatCheckDao;
import java.util.List;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page: タグ管理
 */
@Service
public class T001saveCheckService {
	@Autowired
	private T001TAGRepeatCheckDao T001TAGRepeatCheckDao;

   
	/**
	 * チェックフィールド
	 * @param tagCode
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String tagCodeCheck (String tagCode) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(tagCode, 25, "タグコード");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(tagCode, 0, "タグコード");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param txt2
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String txt2Check (String txt2) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getKeyNullCheckErr(txt2, "id");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(txt2, 0, "id");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(txt2, 0, "id");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(txt2, "id");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param tagType
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String tagTypeCheck (String tagType) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(tagType, 0, "タグタイプ");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(tagType, 0, "タグタイプ");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(tagType, "タグタイプ");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param remark
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String remarkCheck (String remark) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(remark, 1000, "備考");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(remark, 0, "備考");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * フィールドの繰り返しをチェックする
	 * @param t001Entity
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String tAGRepeatCheck (T001Entity t001Entity) throws Exception {

		List<T001TAGRepeatCheckEntity> T001TAGRepeatCheckEntityList = null;
		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		String txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(t001Entity.getTxt2())));
		T001TAGRepeatCheckEntityList = T001TAGRepeatCheckDao.t001TAGRepeatCheckselectTAG(txt2);
		if (T001TAGRepeatCheckEntityList != null && T001TAGRepeatCheckEntityList.size() > 0) {
			
			errMsg = SaveDataCheckUtil.getKeyRepeatErr("TAG");
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * データ検証
	 * @param t001Entity
	 * @return String
	 * @throws Exception
	 */
	@Log
	public String saveDataCheck (T001Entity t001Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		String tagCode = null;
		String txt2 = null;
		String tagType = null;
		String remark = null;
		String mode = null;
		msgBuffer = new StringBuffer();
		tagCode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(t001Entity.getTagcode())));
		txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(t001Entity.getTxt2())));
		tagType = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(t001Entity.getTagtype())));
		remark = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(t001Entity.getRemark())));
		
		
		errMsg = tagCodeCheck(tagCode);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = txt2Check(txt2);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = tagTypeCheck(tagType);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = remarkCheck(remark);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(t001Entity.getMode())));
		if ("2".equals(mode)) {
			
			errMsg = tAGRepeatCheck(t001Entity);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}
}