package com.springpojo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpojo.app.DTO.User;
import com.springpojo.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	@Autowired
	private final UserRepository userRepository;
	
	public void joinUser(User user) {
		user.setUserRole("USER");
		userRepository.save(user);
	}
	
	public User loginUser(String id, String pw) {
		User user = userRepository.selectUserInfo(id, pw);
		return user;
	}
	
}
