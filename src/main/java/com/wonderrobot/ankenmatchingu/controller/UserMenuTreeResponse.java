package com.wonderrobot.ankenmatchingu.controller;

import com.wonderrobot.ankenmatchingu.entity.UserMenuEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.wonderfulfly.core.util.StringUtil;

public class UserMenuTreeResponse {
	public UserMenuTreeResponse(String code) {
		this.code = code;
	}

	public UserMenuTreeResponse() {
	}

	//
	List<UserMenu> roles = new ArrayList<>();

	/**
	 * 200 success
	 */
	String code;

	public List<UserMenu> getRoles() {
		return roles;
	}

	public void setRoles(List<UserMenu> roles) {
		this.roles = roles;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static class UserMenu {

		public UserMenu(UserMenuEntity userMenuEntity) {
			this.userMenuEntity = userMenuEntity;
			if (StringUtil.isNullOrBlank(userMenuEntity.getPAGE_MNG_ID())) {
				this.path = "/" + userMenuEntity.getPROFILE_ID();
			} else {
				this.path = userMenuEntity.getPAGE_MNG_ID();
			}
			if (StringUtil.isNullOrBlank(userMenuEntity.getPROFILE_ID())) {
				this.name = "";
			} else {
				this.name = userMenuEntity.getPROFILE_ID();
			}
			if (StringUtil.isNullOrBlank(userMenuEntity.getTRANSFLG())) {
				this.transflg = "";
			} else {
				this.transflg = userMenuEntity.getTRANSFLG();
			}
			this.meta = new HashMap<>();
			meta.put("", userMenuEntity.getPFOFILE_NM());
		}

		/**
		 * trans flg
		 */
		private String transflg;
		/**
		 * Access path
		 */
		private String path;
		/**
		 * Dependent components
		 */
		private String component;
		/**
		 * Permission name
		 */
		private String name;
		/**
		 * page information
		 */
		private Map<String, String> meta;
		/**
		 * child node
		 */
		List<UserMenu> children;

		private UserMenuEntity userMenuEntity;

		public String getPath() {
			return path;
		}

		public String getTransflg() {
			return transflg;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public void setTransflg(String transflg) {
			this.transflg = transflg;
		}

		public String getComponent() {
			return component;
		}

		public void setComponent(String component) {
			this.component = component;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Map<String, String> getMeta() {
			return meta;
		}

		public void setMeta(Map<String, String> meta) {
			this.meta = meta;
		}

		public List<UserMenu> getChildren() {
			return children;
		}

		public void setChildren(List<UserMenu> children) {
			this.children = children;
		}

		public UserMenuEntity getUserMenuEntity() {
			return userMenuEntity;
		}

		public void setUserMenuEntity(UserMenuEntity userMenuEntity) {
			this.userMenuEntity = userMenuEntity;
		}
	}
}

