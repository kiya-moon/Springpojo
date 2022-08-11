package com.springpojo.app.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springpojo.app.user.service.UserService;
import com.springpojo.app.userDTO.User;

@Controller
public class UserController {

	UserService userService;
	
	@ResponseBody // 값 변환을 위해 필요
	@GetMapping("/idcheck")	// 아이디 중복확인을 위한 값으로 따로 매핑
	public int overlappedID(User user) throws Exception{
		int result = userService.overlappedID(user); // 중복확인한 값을 int로 받아준다.
		
		return result;
	}
}
