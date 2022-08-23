//package com.springpojo.app.home.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.springpojo.app.DTO.User;
//import com.springpojo.app.service.LoginService;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//public class LoginController {
//	
//	@Autowired
//	private LoginService loginService;
//	
//	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
//	public String login(User user, Model model) {
//		User userinfo = loginService.loginUser(user.getUserId(),user.getUserPw());
//		
//		if(userinfo==null) {
//			model.addAttribute("loginMessage", "아이디 혹은 비밀번호가 일치하지 않습니다.");
//		}
//		
//		return "redirect:/";
//	}
//	
//}