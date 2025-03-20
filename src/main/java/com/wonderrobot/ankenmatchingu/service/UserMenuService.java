package com.wonderrobot.ankenmatchingu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonderrobot.ankenmatchingu.dao.UserMenuDao;
import com.wonderrobot.ankenmatchingu.entity.ConfigEntity;
import com.wonderrobot.ankenmatchingu.entity.UserMenuEntity;
import com.wonderfulfly.core.util.StringUtil;
import com.wonderrobot.ankenmatchingu.aspect.Log;

/**
 * UserMenu access
 */
@Service
public class UserMenuService {

	/**
	 * userMenuDao Dao
	 */
	@Autowired
	private UserMenuDao userMenuDao;

	@Autowired
	private ConfigEntity ConfigEntity;

	/**
	 * ユーザーメニューへのアクセス
	 * @param USERID
	 * @throws Exception
	 */
	@Log
	public List<UserMenuEntity> getUserMenu(String USERID){
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
        
        List<String> groupIds = null;
        if (StringUtil.nullOrBlank(login_tableid) || StringUtil.nullOrBlank(login_id) || StringUtil.nullOrBlank(login_password) || StringUtil.nullOrBlank(user_Group) || "admin".equals(USERID)) {
           groupIds = userMenuDao.getUserGroup(USERID);
        }else {
          groupIds = userMenuDao.getBusinessUserGroup(USERID,login_password,user_Group,login_tableid,login_id);
        }
        
        
        if(groupIds.isEmpty()) {
           groupIds = null;
        }
        return userMenuDao.getUserMenu(USERID,groupIds);
	}

}

