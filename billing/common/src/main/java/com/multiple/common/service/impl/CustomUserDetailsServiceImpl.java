package com.multiple.common.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.model.Role;
import com.multiple.common.model.User;
import com.multiple.common.service.UserService;
import com.multiple.kernel.exception.CustomException;

public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public UserDetails loadUserByUsername(String loginId)
			throws UsernameNotFoundException {
		User dbUser = null;
		try {
			dbUser = userService.findByMobile(loginId);
		} catch (NoSuchUserException e) {
			throw new BadCredentialsException(
					CustomException.AUTHENTICATION_FAILURE.getCode());
		}
		if (dbUser != null
//				&& dbUser.getStatus().getId() == UserStatus.Active.getId()
				) {
			dbUser.setGrantedAuthorities(getRoles(dbUser));
		} 
		System.out.println("User logged in succesfully");
		return dbUser;
	}

	private Collection<GrantedAuthority> getRoles(User user) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
		Role role = user.getRole();
		if (role != null) {
			authList.add(new SimpleGrantedAuthority(role.name()));
		}
		return authList;
	}

}
