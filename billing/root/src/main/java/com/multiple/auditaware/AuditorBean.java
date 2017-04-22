package com.multiple.auditaware;

import com.multiple.common.model.User;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;


public class AuditorBean implements AuditorAware<User> {

	public User getCurrentAuditor() {
//		User user=new User();
//		user.setUserId(Long.valueOf("1"));
//		user.setAgreedToTermsOfUse(true);
//		user.setLoginId("abc");
//		user.setPassword("abc");
//		user.setEmailId("deb.gold007@gmail.com");
//		user.setEmailAddressVerified(false);
////		user.setMobileNumberVerified(false);
//		user.setStatus(1);
//		user.setMobile("8655719609");
//		user.setRole(Role.GORMET7_ADMIN);
//		user.setFirstName("Deb");
////		user.setPortraitId(122);
//		return user;
		User user = null;
		try{
			user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e){
			user = null;
		}

	    return user;
	}

}
