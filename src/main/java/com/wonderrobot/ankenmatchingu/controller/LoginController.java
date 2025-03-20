package com.wonderrobot.ankenmatchingu.controller;
// LoginController.vm
import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.constant.SessionConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.log.LoggerUtil;
import com.wonderfulfly.core.util.StringUtil;
import com.wonderrobot.ankenmatchingu.security.LoginUser;
import com.wonderrobot.ankenmatchingu.aspect.Log;
import com.wonderrobot.ankenmatchingu.common.MenuRightUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import com.wonderrobot.ankenmatchingu.entity.UserMenuEntity;
import com.wonderrobot.ankenmatchingu.service.UserMenuService;
import com.wonderrobot.ankenmatchingu.entity.LoginEntity;
import java.util.LinkedHashMap;
import com.wonderfulfly.core.constant.SessionConstant;
import org.springframework.web.bind.annotation.RestController;


/**
 * ${SpringBootPageBucket.projectName}
 * class: LoginController
 * Page: login
 */
@RestController
public class LoginController {


	@Autowired
	private UserMenuService userMenuService;


	@Resource
	private AuthenticationManager authenticationManager;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping("login.do")
	@Log
	@ResponseBody
	public String newLogin(@RequestBody LoginEntity loginEntity) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		String userid = loginEntity.getUserid();
		String pwd = loginEntity.getPwd();
		String isMobile = loginEntity.getIsMobile();

		if(StringUtil.isNullOrBlank(userid)) {
			jsonObj.setScript(JsonConstant.JSONID_MSG, "IDを入力してください。");
			return jsonObj.toJSONString();
		}

		if(StringUtil.isNullOrBlank(pwd)){
			jsonObj.setScript(JsonConstant.JSONID_MSG, "パスワードを入力してください。");
			return jsonObj.toJSONString();
		}
		// User authentication
		Authentication authentication = null;
		try {
			// UserDetailsServiceImpl.loadUserByUsername
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userid, pwd));
		} catch (Exception e) {
			if (e instanceof BadCredentialsException) {
				LoggerUtil.error("Password error", e);
				jsonObj.setScript(JsonConstant.JSONID_MSG, "IDかパスワードが間違っています。");
				return jsonObj.toJSONString();
			} else {
				// Business exception thrown
				LoggerUtil.error("Business exception", e);
				jsonObj.setScript(JsonConstant.JSONID_MSG, "IDかパスワードが間違っています。");
				return jsonObj.toJSONString();
			}
		}
		if (authentication.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			LoginUser loginUser = (LoginUser) authentication.getPrincipal();

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			// languageID setting
			session.setAttribute(SessionConstant.LANGUAGE_ID, "JPN");
			// loginid setting
			session.setAttribute(SessionConstant.USER_ID, loginUser.getUsername());
			session.setAttribute("LOGIN_USER_ID", loginUser.getUsername());
			session.setAttribute(SessionConstant.APP_USER_ID, loginUser.getUsername());
			session.setAttribute("ORGID", loginUser.getGroupid());
			// userflg setting
			session.setAttribute(SessionConstant.USER_FLG, "1");
			session.setAttribute(SessionConstant.PASSWORD, loginUser.getPassword());
			MDC.put(SessionConstant.USER_ID, loginUser.getUsername());
			// Menus that the user can access
			List<String> menu = loginUser.getMenu();
			// Pages that this user can access
			Map<String, String> user_auth_map = loginUser.getUSER_AUTH_MAP();

			MenuRightUtil MenuRightUtil = new MenuRightUtil();

			if ("admin".equals(userid)) {
				MenuRightUtil.setAdminSessionRight(session);
			} else {
				MenuRightUtil.setSessionRight(session, loginUser.getGroupid());
			}


			jsonObj.setScript("OK", "/S001");

			return jsonObj.toJSONString();
		}
		return jsonObj.toJSONString();
	}


	/**
	 * Menu access
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getMenu.do")
	public UserMenuTreeResponse getInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String loginid = (String) session.getAttribute(SessionConstant.USER_ID);

		List<UserMenuEntity> userMenuEntities = userMenuService.getUserMenu(loginid);

		if (userMenuEntities.isEmpty()) {
			return new UserMenuTreeResponse("-1");
		}

		UserMenuTreeResponse userMenuTreeResponse = new UserMenuTreeResponse();
		Map<String, UserMenuTreeResponse.UserMenu> menusMap = new LinkedHashMap<>();
		// Parent node
		for (UserMenuEntity userMenuEntity : userMenuEntities) {
			UserMenuTreeResponse.UserMenu userMenu = new UserMenuTreeResponse.UserMenu(userMenuEntity);
			userMenuTreeResponse.getRoles().add(userMenu);
			menusMap.put(userMenu.getName(), userMenu);
		}
		userMenuTreeResponse.setCode("200");
		return userMenuTreeResponse;
	}


}

