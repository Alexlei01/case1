package com.wonderrobot.ankenmatchingu.dao;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.UserPasswordRequestEntity;
import com.wonderrobot.ankenmatchingu.mapper.UserPasswordMapper;

/**
 * UserPasswordDao
 */
@Repository
public class UserPasswordDao {

	@Autowired
	private UserPasswordMapper UserPasswordMapper;

	/*
	 * call mapper interface
	 */
	public void updateUserPassword(String LOGINTABLEID, String LOGINPASSWORD, String LOGINPASSWORD_VALUE, String LOGINID, String LOGINID_VALUE) throws Exception {
        UserPasswordMapper.updateUserPassword(LOGINTABLEID, LOGINPASSWORD, LOGINPASSWORD_VALUE, LOGINID, LOGINID_VALUE);
	}

}
