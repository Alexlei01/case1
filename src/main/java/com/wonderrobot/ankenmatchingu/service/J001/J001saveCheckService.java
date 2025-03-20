package com.wonderrobot.ankenmatchingu.service.J001;
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
import com.wonderrobot.ankenmatchingu.entity.J001.J001Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.common.SaveDataCheckUtil;
import com.wonderrobot.ankenmatchingu.entity.J001.J001JOB_DETAILRepeatCheckEntity;
import com.wonderrobot.ankenmatchingu.dao.J001.J001JOB_DETAILRepeatCheckDao;
import java.util.List;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page: 案件明細
 */
@Service
public class J001saveCheckService {
	@Autowired
	private J001JOB_DETAILRepeatCheckDao J001JOB_DETAILRepeatCheckDao;

   
	/**
	 * チェックフィールド
	 * @param project
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String projectCheck (String project) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(project, 255, "項目");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(project, 0, "項目");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param workAddress
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String workAddressCheck (String workAddress) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(workAddress, 255, "勤務先アドレス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(workAddress, 0, "勤務先アドレス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param outline
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String outlineCheck (String outline) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(outline, 255, "概要");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(outline, 0, "概要");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param projectMachine
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String projectMachineCheck (String projectMachine) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(projectMachine, 255, "機種");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(projectMachine, 0, "機種");
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
	 * @param recruitment
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String recruitmentCheck (String recruitment) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(recruitment, 100, "募集要員");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(recruitment, 0, "募集要員");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param projectCycle
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String projectCycleCheck (String projectCycle) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(projectCycle, 250, "予定開始日");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(projectCycle, 0, "予定開始日");
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
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(emailSendTime, 30, "メール送信時刻");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(emailSendTime, 0, "メール送信時刻");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * チェックフィールド
	 * @param budget
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String budgetCheck (String budget) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(budget, 100, "予算");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(budget, 0, "予算");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * フィールドの繰り返しをチェックする
	 * @param j001Entity
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String jOB_DETAILRepeatCheck (J001Entity j001Entity) throws Exception {

		List<J001JOB_DETAILRepeatCheckEntity> J001JOB_DETAILRepeatCheckEntityList = null;
		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		String txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getTxt2())));
		J001JOB_DETAILRepeatCheckEntityList = J001JOB_DETAILRepeatCheckDao.j001JOB_DETAILRepeatCheckselectJOB_DETAIL(txt2);
		if (J001JOB_DETAILRepeatCheckEntityList != null && J001JOB_DETAILRepeatCheckEntityList.size() > 0) {
			
			errMsg = SaveDataCheckUtil.getKeyRepeatErr("仕事明細");
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * データ検証
	 * @param j001Entity
	 * @return String
	 * @throws Exception
	 */
	@Log
	public String saveDataCheck (J001Entity j001Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		String project = null;
		String workAddress = null;
		String outline = null;
		String projectMachine = null;
		String txt2 = null;
		String recruitment = null;
		String projectCycle = null;
		String emailSender = null;
		String emailSendTime = null;
		String budget = null;
		String mode = null;
		msgBuffer = new StringBuffer();
		project = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getProject())));
		workAddress = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getWorkaddress())));
		outline = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getOutline())));
		projectMachine = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getProjectmachine())));
		txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getTxt2())));
		recruitment = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getRecruitment())));
		projectCycle = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getProjectcycle())));
		emailSender = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getEmailsender())));
		emailSendTime = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getEmailsendtime())));
		budget = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getBudget())));
		
		
		errMsg = projectCheck(project);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = workAddressCheck(workAddress);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = outlineCheck(outline);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = projectMachineCheck(projectMachine);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = txt2Check(txt2);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = recruitmentCheck(recruitment);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = projectCycleCheck(projectCycle);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = emailSenderCheck(emailSender);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = emailSendTimeCheck(emailSendTime);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		
		errMsg = budgetCheck(budget);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(j001Entity.getMode())));
		if ("2".equals(mode)) {
			
			errMsg = jOB_DETAILRepeatCheck(j001Entity);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}
}