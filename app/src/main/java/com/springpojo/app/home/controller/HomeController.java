package com.springpojo.app.home.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springpojo.app.DTO.Product;
import com.springpojo.app.service.AddService;
import com.springpojo.app.service.LikeService;
import com.springpojo.app.service.MypageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	private final AddService addService;
	
	@Autowired
	   public HomeController(AddService addService, MypageService mypageService, LikeService likeService) {
	      this.addService = addService;
	   }

	@GetMapping("/")
	public String home(Model model) {
		
		List<Product> productList = addService.findProducts(productCategory);
	      
	      System.out.println(productList);
	      
	      long dday = new Date().getTime();
	      
	      for (int i = productList.size()-1; i >= 0; i--) {
	         long end = (java.sql.Timestamp.valueOf(productList.get(i).getEndDate())).getTime();
	         long calc = dday - end;
	         System.out.println("i = " + i);
	         
	         if(end - dday <= 0) {
	            System.out.println("if문 안에 몇 번 들어와? : " + i);
	            productList.remove(i);
	         }
	      }
	      
	      System.out.println(productList);
	      
	      model.addAttribute("productList", productList);
		return "contents/home";
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

