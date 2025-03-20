package com.wonderrobot.ankenmatchingu.service;
// BasicService.vm
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;

import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.DateUtil;
import com.wonderfulfly.core.json.JSONWFCObject;

import com.wonderrobot.ankenmatchingu.entity.ConfigEntity;
import com.wonderrobot.ankenmatchingu.aspect.Log;
import com.wonderrobot.ankenmatchingu.entity.UserPasswordRequestEntity;
import com.wonderrobot.ankenmatchingu.dao.UserPasswordDao;

/**
 * User Change Password Service
 */
@Service
public class UserPasswordService {


	@Autowired
	private ConfigEntity ConfigEntity;
	@Autowired
	private UserPasswordDao UserPasswordDao;

	/**
	 * ユーザーパスワードを更新する
	 * @param UserPasswordRequestEntity
	 * @throws Exception
	 */
	@Log
	public void updateUserPassword(UserPasswordRequestEntity UserPasswordRequestEntity) throws Exception {
		String LOGINTABLEID = ConfigEntity.getUser_tableid();
		String LOGINPASSWORD = ConfigEntity.getUser_table_password_fieldid();
		String LOGINPASSWORD_VALUE = UserPasswordRequestEntity.getChangeloginid();
		String LOGINID = ConfigEntity.getUser_table_userid_fieldid();
		String LOGINID_VALUE = UserPasswordRequestEntity.getChangepassword();
		UserPasswordDao.updateUserPassword(LOGINTABLEID, LOGINPASSWORD, LOGINPASSWORD_VALUE, LOGINID, LOGINID_VALUE);
	}

}
