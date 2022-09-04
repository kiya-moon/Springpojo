package com.springpojo.app.home.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class MyPageController {

	// 회원업데이트
	@PostMapping("/mypage")
	public String mypageUpdate() {
		return "mypage/mypage";
	}	
	
}
