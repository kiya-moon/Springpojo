package com.springpojo.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.MyPageRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class MypageService {
	
	private final MyPageRepository myPageRepository;

	public Long updateUser(Long id, Users updateParam) {
		myPageRepository.save(id, updateParam);
		return updateParam.getId();
	}
	
	public Users findById(Long id) {
		return myPageRepository.findById(id);
	}
}
