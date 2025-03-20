package com.wonderrobot.ankenmatchingu.dao;
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.LoginEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class LoginDao {
	
	@Autowired
	private LoginMapper LoginMapper;
	
	public List<LoginEntity> loginInit (String LOGINID, String LOGINPASSWORD, String USER_EFF, String GROUPID, String LOGINTABLEID, String WHRLOGINID, String WHRLOGINPASSWORD, String USERID) throws Exception {

		List<LoginEntity> returnVal = LoginMapper.loginInit(LOGINID, LOGINPASSWORD, USER_EFF, GROUPID, LOGINTABLEID, WHRLOGINID, WHRLOGINPASSWORD, USERID);
		return returnVal;
	}
	public List<LoginEntity> loginInitNm (String LOGINID, String LOGINPASSWORD, String USER_EFF, String GROUPID, String LOGINTABLEID, String WHRLOGINID, String WHRLOGINPASSWORD, String USERID, String USERNM1, String USERNM2) throws Exception {

		List<LoginEntity> returnVal = LoginMapper.loginInitNm(LOGINID, LOGINPASSWORD, USER_EFF, GROUPID, LOGINTABLEID, WHRLOGINID, WHRLOGINPASSWORD, USERID, USERNM1, USERNM2);
		return returnVal;
	}
	public List<LoginEntity> loginInitSurname (String LOGINID, String LOGINPASSWORD, String USER_EFF, String GROUPID, String LOGINTABLEID, String WHRLOGINID, String WHRLOGINPASSWORD, String USERID, String USERNM1) throws Exception {

		List<LoginEntity> returnVal = LoginMapper.loginInitSurname(LOGINID, LOGINPASSWORD, USER_EFF, GROUPID, LOGINTABLEID, WHRLOGINID, WHRLOGINPASSWORD, USERID, USERNM1);
		return returnVal;
	}
	public List<LoginEntity> loginInitName (String LOGINID, String LOGINPASSWORD, String USER_EFF, String GROUPID, String LOGINTABLEID, String WHRLOGINID, String WHRLOGINPASSWORD, String USERID, String USERNM2) throws Exception {

		List<LoginEntity> returnVal = LoginMapper.loginInitName(LOGINID, LOGINPASSWORD, USER_EFF, GROUPID, LOGINTABLEID, WHRLOGINID, WHRLOGINPASSWORD, USERID, USERNM2);
		return returnVal;
	}
	public List<LoginEntity> loginAdminInit (String LOGINID, String PASSWORD) throws Exception {

		List<LoginEntity> returnVal = LoginMapper.loginAdminInit(LOGINID, PASSWORD);
		return returnVal;
	}
}

