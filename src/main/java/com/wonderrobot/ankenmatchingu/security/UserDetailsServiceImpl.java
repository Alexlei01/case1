package com.wonderrobot.ankenmatchingu.security;
// UserDetailsServiceImpl.vm
import com.wonderfulfly.core.util.StringUtil;
import com.wonderrobot.ankenmatchingu.entity.ConfigEntity;
import com.wonderrobot.ankenmatchingu.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserDetailsService implements
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 配置情報 Configuration
     */
    @Autowired
    private ConfigEntity ConfigEntity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

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

        List<LoginUser> userList = null;
        if(StringUtil.nullOrBlank(login_tableid) || StringUtil.nullOrBlank(login_id) || StringUtil.nullOrBlank(login_password) || StringUtil.nullOrBlank(user_Group)) {
        	 userList = loginMapper.getAdminByUsername(username);
        }else {
        	 userList = loginMapper.getBusinessUserByUsername(username,login_password,user_Group,login_tableid,login_id);
        }
        Assert.notEmpty(userList, "Account does not exist");
        LoginUser loginUser = userList.get(0);

        List<String> authoritiesList = new ArrayList<>();
        List<PageRight> group = loginMapper.getPageRightByGroup(loginUser.getGroupid());

        List<String> menu = new ArrayList<>();
        Map<String, String> USER_AUTH_MAP = new HashMap<>();

        // Set permission fields
        for (PageRight right : group) {
            if (right.getPAGEID().startsWith("M")) {
                menu.add(right.getPAGEID());
                authoritiesList.add(right.getPAGEID());
            } else if (right.getPAGEID().startsWith("P")) {
                StringBuilder sb = new StringBuilder();
                sb.append(right.getNORIGHTFLG()).append(right.getINSERTFLG())
                        .append(right.getUPDATEFLG()).append(right.getDISPLAYFLG())
                        .append(right.getDELETEFLG());
                USER_AUTH_MAP.put(right.getPAGEID(), sb.toString());

                if ("0".equals(right.getNORIGHTFLG())) {

                	String pageId = right.getPAGEID();

                	pageId = loginMapper.getPageMngId(pageId);

                	if ("1".equals(right.getINSERTFLG())) {
                		authoritiesList.add(String.format("%s|INSERT", pageId));
                	}
                	if ("1".equals(right.getUPDATEFLG())) {
                		authoritiesList.add(String.format("%s|UPDATE", pageId));
                	}
                	if ("1".equals(right.getDELETEFLG())) {
                		authoritiesList.add(String.format("%s|DELETE", pageId));
                	}
                	if ("1".equals(right.getDISPLAYFLG())) {
                		authoritiesList.add(String.format("%s|DISPLAY", pageId));
                	}
                }
            }
        }
        loginUser.setMenu(menu);
        loginUser.setUSER_AUTH_MAP(USER_AUTH_MAP);
        loginUser.setAuthorities(AuthorityUtils.createAuthorityList(authoritiesList.toArray(new String[0])));
        return loginUser;
    }


}
