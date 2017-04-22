package com.multiple.common.service;

import java.util.Date;
import java.util.List;

import com.multiple.common.exception.DuplicateEmailException;
import com.multiple.common.exception.DuplicateLoginException;
import com.multiple.common.exception.NoSuchUserException;
import com.multiple.common.exception.PasswordException;
//import com.multiple.common.model.MemberType;
//import com.multiple.common.model.Role;
import com.multiple.common.model.User;
//import com.multiple.common.model.UserStatus;

/**
 * Service interface for User.
 * 
 * @author Priyanka
 */
public interface UserService {

	User save(User user);

	void sendRegstrationMail(User user, String compName, String url) throws DuplicateEmailException, DuplicateLoginException;

	User update(User user);

//	public List<User> findByStatus(UserStatus status);

	User findById(long userId) throws NoSuchUserException;

//	User findByLoginId(String loginId) throws NoSuchUserException;

	User findByEmailId(String emailId) throws NoSuchUserException;

//	User findByPasswordToken(String token) throws NoSuchUserException;

//	User changePassword(long userId, String password, String cPassword)
//			throws NoSuchUserException, PasswordException;
//
//	User resetMemberPassword(long userId, String oldpassword, String password,
//			String confirmPassword) throws NoSuchUserException,
//			PasswordException;

	User findByToken(String token) throws NoSuchUserException;

//	public User changeAccountInfo(long userId, String userEmail,
//			String oldPassword, String newPassword, String rePassword)
//			throws NoSuchUserException, PasswordException;

	public void updateAll(List<User> userList);

//	public List<User> findByRoleAndStatus(Role role, UserStatus status);

//	User activateUser(long userId) throws NoSuchUserException;
//
//	User inActivateUser(long userId) throws NoSuchUserException;

	User saveUser(User user) throws DuplicateEmailException,
			DuplicateLoginException;

//	public User updateMemberType(long userId, MemberType memberType);

//	public long findCount(MemberType type,UserStatus status);

	User updateUser(long userId, String firstName, String lastName,
			String email, String mobile) throws DuplicateLoginException,
			NoSuchUserException;

	User findByMobile(String mobile) throws NoSuchUserException;

	

	/*User save(String firstName, String lastName, String loginId,
			String password, String emailId, String mobile,
			 Long cityId,
			Long stateId, Long countryId, String pincode, String address,
			String gender,Date birthdayDate) throws DuplicateEmailException, DuplicateLoginException;*/
	

	
	

	
	
	
	
	
	
	
}