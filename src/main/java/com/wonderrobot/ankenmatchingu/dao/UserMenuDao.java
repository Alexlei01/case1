package com.wonderrobot.ankenmatchingu.dao;

import com.wonderrobot.ankenmatchingu.entity.UserMenuEntity;
import com.wonderrobot.ankenmatchingu.mapper.UserMenuMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserMenuDao access
 * 
 * @author wonderfulfly
 *
 */
@Repository
public class UserMenuDao {

	/**
	 * UserMenuMapper Mapper
	 */
	@Autowired
	private UserMenuMapper UserMenuMapper;

	/**
	 * getUserGroup method
	 * 
	 * @param USERID
	 * @return
	 */
	public List<String> getUserGroup(String USERID) {
		return UserMenuMapper.getUserGroup(USERID);
	}

	public List<String> getBusinessUserGroup(String LOGINID,String LOGINPASSWORD,String DEPARTID,String LOGINTABLEID,String WHRLOGINID) {
		return UserMenuMapper.getBusinessUserGroup(LOGINID,LOGINPASSWORD,DEPARTID,LOGINTABLEID,WHRLOGINID);
	}

	/**
	 * getUserMenu method
	 * 
	 * @param USERID
	 * @param groupIds
	 * @return
	 */
	public List<UserMenuEntity> getUserMenu(String USERID, List<String> groupIds) {
		return UserMenuMapper.getUserMenu(USERID, groupIds);
	}
}

