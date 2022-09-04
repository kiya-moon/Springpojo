package com.springpojo.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.MypageRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class MypageService {
	
	private final MypageRepository mypageRepository;

	public Long updateUser(Users updateParam) {
		mypageRepository.save(updateParam);
		return updateParam.getId();
	}
	
	public Users findById(Long id) {
		return mypageRepository.findById(id);
	}
}
