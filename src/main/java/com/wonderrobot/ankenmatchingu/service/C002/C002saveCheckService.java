package com.wonderrobot.ankenmatchingu.service.C002;
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
import com.wonderrobot.ankenmatchingu.entity.C002.C002Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.common.SaveDataCheckUtil;
import com.wonderrobot.ankenmatchingu.entity.C002.C002COMMUNICATION_RECORDRepeatCheckEntity;
import com.wonderrobot.ankenmatchingu.dao.C002.C002COMMUNICATION_RECORDRepeatCheckDao;
import java.util.List;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page: コミュニケーション記録
 */
@Service
public class C002saveCheckService {
	@Autowired
	private C002COMMUNICATION_RECORDRepeatCheckDao C002COMMUNICATION_RECORDRepeatCheckDao;

   
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
	 * @param emailTitle
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String emailTitleCheck (String emailTitle) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(emailTitle, 1000, "メールタイトル");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(emailTitle, 0, "メールタイトル");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param recordType
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String recordTypeCheck (String recordType) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getIntCheckErr(recordType, "レコードタイプ");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param emailReceiver
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String emailReceiverCheck (String emailReceiver) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(emailReceiver, 255, "受信者");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(emailReceiver, 0, "受信者");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param emailSender
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String emailSenderCheck (String emailSender) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(emailSender, 255, "送信者");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(emailSender, 0, "送信者");
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
		
		errMsg = SaveDataCheckUtil.getDateTimeCheckErr(emailSendTime, "送信時間");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param matchId
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String matchIdCheck (String matchId) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(matchId, 0, "マッチングID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(matchId, 0, "マッチングID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(matchId, "マッチングID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param txt26
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String txt26Check (String txt26) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(txt26, 0, "コミュニケーションID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(txt26, 0, "コミュニケーションID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(txt26, "コミュニケーションID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * フィールドの繰り返しをチェックする
	 * @param c002Entity
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String cOMMUNICATION_RECORDRepeatCheck (C002Entity c002Entity) throws Exception {

		List<C002COMMUNICATION_RECORDRepeatCheckEntity> C002COMMUNICATION_RECORDRepeatCheckEntityList = null;
		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		String txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getTxt2())));
		C002COMMUNICATION_RECORDRepeatCheckEntityList = C002COMMUNICATION_RECORDRepeatCheckDao.c002COMMUNICATION_RECORDRepeatCheckselectCOMMUNICATION_RECORD(txt2);
		if (C002COMMUNICATION_RECORDRepeatCheckEntityList != null && C002COMMUNICATION_RECORDRepeatCheckEntityList.size() > 0) {
			
			errMsg = SaveDataCheckUtil.getKeyRepeatErr("コミュニケーション記録");
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * データ検証
	 * @param c002Entity
	 * @return String
	 * @throws Exception
	 */
	@Log
	public String saveDataCheck (C002Entity c002Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		String txt2 = null;
		String emailTitle = null;
		String recordType = null;
		String emailReceiver = null;
		String emailSender = null;
		String emailSendTime = null;
		String matchId = null;
		String txt26 = null;
		String mode = null;
		msgBuffer = new StringBuffer();
		txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getTxt2())));
		emailTitle = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getEmailtitle())));
		recordType = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getRecordtype())));
		emailReceiver = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getEmailreceiver())));
		emailSender = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getEmailsender())));
		emailSendTime = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getEmailsendtime())));
		matchId = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getMatchid())));
		txt26 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getTxt26())));
		
		
		errMsg = txt2Check(txt2);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = emailTitleCheck(emailTitle);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = recordTypeCheck(recordType);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = emailReceiverCheck(emailReceiver);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = emailSenderCheck(emailSender);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = emailSendTimeCheck(emailSendTime);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = matchIdCheck(matchId);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = txt26Check(txt26);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c002Entity.getMode())));
		if ("2".equals(mode)) {
			
			errMsg = cOMMUNICATION_RECORDRepeatCheck(c002Entity);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}
}