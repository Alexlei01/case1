package com.wonderrobot.ankenmatchingu.service.C001;
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
import com.wonderrobot.ankenmatchingu.entity.C001.C001Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.common.SaveDataCheckUtil;
import com.wonderrobot.ankenmatchingu.entity.C001.C001COMMUNICATIONRepeatCheckEntity;
import com.wonderrobot.ankenmatchingu.dao.C001.C001COMMUNICATIONRepeatCheckDao;
import java.util.List;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page: コミュニケーション
 */
@Service
public class C001saveCheckService {
	@Autowired
	private C001COMMUNICATIONRepeatCheckDao C001COMMUNICATIONRepeatCheckDao;

   
	/**
	 * チェックフィールド
	 * @param jobId
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String jobIdCheck (String jobId) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(jobId, 0, "案件ID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(jobId, 0, "案件ID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(jobId, "案件ID");
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
	 * @param peopleId
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String peopleIdCheck (String peopleId) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(peopleId, 0, "技術者ID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(peopleId, 0, "技術者ID");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(peopleId, "技術者ID");
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
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(remark, 255, "コメント");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(remark, 0, "コメント");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param status
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String statusCheck (String status) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(status, 255, "ステータス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(status, 0, "ステータス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(status, "ステータス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * フィールドの繰り返しをチェックする
	 * @param c001Entity
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String cOMMUNICATIONRepeatCheck (C001Entity c001Entity) throws Exception {

		List<C001COMMUNICATIONRepeatCheckEntity> C001COMMUNICATIONRepeatCheckEntityList = null;
		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		String txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getTxt2())));
		C001COMMUNICATIONRepeatCheckEntityList = C001COMMUNICATIONRepeatCheckDao.c001COMMUNICATIONRepeatCheckselectCOMMUNICATION(txt2);
		if (C001COMMUNICATIONRepeatCheckEntityList != null && C001COMMUNICATIONRepeatCheckEntityList.size() > 0) {
			
			errMsg = SaveDataCheckUtil.getKeyRepeatErr("コミュニケーション");
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * データ検証
	 * @param c001Entity
	 * @return String
	 * @throws Exception
	 */
	@Log
	public String saveDataCheck (C001Entity c001Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		String jobId = null;
		String txt2 = null;
		String peopleId = null;
		String remark = null;
		String status = null;
		String mode = null;
		msgBuffer = new StringBuffer();
		jobId = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getJobid())));
		txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getTxt2())));
		peopleId = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getPeopleid())));
		remark = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getRemark())));
		status = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getStatus())));
		
		
		errMsg = jobIdCheck(jobId);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = txt2Check(txt2);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = peopleIdCheck(peopleId);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = remarkCheck(remark);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = statusCheck(status);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(c001Entity.getMode())));
		if ("2".equals(mode)) {
			
			errMsg = cOMMUNICATIONRepeatCheck(c001Entity);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}
}