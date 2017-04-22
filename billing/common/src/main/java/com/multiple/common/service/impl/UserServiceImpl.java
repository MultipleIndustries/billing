package com.multiple.common.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.exception.DuplicateEmailException;
import com.multiple.common.exception.DuplicateLoginException;
import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.exception.PasswordException;
//import com.multiple.common.model.Role;
import com.multiple.common.model.User;
//import com.multiple.common.model.UserStatus;
import com.multiple.common.model.location.CityMaster;
import com.multiple.common.model.location.CountryMaster;
import com.multiple.common.model.location.StateMaster;
import com.multiple.common.model.mail.EmailData;
import com.multiple.common.repository.UserRepository;
import com.multiple.common.service.SendMailService;
import com.multiple.common.service.UserService;
import com.multiple.common.util.PropsValues;
import com.multiple.kernel.exception.CustomException;

/**
 * Service implementation for User.
 * 
 * @author Priyanka
 */


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PropsValues props;

	@Autowired
	private SendMailService mailService;
	
	public User save(User user){
//		String encrypt = encryptPassword(user.getPassword());
//		user.setPassword(encrypt);
		if(user!=null)
		{
		user = userRepository.saveAndFlush(user);
		}
		return user;
	}

	private String encryptPassword(String password) {
//		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
//		String encrypt = encoder.encode(password);
//		return encrypt;
		return password;
	}

	public boolean passwordCompare(String rawPassword, String encodedPassword) {
//		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
//		return encoder.matches(rawPassword, encodedPassword);
		return rawPassword.equals(encodedPassword);
	}
	
//	public User updateMemberType(long userId, MemberType memberType) {
//		User user = userRepository.findOne(userId);
//		//user.setMemberType(memberType);
//		user = userRepository.save(user);
//		return user;
//	}

	@Override
	public void sendRegstrationMail(User user, String compName, String url) throws DuplicateEmailException, DuplicateLoginException 
	{
	

		double ran = Math.random() * Math.random();
		if (user != null) {
//			user.setPasswordResetKey(String.valueOf(ran));
			save(user);
			url = url + "/" + "ResetPassword?token=" + ran;

			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("adminName",
					user.getFirstName() + " " + user.getLastName());
			//model.put("name", universityName);
			model.put("emailAddress", user.getEmailId());
//			model.put("loginId", user.getLoginId());
			model.put("URL", url);

			EmailData data1 = new EmailData();
			data1.setTo(user.getEmailId());
			data1.setSubject("Welcome to multiple");
			data1.setFrom(props.EMAIL_FROM);
			data1.setModel(model);

			EmailData data2 = new EmailData();
			data2.setTo(props.EMAIL_TO_ADMIN);
			data2.setFrom(props.EMAIL_FROM);
			data2.setSubject("New Loan Application Added");
			data2.setModel(model);

//			if (user.getRole() == Role.INSTRUCTOR) {
//				data1.setMailTemplate(props.RESET_PASSWORD_FOR_INSTRUCTOR);
//				data2.setMailTemplate(props.RESTAURANT_ADMIN_DETAILS_MAIL);
//			} else if (user.getRole() == Role.BRAND_ADMIN) {
//				data1.setMailTemplate(props.RESET_PASSWORD_FOR_BRAND_ADMIN);
//				data2.setMailTemplate(props.BRAND_ADMIN_DETAILS_MAIL);
//			} else if (user.getRole() == Role.UNIVERSITY_ADMIN) {
//				data1.setMailTemplate(props.RESET_PASSWORD_FOR_UNIVERSITY_ADMIN);
//				data2.setMailTemplate(props.COMPANY_ADMIN_DETAILS_MAIL);
//			}else if(user.getRole() == Role.CORPORATE_ADMIN){
//				data1.setMailTemplate(props.RESET_PASSWORD_FOR_CORPORATE_ADMIN);
//				data2.setMailTemplate(props.CORPORATE_ADMIN_DETAILS_MAIL);
//			}else if(user.getRole() == Role.STUDENT){
//				data1.setMailTemplate(props.MEMEBER_DETAILS_MAIL);
//			}

			mailService.sendMail(data1);
			mailService.sendMail(data2);
		}
	}



	public User findById(long userId) throws NoSuchUserException {
		User user = userRepository.findById(userId);
		if (user == null) {
			throw new NoSuchUserException();
		}
		return user;
	}

//	@Override
//	public User findByLoginId(String loginId) throws NoSuchUserException {
//		User user = userRepository.findByLoginId(loginId);
//		
//		return user;
//	}

	@Override
	public User findByEmailId(String emailId) throws NoSuchUserException {
		User user = userRepository.findByEmailId(emailId);
		if (user == null) {
			throw new NoSuchUserException(CustomException.NO_SUCH_USER.getCode());
		}
		return user;
	}

//	@Override
//	public User findByPasswordToken(String token) throws NoSuchUserException {
//		User user = userRepository.findByPasswordToken(token);
//		if (user == null) {
//			throw new NoSuchUserException(CustomException.NO_SUCH_USER.getCode());
//		}
//		return user;
//	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

//	@Override
//	public User changePassword(long userId, String password, String cPassword)
//			throws NoSuchUserException, PasswordException {
//		User user = findById(userId);
//		if (password != null && password.equals(cPassword)) {
//			String encrypt = encryptPassword(password);
//			user.setPassword(encrypt);
//		} else {
//			throw new PasswordException(
//					CustomException.PASSWORD_EXCEPTION.getCode());
//		}
//		return userRepository.save(user);
//	}
//	
//	@Override
//	public User resetMemberPassword(long userId, String oldPassword, String password, String cPassword)
//			throws NoSuchUserException, PasswordException {
//		User user = findById(userId);
//		if(oldPassword.equals(user.getPassword())){
//			if (password != null && password.equals(cPassword)) {
//				String encrypt = encryptPassword(password);
//				user.setPassword(encrypt);
//			} else {
//				throw new PasswordException(
//						CustomException.PASSWORD_EXCEPTION.getCode());
//			}
//		}
//		else {
//			throw new PasswordException(
//					CustomException.OLD_PASSWORD.getCode());
//		}
//		return userRepository.save(user);
//	}
//
//	@Override
//	public User changeAccountInfo(long userId, String userEmail,
//			String oldPassword, String newPassword, String rePassword)
//			throws NoSuchUserException, PasswordException {
//		User user = findById(userId);
//		user.setEmailId(userEmail);
//		if (oldPassword.length() > 0) {
//			boolean match = passwordCompare(oldPassword, user.getPassword());
//			if (match) {
//				if (newPassword != null && newPassword.equals(rePassword)) {
//					if (newPassword.length() < 6) {
//						throw new PasswordException(
//								CustomException.PASSWORD_LENGTH.getCode());
//					} else {
//						String encrypt = encryptPassword(newPassword);
//						user.setPassword(encrypt);
//					}
//				} else {
//					throw new PasswordException(
//							CustomException.PASSWORD_EXCEPTION.getCode());
//				}
//			} else {
//				throw new PasswordException(
//						CustomException.OLD_PASSWORD.getCode());
//			}
//		}
//		userRepository.save(user);
//		return userRepository.findById(userId);
//	}

	@Override
	public User findByToken(String token) throws NoSuchUserException {
		return userRepository.findByToken(token);
	}
	
//
//	@Override
//	public List<User> findByRoleAndStatus(Role role, UserStatus status) {
//		List<User> userList = userRepository.findByRoleAndStatus(role, status);
//		return userList;
//	}

//	@Override
//	public User activateUser(long userId) throws NoSuchUserException {
//		User user = findById(userId);
//		user.setStatus(UserStatus.Active);
//		//user.setActive(true);
//		return userRepository.save(user);
//	}
//
//	@Override
//	public User inActivateUser(long userId) throws NoSuchUserException {
//		User user = findById(userId);
//		user.setStatus(UserStatus.Inactive);
//		//user.setActive(false);
//		return userRepository.save(user);
//	}
	
	
	public User updateUser(long userId, String firstName, String lastName,
			String email, String mobile) throws DuplicateLoginException,
			NoSuchUserException {
		try {
			User userMaster = findByEmailId(email);
			if (userMaster != null && userMaster.getUserId() != userId) {
				throw new DuplicateLoginException(
						CustomException.DUPLICATE_EMAIL.getCode());
			}
		} catch (NoSuchUserException e) {
			// Do nothing
		}
		User user = findById(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailId(email);
		user.setMobile(mobile);
		return update(user);
	}

	@Override
	public void updateAll(List<User> userList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User saveUser(User user) throws DuplicateEmailException,
			DuplicateLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByMobile(String mobile) throws NoSuchUserException   {
		// TODO Auto-generated method stub
		User user = userRepository.findByMobile(mobile);
		
		return user;
	}


	
/*	@Override
	public long findCount(MemberType type, UserStatus status) {
		return userRepository.countByMemberTypeAndStatus(type, status);
	}*/



	

}
