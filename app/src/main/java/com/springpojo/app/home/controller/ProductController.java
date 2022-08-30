package com.springpojo.app.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springpojo.app.DTO.Product;
import com.springpojo.app.service.AddService;

@Controller
public class ProductController {
	private final AddService addService;
	
	@Autowired
	public ProductController(AddService addService) {
		this.addService = addService;
	}
	
	// 상품등록페이지 이동
	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("Product", new Product());
		return "contents/addProduct";
	}
	
	// 상품 등록
	@PostMapping("/product")
	public String add(Product product) {
		addService.saveProduct(product);
		return "contents/product";
	}
	
//	@GetMapping("/product")
//	public String productPlus() {
//		return "contents/product";
//	}
	
//	@PostMapping("/price")
//	public String price(Model model) {
//		Product product = new Product();
//		product.setProductPrice(model)
//	}
	
}
