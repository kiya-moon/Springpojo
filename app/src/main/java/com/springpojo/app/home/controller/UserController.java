package com.springpojo.app.home.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springpojo.app.DTO.User;
import com.springpojo.app.repository.UserRepository;
import com.springpojo.app.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("login")
public class UserController {

	private final UserRepository userRepository;
	private UserRepository user;
	private LoginService loginService;
//	private final SessionManager sessionManager;

	@GetMapping("signup")
	public String addForm(@ModelAttribute("user") User user) {
		return "login/signup";
	}

	// 회원가입
	@PostMapping("signup")
	public String save(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "login/signup";
		}

		userRepository.save(user);
		
		return "redirect:/";
	}
	
	
	// 회원가입
//		@PostMapping("/signup")
//		public String create(User user) {
//			this.user.save(user);
//			return "redirect:/";
//		}
}
