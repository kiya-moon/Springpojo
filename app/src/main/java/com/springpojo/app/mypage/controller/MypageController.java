package com.springpojo.app.mypage.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.MypageRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mypage/mypage")
//@RequiredArgsConstructor
public class MypageController {
	
	@GetMapping
	public String items(Model model) {
		List<Users> users = mypageRepository.findAll();
		model.addAttribute("users", users);
		return "mypage/mypage";
	}
	
	@GetMapping("/{id}")
	public String editForm(@PathVariable Long id, Model model){
		Users users = mypageRepository.findById(id);
		model.addAttribute("users", users);
		return "mypage/mypage";
	}
	
	/*
	 * 테스트용 데이터 추가
	 */
	@PostConstruct
	public void init() {
		mypageRepository.save(new Users("testA", "test1", "조혜진", "20220101", "heajin0305@naver.com","01012345678"));
	}
