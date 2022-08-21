package com.springpojo.app.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/add")
	public String addProduct() {
		return "contents/addProduct";
	}
	
	@PostMapping("/product")
	public String add(@ModelAttribute Product product) {
		System.out.println("productController");
		System.out.println(product.getProductName());
		System.out.println(product.getProductCategory());
		addService.saveProduct(product);
		return "contents/product";
	}
	
	
}
