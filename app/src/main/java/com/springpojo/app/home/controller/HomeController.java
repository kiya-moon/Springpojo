package com.springpojo.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.UserRepository;
import com.springpojo.app.session.Login;
import com.springpojo.app.session.SessionManager;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
    private final UserRepository userRepository;

    private final SessionManager sessionManager;


	//@GetMapping("/")
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
	

    @GetMapping("/")
    public String homeLoginV3ArgumentResolver(@Login Users users
            , Model model) {
        // 세션에 회원 데이터가 없으면 home
        if (users == null) {
            return "/contents/home";
        }

        // 세션이 유지되면 로그인 된 상태의 홈으로 이동
        model.addAttribute("users", users);

        return "/contents/home";
    }

}
