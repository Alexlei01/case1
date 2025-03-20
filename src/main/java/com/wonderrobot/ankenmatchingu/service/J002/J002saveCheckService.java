package com.wonderrobot.ankenmatchingu.service.J002;
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
import com.wonderrobot.ankenmatchingu.entity.J002.J002Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.common.SaveDataCheckUtil;
import com.wonderrobot.ankenmatchingu.entity.J002.J002JOB_MATCHRepeatCheckEntity;
import com.wonderrobot.ankenmatchingu.dao.J002.J002JOB_MATCHRepeatCheckDao;
import java.util.List;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page: 案件マッチング
 */
@Service
public class J002saveCheckService {
	@Autowired
	private J002JOB_MATCHRepeatCheckDao J002JOB_MATCHRepeatCheckDao;

   
	/**
	 * チェックフィールド
	 * @param jobName
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String jobNameCheck (String jobName) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(jobName, 255, "案件名");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(jobName, 0, "案件名");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
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
	 * @param matchCode
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String matchCodeCheck (String matchCode) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(matchCode, 255, "マッチングコード");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(matchCode, 0, "マッチングコード");
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
	 * @param matchPercent
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String matchPercentCheck (String matchPercent) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(matchPercent, 0, "マッチング率");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(matchPercent, 0, "マッチング率");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(matchPercent, "マッチング率");
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
	 * @param peopleName
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String peopleNameCheck (String peopleName) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(peopleName, 255, "技術者名");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(peopleName, 0, "技術者名");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * フィールドの繰り返しをチェックする
	 * @param j002Entity
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String jOB_MATCHRepeatCheck (J002Entity j002Entity) throws Exception {

		List<J002JOB_MATCHRepeatCheckEntity> J002JOB_MATCHRepeatCheckEntityList = null;
		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		String txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getTxt2())));
		J002JOB_MATCHRepeatCheckEntityList = J002JOB_MATCHRepeatCheckDao.j002JOB_MATCHRepeatCheckselectJOB_MATCH(txt2);
		if (J002JOB_MATCHRepeatCheckEntityList != null && J002JOB_MATCHRepeatCheckEntityList.size() > 0) {
			
			errMsg = SaveDataCheckUtil.getKeyRepeatErr("仕事マッチ");
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * データ検証
	 * @param j002Entity
	 * @return String
	 * @throws Exception
	 */
	@Log
	public String saveDataCheck (J002Entity j002Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		String jobName = null;
		String jobId = null;
		String matchCode = null;
		String txt2 = null;
		String matchPercent = null;
		String peopleId = null;
		String peopleName = null;
		String mode = null;
		msgBuffer = new StringBuffer();
		jobName = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getJobname())));
		jobId = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getJobid())));
		matchCode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getMatchcode())));
		txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getTxt2())));
		matchPercent = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getMatchpercent())));
		peopleId = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getPeopleid())));
		peopleName = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getPeoplename())));
		
		
		errMsg = jobNameCheck(jobName);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = jobIdCheck(jobId);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = matchCodeCheck(matchCode);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = txt2Check(txt2);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = matchPercentCheck(matchPercent);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = peopleIdCheck(peopleId);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = peopleNameCheck(peopleName);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j002Entity.getMode())));
		if ("2".equals(mode)) {
			
			errMsg = jOB_MATCHRepeatCheck(j002Entity);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}
}