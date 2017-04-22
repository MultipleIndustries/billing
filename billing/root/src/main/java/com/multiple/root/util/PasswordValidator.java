package com.multiple.root.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.model.User;
import com.multiple.common.service.UserService;


public class PasswordValidator {

	@Autowired
	private  UserService userService;
	
	public static String ACCESS_GRANTED = "access-grant";
	public static String PASS_EXPIRED = "pass-expired";
	public static String WRONG_PASSWORD = "wrong-password";
	public static String NO_SUCH_USER = "no-such-user";
	
	
	public  String customUserAuthentication(String userName,String password){
		try {
			User user=userService.findByMobile(userName);
			if(user==null)
				throw new NoSuchUserException();
			if(user.getPassExpiryDate()==null||user.getPassExpiryDate().after(new Date())){
				return PASS_EXPIRED;
			}else{
				if(!user.getPassword().equals(password)){
					return WRONG_PASSWORD;
				}
			}
		} catch (NoSuchUserException e) {
			return NO_SUCH_USER;
		}
		return ACCESS_GRANTED;
	}
	
}
