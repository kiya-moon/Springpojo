package com.springpojo.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "contents/home";
	}

//	@GetMapping("/add")
//	public String add() {
//		return "contents/addProduct";
//	}

//	@GetMapping("/product")
//	public String product() {
//		return "contents/product";
//	}

	public String about() {
		return "about";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/shop")
	public String shop() {
		return "shop";
	}

	// 로그인 페이지
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}

	// 회원가입
	@GetMapping("/signup")
	public String signup() {
		return "login/signup";
	}

	// 이용약관
	@GetMapping("/agree")
	public String agree(Model model) {
		return "/login/agree";
	}

	// 마이페이지
//	@GetMapping("/mypage")
//	public String mypage(Model model) {
//		return "mypage/mypage";
//	}

}

