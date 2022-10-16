package com.springpojo.app.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.service.MypageService;


public class MypageController {
	
	private final MypageService mypageService;
	
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	

	// 회원업데이트
	@PostMapping("/mypage")
	public String mypageUpdate(Users updateParam, String userId) {
		mypageService.updateUser(updateParam);
		return "mypage/mypage";
	}	
	
	// 마이페이지 // 수정예정
	@GetMapping("/mypage/{userId}") 
	public String mypage(@PathVariable String userId, Model model) {
		System.out.println(userId);
		Users users = mypageService.findById(userId);
		System.out.println(users);
		model.addAttribute("users", users);
		return "mypage/mypage";
	}
	
	//입찰중인물건
	@GetMapping("/mypage/{BidJoinNum}{userId}")
	public String mypagegetcar(Long BidJoinNum, String userId) {
		return "mypage/mypage";
	}
	
	}
	
		
		
	
	

