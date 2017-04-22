package com.multiple.common.service.impl;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.model.User;
import com.multiple.common.model.mail.EmailData;
import com.multiple.common.service.ForgotPasswordAndLoginService;
import com.multiple.common.service.SendMailService;
import com.multiple.common.service.UserService;
import com.multiple.common.util.PropsValues;

@Service
public class ForgotPasswordAndLoginServiceImpl implements ForgotPasswordAndLoginService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PropsValues props;
	
	@Autowired
	private SendMailService mailService;

	/*@Override
	public void sendForgetPasswordLink(String loginId, String url) throws NoSuchUserException {
		User user = userService.findByLoginId(loginId);
		double ran = Math.random() * Math.random();
		if(user != null){
			user.setPasswordResetKey(String.valueOf(ran));
			userService.save(user);
			url = url+"/"+"ResetPassword?token="+ran;
			EmailData data = new EmailData();
			data.setTo(user.getEmailId());
			data.setSubject("Password Reset Link");
			data.setMailTemplate(props.FORGOT_PASSWORD);
			data.setFrom(props.EMAIL_FROM);
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("UserName", user.getFirstName()+" "+user.getLastName());
			model.put("URL", url);
			data.setModel(model);
			mailService.sendMail(data);
		}
	}*/
	
	

	/*@Override
	public void sendForgotLoginMail(String emailId)  throws NoSuchUserException{
		User user = userService.findByEmailId(emailId);
		if(user != null){
			EmailData data = new EmailData();
			data.setTo(emailId);
			data.setFrom(props.EMAIL_FROM);
			data.setSubject("Login Details");
			data.setMailTemplate(props.FORGOT_LOGIN);
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("LoginId", user.getLoginId());
			model.put("UserName", user.getFirstName()+" "+user.getLastName());
			data.setModel(model);
			mailService.sendMail(data);
		}
	}*/



//	@Override
//	public void updatePassword(String token, String newPassword) throws NoSuchUserException {
//		User user = userService.findByPasswordToken(token);
//		if(user != null){
//			user.setPassword(newPassword);
//			user.setPasswordModifiedDate(new Date());
//			//user.setPasswordResetKey(null);
//			userService.save(user);
//		}
//		else{
//			throw new NoSuchUserException();
//		}
//		
//	}
//
//	@Override
//	public void sendForgetPasswordLink(String loginId, String url)
//			throws NoSuchUserException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void sendForgotLoginMail(String emailId) throws NoSuchUserException {
//		// TODO Auto-generated method stub
//		
//	}

	
}
