package com.wonderrobot.ankenmatchingu.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.MDC;
import com.wonderrobot.ankenmatchingu.entity.ConfigEntity;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.constant.SessionConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.security.Encrypt;
import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.log.LoggerUtil;
import com.wonderrobot.ankenmatchingu.dao.LoginDao;
import com.wonderrobot.ankenmatchingu.entity.LoginEntity;
import com.wonderrobot.ankenmatchingu.common.MenuRightUtil;
import com.wonderrobot.ankenmatchingu.aspect.Log;
/**
 * 案件マッチング Page: login
 */
@Service
public class LoginService {

   /**
    * Session 
    */
	private HttpSession Session;
	
   /**
    * loginid 
    */
	private String loginid;
   /**
    * password 
    */
	private String password;
   /**
    * groupID 
    */
	private String groupID;
   /**
    * userSurname 
    */
	private String userSurname;
   /**
    * userName 
    */
	private String userName;

   /**
	* Sessionを設定
	*
	* @param session
	*/
	public void setSession(HttpSession session) {
		Session = session;
	}

   /**
	* loginidを設定
	*
	* @param loginid
	*/
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

   /**
	* passwordを設定
	*
	* @param password
	*/
	public void setPassword(String password) {
		this.password = password;
	}
   /**
	* userSurnameを設定
	*
	* @param userSurname
	*/
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
   /**
	* userNameを設定
	*
	* @param userName
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * ユーザー情報 Dao
	 */
	@Autowired
	private LoginDao LoginDao;

	/**
	 * 配置情報 Configuration
	 */
	@Autowired
	private ConfigEntity ConfigEntity;

	/**
	 * メニュー情報 Component
	 */
	@Autowired
	private MenuRightUtil MenuRightUtil;

	/**
	 * Login method
	 * 
	 * @throws Exception
	 */
	@Log
	public String doLogin() throws Exception {
		JSONWFCObject jsonObj = null;
		List<LoginEntity> alUserInfo = null;

		// login_tableid取得
		String login_tableid = ConfigEntity.getUser_tableid();
		// login_id取得
		String login_id = ConfigEntity.getUser_table_userid_fieldid();
		// login_password取得
		String login_password = ConfigEntity.getUser_table_password_fieldid();
		// userId取得
		String userId = ConfigEntity.getUser_table_user_fieldid();
		// user_eff取得
		String user_eff = ConfigEntity.getUser_table_eff_status_fieldid();
		// user_Group取得
		String user_Group = ConfigEntity.getUser_table_group_fieldid();
		// usernm1取得
		String usernm1 = ConfigEntity.getUser_table_usernm1_fieldid();
		// usernm2取得
		String usernm2 = ConfigEntity.getUser_table_usernm2_fieldid();
		jsonObj = new JSONWFCObject();
		alUserInfo = new ArrayList<LoginEntity>();

		if(!StringUtil.isNullOrBlank(login_tableid) && !StringUtil.isNullOrBlank(login_id) && !StringUtil.isNullOrBlank(login_password) && !StringUtil.isNullOrBlank(userId) && !StringUtil.isNullOrBlank(user_eff) && !StringUtil.isNullOrBlank(user_Group) && (!StringUtil.isNullOrBlank(usernm1) || !StringUtil.isNullOrBlank(usernm2))){

			if(!StringUtil.isNullOrBlank(usernm1) && !StringUtil.isNullOrBlank(usernm2)) {
			    alUserInfo = LoginDao.loginInitNm(login_id + " AS LOGINID", login_password + " AS PASSWORD", user_eff + " AS USER_EFF", user_Group + " AS GROUPID", login_tableid, login_id + " = '" + loginid + "'", login_password + " = '" + password + "'", userId + " AS USERID" , usernm1 + " AS USERNM1", usernm2 + " AS USERNM2");
			} else if (!StringUtil.isNullOrBlank(usernm1)) { 
			    alUserInfo = LoginDao.loginInitSurname(login_id + " AS LOGINID", login_password + " AS PASSWORD", user_eff + " AS USER_EFF", user_Group + " AS GROUPID", login_tableid, login_id + " = '" + loginid + "'", login_password + " = '" + password + "'", userId + " AS USERID", usernm1 + " AS USERNM1");
			} else if (!StringUtil.isNullOrBlank(usernm2)) { 
			    alUserInfo = LoginDao.loginInitName(login_id + " AS LOGINID", login_password + " AS PASSWORD", user_eff + " AS USER_EFF", user_Group + " AS GROUPID", login_tableid, login_id + " = '" + loginid + "'", login_password + " = '" + password + "'", userId + " AS USERID", usernm2 + " AS USERNM2");
			} else { 
			    alUserInfo = LoginDao.loginInit(login_id + " AS LOGINID", login_password + " AS PASSWORD", user_eff + " AS USER_EFF", user_Group + " AS GROUPID", login_tableid, login_id + " = '" + loginid + "'", login_password + " = '" + password + "'", userId + " AS USERID");
			}
			//ログインユーザー情報を空白すると情報 : 
			if (alUserInfo == null || alUserInfo.size() == 0) {

				alUserInfo = LoginDao.loginAdminInit(loginid, password);
				//ログインユーザー情報を空白すると情報 : 会員Noかパスワードが間違っています。
				if (alUserInfo == null || alUserInfo.size() == 0) {
					jsonObj.setScript(JsonConstant.JSONID_MSG, "会員Noかパスワードが間違っています。");
					return jsonObj.toJSONString();
				} else {
					userSurname = loginid;
					userName = loginid;
					setLoginSession();
					MenuRightUtil.setAdminSessionRight(Session);
					return "1";
				}
			} else {

				String flgString = null;
				// 有効区分取得
				flgString = alUserInfo.get(0).getUSER_EFF();
				// 有効区分を0すると
				if ("0".equals(flgString)) {
					jsonObj.setScript(JsonConstant.JSONID_MSG, "ユーザーはロックされました。システム管理者に連絡してください。");
					return jsonObj.toJSONString();
				} else {
					// loginid取得
					loginid = alUserInfo.get(0).getUserid();
					// groupID取得
					groupID = alUserInfo.get(0).getGROUPID();
					// usernm1取得
					userSurname = alUserInfo.get(0).getUSERNM1();
					// usernm2取得
					userName = alUserInfo.get(0).getUSERNM2();
					MenuRightUtil.setSessionRight(Session, groupID);
					// Sessionを設定
					setLoginSession();
				
					return "1";
				}
			}
		} else {

			alUserInfo = LoginDao.loginAdminInit(loginid, Encrypt.encrypt(password));
			//ログインユーザー情報を空白すると情報 : 会員Noかパスワードが間違っています。
			if (alUserInfo == null || alUserInfo.size() == 0) {
				jsonObj.setScript(JsonConstant.JSONID_MSG, "会員Noかパスワードが間違っています。");
				return jsonObj.toJSONString();
			} else {
				userSurname = loginid;
				userName = loginid;
				// Sessionを設定
				setLoginSession();
				MenuRightUtil.setAdminSessionRight(Session);
				return "1";
			}
		}
	}

	/**
	 * ログインセッションを設定する
	 */
	@Log
	public void setLoginSession() {

		// languageID設定
		Session.setAttribute(SessionConstant.LANGUAGE_ID, "JPN");
		// loginid設定
		Session.setAttribute(SessionConstant.USER_ID, loginid);
		Session.setAttribute("LOGIN_USER_ID", loginid);
		Session.setAttribute(SessionConstant.APP_USER_ID, loginid);
		Session.setAttribute("ORGID", groupID);
		// userflg設定
		Session.setAttribute(SessionConstant.USER_FLG, "1");
		Session.setAttribute(SessionConstant.PASSWORD, password);
		Session.setAttribute("USER_NAME1", userSurname);
		Session.setAttribute("USER_NAME2", userName);
		MDC.put(SessionConstant.USER_ID, loginid);
	}
}

