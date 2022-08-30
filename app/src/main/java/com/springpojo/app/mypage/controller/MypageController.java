package com.springpojo.app.mypage.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.MypageRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mypage/mypage")
@RequiredArgsConstructor
public class MypageController {

	private final MypageRepository mypageRepository;
	
	@GetMapping
	public String items(Model model) {
		List<Users> users = mypageRepository.findAll();
		model.addAttribute("users", users);
		return "mypage/mypage";
	}
	
	@GetMapping("/{UserId2}")
	public String editForm(@PathVariable Long UserId2, Model model){
		Users user = mypageRepository.findById(UserId2);
		model.addAttribute("user", user);
		return "mypage/mypage";
	}
	
	/*
	 * 테스트용 데이터 추가
	 */
	@PostConstruct
	public void init() {
		mypageRepository.save(new Users("testA", "test1", "조혜진", "20220101", "heajin0305@naver.com","01012345678"));
	}
	
	
	
	
	
}
