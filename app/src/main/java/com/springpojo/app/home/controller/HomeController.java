package com.springpojo.app.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springpojo.app.DTO.User;
//import com.springpojo.app.repository.UserRepository;
import com.springpojo.app.session.SessionConst;
import com.springpojo.app.session.SessionManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	private final SessionManager sessionManager;

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
	public String login(Model model) {
		return "login/login";
	}

	// 회원가입
	@GetMapping("/signup")
	public String signup(Model model) {
		return "login/signup";
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

	// 상품목록리스트
	@GetMapping("/productList")
	public String prodcutList() {
		return "/contents/productList";
	}

	// 이용약관
	@GetMapping("/agree")
	public String agree(Model model) {
		return "/login/agree";
	}

	// 마이페이지
	@GetMapping("/mypage")
	public String mypage(Model model) {
		return "/mypage/Edit_member_information";
	}

}
