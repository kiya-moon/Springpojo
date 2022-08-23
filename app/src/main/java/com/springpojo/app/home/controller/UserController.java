//package com.springpojo.app.home.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.springpojo.app.DTO.User;
//import com.springpojo.app.repository.UserRepository;
//import com.springpojo.app.service.LoginService;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//public class UserController {
//
//	private UserRepository userRepository;
//	
//	@Autowired
//	private LoginService loginService;
////	private final SessionManager sessionManager;
//
//	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
//	public String joinUs(User user) {
//		
//		loginService.joinUser(user);
//		return "redirect:/";
//	}
//	
//	
//}
