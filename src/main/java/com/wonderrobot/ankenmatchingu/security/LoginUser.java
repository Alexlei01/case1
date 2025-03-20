package com.wonderrobot.ankenmatchingu.security;
// LoginUser.vm
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Login user handler class
 */
public class LoginUser implements UserDetails {
	
    private String username;

    private String password;

    private String groupid;

    /**
     * SpringSecurity authorities
     */
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * menu list
     */
    private List<String> menu;

    /**
     * List of pages and corresponding permissions
     */
    private Map<String, String> USER_AUTH_MAP;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public List<String> getMenu() {
		return menu;
	}

	public void setMenu(List<String> menu) {
		this.menu = menu;
	}

	public Map<String, String> getUSER_AUTH_MAP() {
		return USER_AUTH_MAP;
	}

	public void setUSER_AUTH_MAP(Map<String, String> uSER_AUTH_MAP) {
		USER_AUTH_MAP = uSER_AUTH_MAP;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}