package com.springpojo.app.home.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springpojo.app.DTO.Bid;
import com.springpojo.app.DTO.Product;
import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.MypageRepository;
import com.springpojo.app.service.MypageService;

@Controller
public class MypageController {

	private final MypageService mypageService;
	private final MypageRepository mypageRepository;

	@Autowired
	public MypageController(MypageService mypageService, MypageRepository mypageRepository) {
		this.mypageService = mypageService;
		this.mypageRepository = mypageRepository;
	}

	// 마이페이지 처음 불러오는거
	@GetMapping("/mypage/{userId}")
	public String mypage(@PathVariable String userId, Model model) {
		System.out.println(userId);
		Users users = mypageService.findById(userId);
		System.out.println(users);
		model.addAttribute("users", users);
		
//		System.out.println(userId);
//		userId = (String)session.getAttribute("userId");
//		model.addAttribute("users", userId);
		
		System.out.println("123");
//		List<Product> product = mypageRepository.product(userId);
		List<Product> product = mypageService.product(userId);

		List<Map<String, Object>> listMap = product;
//		List<Bid> bid = mypageService.bid(userId);
//		List<Product> product = mypageRepository.bid(userId);
		System.out.println(product.toString());
		System.out.println("234");
		model.addAttribute("product", product);
		
		
		return "mypage/mypage";
	}

	// 회원탈퇴
	@GetMapping("/delete.do")
	public String delete(HttpSession session, String userId) {
		try {
			int users = mypageService.delete(session, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원정보 수정
	@Transactional
	@PostMapping("/mypage/{userId}")
	public String changeUser(Users updateUser, Model model, @PathVariable String userId) {
		
		System.out.println("컨트1");
		mypageRepository.changeUsers(updateUser);
		System.out.println("컨트2");
		
		Users users = mypageService.findById(userId);
		model.addAttribute("users", users);
		return "mypage/mypage";
	}
	
	
}