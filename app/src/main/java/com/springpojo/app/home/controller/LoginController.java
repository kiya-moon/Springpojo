package com.springpojo.app.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.service.LoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {
	
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	// 로그인
	// 유저 정보를 받아와서 로그인 성공이면 true, 실패면 false
	@PostMapping("/login.do")
	public String login(Users users, Model model) {
		boolean aboutLogin = loginService.login(users);
		
		if(!aboutLogin) {
			model.addAttribute("loginMessage", "아이디 혹은 비밀번호가 일치하지 않습니다.");
			System.out.println("로그인 실패");
		}
		
		return "redirect:/";
	}
	
	// 회원가입
	@PostMapping("/signup.do")
	public String join(Users users) {
		loginService.saveUser(users);
		
		return "redirect:/";
	}
	
}