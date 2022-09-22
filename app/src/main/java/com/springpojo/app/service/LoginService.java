package com.springpojo.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	
	public Users login(String userId) throws Exception{
		
		return userRepository.login(userId);
	}
	
//	public String joinUser(User user) {
////		user.setUserRole("USER");
//		userRepository.save(user);
//		return user.getUserId();
//	}
	
	// 로그인
//	public boolean login(Users users) {
//		Users findUser = userRepository.findByUserId(users.getUserId());
//		
//		if(findUser == null) {
//			return false;
//		} 
//		if(findUser != null && findUser.getUserPw().equals(users.getUserPw())) {
//			return true;
//		}
//		return true;
//			
//		}
	
//	public User loginUser(String id, String pw) {
//		User user = userRepository.selectUserInfo(id, pw);
//		return user;
//	}
	
}




















