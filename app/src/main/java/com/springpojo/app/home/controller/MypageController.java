
package com.springpojo.app.home.controller;

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
	public String mypageUpdate(Users updateParam, Long id) {
		mypageService.updateUser(updateParam);
		return "mypage/mypage";
	}	
	
	// 마이페이지
	@GetMapping("/mypage/{id}")
	public String mypage(@PathVariable Long id, Model model) {
		Users users = mypageService.findById(id);
		model.addAttribute("users", users);
		return "mypage/mypage";
	}
	
}
