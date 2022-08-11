package com.springpojo.app.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.user.repository.UserRepository;
import com.springpojo.app.userDTO.User;

@Service
@Transactional
public class UserService {
	
	UserRepository userRepository;
	
	public int overlappedID(User user) throws Exception{
		int result = userRepository.overlappedID(user);
		
		return result;
	}
}
