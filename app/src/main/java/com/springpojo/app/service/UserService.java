package com.springpojo.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	public Optional<Users> idChk(String userId) throws Exception{
		System.out.println(2);
		
		return userRepository.idChk(userId);
	}

}
