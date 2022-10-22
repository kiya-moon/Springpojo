package com.springpojo.app.home.controller;


import java.io.PrintWriter;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String login(String userId,String userPw, HttpSession session, HttpServletRequest req, Model model, HttpServletResponse resp) throws Exception {
		try {
			
			Users login = loginService.login(userId);
		}catch (NoResultException e) {
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('아이디, 비밀번호를 확인해주세요.');</script>");
			return "login/login";
		}
		resp.setContentType("text/html;charset=euc-kr");
//		if(login == null || !login.getUserPw().equals(userPw)) {
//		}
		
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
	
	// 아이디 찾기
		@GetMapping("/forgotId")
		public String forgotId(Model model) {
			return "login/forgotId";
		}

		// 비밀번호 찾기
		@GetMapping("/forgotPw")
		public String forgotPw(Model model) {
			return "login/forgotPw";
		}
	
	@PostMapping("/forgotId")
//	public String findId(Users user, Model model) throws Exception {
	public String findId(Users user, Model model, HttpServletRequest req) throws Exception{
		
		String userName = req.getParameter("userName");
		String userPhone = req.getParameter("userPhone");
		
		System.out.println(userName);
		System.out.println(userPhone);
		String id = loginService.findId(userName, userPhone);
		
		 req.setAttribute("id",id);
		 
	        if(id == null){
	        	model.addAttribute("msg","일치하는 회원정보가 없습니다.");
	        	return "login/forgotId";
	        } else {
	        	model.addAttribute("id", user.getUserId());
	        	model.addAttribute("msg","아이디는 "+ id +" 입니다.");
	        	
	        	return "contents/home";
	        }
		
		
	}
	
	@PostMapping("/forgotPw")
	public String findPw(Users user, Model model, HttpServletRequest req) throws Exception {
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String userPhone = req.getParameter("userPhone");
		
		String pw = loginService.findPw(userId, userName, userPhone);
		
		req.setAttribute("pw", pw);
		
		if(pw == null) {
			model.addAttribute("msg", "일치하는 회원정보가 없습니다.");
			return "login/forgotPw";
		} else {
			model.addAttribute("pw", user.getUserPw());
			model.addAttribute("msg", "비밀번호는 "+pw + "입니다.");
			
			return "contents/home";
		}
		
	}
}