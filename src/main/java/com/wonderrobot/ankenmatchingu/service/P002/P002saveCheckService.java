package com.wonderrobot.ankenmatchingu.service.P002;
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
import com.wonderrobot.ankenmatchingu.entity.P002.P002Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.common.SaveDataCheckUtil;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PEOPLE_DETAILRepeatCheckEntity;
import com.wonderrobot.ankenmatchingu.dao.P002.P002PEOPLE_DETAILRepeatCheckDao;
import java.util.List;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page: 技術者明細
 */
@Service
public class P002saveCheckService {
	@Autowired
	private P002PEOPLE_DETAILRepeatCheckDao P002PEOPLE_DETAILRepeatCheckDao;


	/**
	 * チェックフィールド
	 *
	 * @param contactCompany
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String contactCompanyCheck(String contactCompany) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(contactCompany, 255, "連絡先会社");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(contactCompany, 0, "連絡先会社");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param interviewTime
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String interviewTimeCheck(String interviewTime) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(interviewTime, 100, "面接可能時間");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(interviewTime, 0, "面接可能時間");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param certificate
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String certificateCheck(String certificate) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(certificate, 1000, "資格");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(certificate, 0, "資格");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param remark
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String remarkCheck(String remark) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(remark, 1000, "コメント");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(remark, 0, "コメント");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param txt56
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String txt56Check(String txt56) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(txt56, 50, "国籍");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(txt56, 0, "国籍");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param skills
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String skillsCheck(String skills) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(skills, 255, "スキル");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(skills, 0, "スキル");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param price
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String priceCheck(String price) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(price, 50, "単価");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(price, 0, "単価");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param contact
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String contactCheck(String contact) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(contact, 50, "連絡先");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(contact, 0, "連絡先");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param emailAttachment
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String emailAttachmentCheck(String emailAttachment) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(emailAttachment, 255, "メール添付パス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(emailAttachment, 0, "メール添付パス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param contactAddress
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String contactAddressCheck(String contactAddress) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(contactAddress, 500, "連絡先アドレス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(contactAddress, 0, "連絡先アドレス");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param contactMail
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String contactMailCheck(String contactMail) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(contactMail, 100, "連絡先メール");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(contactMail, 0, "連絡先メール");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param introduction
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String introductionCheck(String introduction) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(introduction, 1000, "紹介");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(introduction, 0, "紹介");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param emailSendTime
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String emailSendTimeCheck(String emailSendTime) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getDateTimeCheckErr(emailSendTime, "メール送信時刻");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param address
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String addressCheck(String address) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(address, 255, "住所");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(address, 0, "住所");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param emailTitle
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String emailTitleCheck(String emailTitle) throws Exception {

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
	 *
	 * @param sex
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String sexCheck(String sex) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(sex, 0, "性别");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(sex, 0, "性别");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(sex, "性别");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param companyCurrent
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String companyCurrentCheck(String companyCurrent) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(companyCurrent, 100, "現在の会社");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(companyCurrent, 0, "現在の会社");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param entryTime
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String entryTimeCheck(String entryTime) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(entryTime, 100, "入場可能時間");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(entryTime, 0, "入場可能時間");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param txt2
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String txt2Check(String txt2) throws Exception {

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
	 *
	 * @param name
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String nameCheck(String name) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(name, 50, "名前");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(name, 0, "名前");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param contactPhone
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String contactPhoneCheck(String contactPhone) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(contactPhone, 100, "連絡先tel");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(contactPhone, 0, "連絡先tel");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * チェックフィールド
	 *
	 * @param emailSender
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String emailSenderCheck(String emailSender) throws Exception {

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
	 *
	 * @param age
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String ageCheck(String age) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();

		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(age, 25, "年齢");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(age, 0, "年齢");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * フィールドの繰り返しをチェックする
	 *
	 * @param p002Entity
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String pEOPLE_DETAILRepeatCheck(P002Entity p002Entity) throws Exception {

		List<P002PEOPLE_DETAILRepeatCheckEntity> P002PEOPLE_DETAILRepeatCheckEntityList = null;
		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		String txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getTxt2())));
		P002PEOPLE_DETAILRepeatCheckEntityList = P002PEOPLE_DETAILRepeatCheckDao.p002PEOPLE_DETAILRepeatCheckselectPEOPLE_DETAIL(txt2);
		if (P002PEOPLE_DETAILRepeatCheckEntityList != null && P002PEOPLE_DETAILRepeatCheckEntityList.size() > 0) {

			errMsg = SaveDataCheckUtil.getKeyRepeatErr("人员明细");
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}


	/**
	 * データ検証
	 *
	 * @param p002Entity
	 * @return String
	 * @throws Exception
	 */
	@Log
	public String saveDataCheck(P002Entity p002Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		String contactCompany = null;
		String interviewTime = null;
		String certificate = null;
		String remark = null;
		String txt56 = null;
		String skills = null;
		String price = null;
		String contact = null;
		String emailAttachment = null;
		String contactAddress = null;
		String contactMail = null;
		String introduction = null;
		String emailSendTime = null;
		String address = null;
		String emailTitle = null;
		String sex = null;
		String companyCurrent = null;
		String txt2 = null;
		String name = null;
		String contactPhone = null;
		String emailSender = null;
		String age = null;
		String mode = null;
		String entryTime = null;
		try {
			msgBuffer = new StringBuffer();
			contactCompany = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getContactcompany())));
			interviewTime = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getInterviewtime())));
			certificate = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getCertificate())));
			remark = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getRemark())));
			txt56 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getTxt56())));
			skills = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getSkills())));
			price = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getPrice())));
			contact = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getContact())));
			emailAttachment = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getEmailattachment())));
			contactAddress = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getContactaddress())));
			contactMail = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getContactmail())));
			introduction = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getIntroduction())));
			emailSendTime = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getEmailsendtime())));
			address = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getAddress())));
			emailTitle = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getEmailtitle())));
			sex = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getSex())));
			companyCurrent = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getCompanycurrent())));
			entryTime = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getEntrytime())));
			txt2 = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getTxt2())));
			name = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getName())));
			contactPhone = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getContactphone())));
			emailSender = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getEmailsender())));
			age = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getAge())));


			errMsg = contactCompanyCheck(contactCompany);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = interviewTimeCheck(interviewTime);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = certificateCheck(certificate);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = remarkCheck(remark);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = txt56Check(txt56);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = skillsCheck(skills);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = priceCheck(price);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = contactCheck(contact);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = emailAttachmentCheck(emailAttachment);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = contactAddressCheck(contactAddress);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = contactMailCheck(contactMail);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = introductionCheck(introduction);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = emailSendTimeCheck(emailSendTime);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = addressCheck(address);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = emailTitleCheck(emailTitle);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = sexCheck(sex);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = companyCurrentCheck(companyCurrent);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = entryTimeCheck(entryTime);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = txt2Check(txt2);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = nameCheck(name);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = contactPhoneCheck(contactPhone);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = emailSenderCheck(emailSender);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);

			errMsg = ageCheck(age);
			SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
			mode = StringUtil.changeNullToBlank(StringUtil.escapeSQLTags(StringUtil.changeNullToBlank(p002Entity.getMode())));
			if ("2".equals(mode)) {

				errMsg = pEOPLE_DETAILRepeatCheck(p002Entity);
				SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
			}
			errMsg = msgBuffer.toString();

			return errMsg;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

