package com.springpojo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class LoginService {
	
	private final UserRepository userRepository;

	// 회원가입
	public Long saveUser(Users users) {
		userRepository.save(users);
		return users.getId();
	}
	
//	public String joinUser(User user) {
////		user.setUserRole("USER");
//		userRepository.save(user);
//		return user.getUserId();
//	}
	
	// 로그인
	public boolean login(Users users) {
		Users findUser = userRepository.findByUserId(users.getUserId());
		
		if(findUser == null) {
			return false;
		} 
		
		if (findUser.getUserPw().equals(users.getUserPw())){
			return false;
		}
		
		return true;
			
		}
	
//	public User loginUser(String id, String pw) {
//		User user = userRepository.selectUserInfo(id, pw);
//		return user;
//	}
	
}



















