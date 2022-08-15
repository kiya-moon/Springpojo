package com.springpojo.app.user.service;

import org.springframework.stereotype.Service;

import com.springpojo.app.user.repository.UserRepository;
import com.springpojo.app.userDTO.User;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	// 중복확인
	public int overlappedID(User user) throws Exception{
		int result = userRepository.overlappedID(user);
		return result;
	}
}
