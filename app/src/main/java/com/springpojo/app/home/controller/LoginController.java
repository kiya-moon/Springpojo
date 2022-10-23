package com.springpojo.app.home.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.service.LoginService;
import com.springpojo.app.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {
	
	private final LoginService loginService;
	private final UserService userService;
	
//	@Autowired
//	public LoginController(LoginService loginService) {
//		this.loginService = loginService;
//	}
//	
//	// 로그인
//	// 유저 정보를 받아와서 로그인 성공이면 true, 실패면 false
//	@PostMapping("/login.do")
//	public String login(Users users, Model model, HttpSession session) {
//		boolean aboutLogin = loginService.login(users);
//		
//		if(!aboutLogin) {
//			model.addAttribute("loginMessage", "아이디 혹은 비밀번호가 일치하지 않습니다.");
//			System.out.println("로그인 실패");
//		} else {
//			System.out.println("로그인 성공");
//			model.addAttribute("user", aboutLogin);
//			session.setAttribute("user", aboutLogin);
//		}
//		
//		return "redirect:/";
//	}
	
	// 로그인
	@PostMapping("/login.do")
	public String login(String userId,String userPw, HttpSession session, HttpServletRequest req, Model model, HttpServletResponse resp, RedirectAttributes rattr) throws Exception {
			try {
			Users login = loginService.login(userId);
			PrintWriter out = resp.getWriter();
			if(login == null || !login.getUserPw().equals(userPw)) {
			out.println("<script>alert('아이디, 비밀번호를 확인해주세요.');</script>");
			return "login/login";
			}
			} catch (NoResultException e) {
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('아이디, 비밀번호를 확인해주세요.');</script>");
				return "login/login";
			}

		session = req.getSession();
		session.setAttribute("userId", userId);
		session.setAttribute("user", loginService.login(userId));
		System.out.println(session.getAttribute("userId"));
		return "contents/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "contents/home";
	}
	
	
	// 회원가입
	@PostMapping("/signup.do")
	public String join(Users users) {
		loginService.saveUser(users);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("/signup.do/idChk")
	public Optional<Users> idChk(String userId) throws Exception{
		System.out.println(1);
		System.out.println(userId);
		Optional<Users> result = userService.idChk(userId);
		return result;
	}
	
}