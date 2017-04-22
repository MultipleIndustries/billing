package com.multiple.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.multiple.common.model.MemberType;
//import com.multiple.common.model.Role;
import com.multiple.common.model.User;
//import com.multiple.common.model.UserStatus;


public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.userId = ?1")
	User findById(long id);
	
//	@Query("select u from User u  where u.status = ?1")
//	List<User> findByStatus(UserStatus status);
	
//	@Query("select u from User u  where u.loginId = ?1")
//	User findByLoginId(String loginId);
	
	@Query("select u from User u where u.emailId = ?1")
	User findByEmailId(String emailId);
	
//	@Query("select u from User u where u.passwordResetKey = ?1")
//	User findByPasswordToken(String token);
	
	@Query("select u from User u where u.token = ?1")
	User findByToken(String token);
	
//	@Query("select u from User u  where u.role = ?1 and u.status = ?2")
//	List<User> findByRoleAndStatus(Role role, UserStatus status);
	
	@Query("select u from User u where u.mobile = ?1")
	User findByMobile(String mobile);
/*	@Query("select count(u) from User u where u.memberType=?1")
	long countByType(MemberType type);
	
	long countByMemberTypeAndStatus(MemberType type,UserStatus status);*/
}
