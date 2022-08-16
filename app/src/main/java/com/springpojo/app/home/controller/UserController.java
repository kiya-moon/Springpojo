package com.springpojo.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springpojo.app.repository.UserRepository;
import com.springpojo.app.service.UserService;
import com.springpojo.app.DTO.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	private UserRepository user;
	private UserService userService;
	
//	public UserController(UserRepository user) {
//		this.user = user;
//	}
	
	// 로그인
	@PostMapping("/login")
	public String login(String inputUserId, String inputUserPw) {
		log.info("id : {} , pw : {}", inputUserId, inputUserPw);
		User user = this.user.findUser(inputUserId, inputUserPw);
		if(user != null) {
			return "redirect:/";
		}
		
		return "loginFail";
	}
	
	// 회원가입
	@PostMapping("/signup/new")
	public String create(User user) {
		this.user.save(user);
		return "redirect:/";
	}
	
	// 중복확인
	@ResponseBody		// 값 변환을 위해 필요
	@GetMapping("idCheck")
	public int oberlappedUserId(User user) throws Exception{
		int result = userService.overlappedID(user);
		return result;
	}
	
	
}
