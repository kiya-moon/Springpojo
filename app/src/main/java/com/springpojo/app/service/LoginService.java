package com.springpojo.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.LoginRepository;
import com.springpojo.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class LoginService {
	
	private final UserRepository userRepository;
	private final LoginRepository loginRepository;

	// 회원가입
	public String saveUser(Users users) {
		userRepository.save(users);
		return users.getUserId();
	}
	
	// 로그인
	public Users login(String userId) throws Exception{
		
		return userRepository.login(userId);
	}

	public String findId(String userName, String userPhone) throws Exception {
		System.out.println("findId");
		return userRepository.findId(userName, userPhone);
		// TODO Auto-generated method stub
	
	}
	
	public String findPw(String userId, String userName, String userPhone) throws Exception {
		
		return userRepository.findPw(userId, userName, userPhone);
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
