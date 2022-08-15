package com.springpojo.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springpojo.app.userDTO.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	// 회원가입
	@Query("select u from User u where UserId = :UserId and UserPw = :UserPw")
	User findUser(String UserId, String UserPw);
	
	// 중복확인
	public int overlappedID(User user) throws Exception;
}
