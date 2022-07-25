package com.springpojo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "contents/home";
	}
	
	@GetMapping("/add")
	public String add() {
		return"contents/addProduct";
	}
	
	@GetMapping("/product")
	public String product() {
		return "contents/product";
	}
	
	@GetMapping("/about")
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
}
