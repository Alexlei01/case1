package com.wonderrobot.ankenmatchingu.service.P001;
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
import com.wonderrobot.ankenmatchingu.entity.P001.P001Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.common.SaveDataCheckUtil;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PEOPLE_TAGRepeatCheckEntity;
import com.wonderrobot.ankenmatchingu.dao.P001.P001PEOPLE_TAGRepeatCheckDao;
import java.util.List;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page: 技術者タグ
 */
@Service
public class P001saveCheckService {
	@Autowired
	private P001PEOPLE_TAGRepeatCheckDao P001PEOPLE_TAGRepeatCheckDao;

   
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
	 * @param tagId
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String tagIdCheck (String tagId) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(tagId, 0, "タグID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(tagId, 0, "タグID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(tagId, "タグID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param numberEnd
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String numberEndCheck (String numberEnd) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(numberEnd, 0, "終了番号");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(numberEnd, 0, "終了番号");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(numberEnd, "終了番号");
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
	 * @param numberStart
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String numberStartCheck (String numberStart) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(numberStart, 0, "開始番号");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(numberStart, 0, "開始番号");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(numberStart, "開始番号");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param detailId
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String detailIdCheck (String detailId) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(detailId, 0, "詳細ID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(detailId, 0, "詳細ID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(detailId, "詳細ID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param value
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String valueCheck (String value) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(value, 255, "値");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(value, 0, "値");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param emailSendTime
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String emailSendTimeCheck (String emailSendTime) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getDateTimeCheckErr(emailSendTime, "メール送信時刻");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * フィールドの繰り返しをチェックする
	 * @param p001Entity
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String pEOPLE_TAGRepeatCheck (P001Entity p001Entity) throws Exception {

		List<P001PEOPLE_TAGRepeatCheckEntity> P001PEOPLE_TAGRepeatCheckEntityList = null;
		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		String txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getTxt2())));
		P001PEOPLE_TAGRepeatCheckEntityList = P001PEOPLE_TAGRepeatCheckDao.p001PEOPLE_TAGRepeatCheckselectPEOPLE_TAG(txt2);
		if (P001PEOPLE_TAGRepeatCheckEntityList != null && P001PEOPLE_TAGRepeatCheckEntityList.size() > 0) {
			
			errMsg = SaveDataCheckUtil.getKeyRepeatErr("人タグ");
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * データ検証
	 * @param p001Entity
	 * @return String
	 * @throws Exception
	 */
	@Log
	public String saveDataCheck (P001Entity p001Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		String tagCode = null;
		String txt2 = null;
		String tagId = null;
		String numberEnd = null;
		String tagType = null;
		String numberStart = null;
		String detailId = null;
		String value = null;
		String emailSendTime = null;
		String mode = null;
		msgBuffer = new StringBuffer();
		tagCode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getTagcode())));
		txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getTxt2())));
		tagId = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getTagid())));
		numberEnd = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getNumberend())));
		tagType = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getTagtype())));
		numberStart = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getNumberstart())));
		detailId = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getDetailid())));
		value = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getValue())));
		emailSendTime = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getEmailsendtime())));
		
		
		errMsg = tagCodeCheck(tagCode);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = txt2Check(txt2);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = tagIdCheck(tagId);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = numberEndCheck(numberEnd);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = tagTypeCheck(tagType);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = numberStartCheck(numberStart);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = detailIdCheck(detailId);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = valueCheck(value);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = emailSendTimeCheck(emailSendTime);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p001Entity.getMode())));
		if ("2".equals(mode)) {
			
			errMsg = pEOPLE_TAGRepeatCheck(p001Entity);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}
}