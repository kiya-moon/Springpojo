package com.springpojo.app.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// 상품 페이지
	@GetMapping("/product/{id}")
	public String product(@PathVariable Long id, Model model) {
		System.out.println("asd");
		Product product = addService.findById(id);
		model.addAttribute("product", product);
		return "contents/product";
	}
	
	
	// 상품 등록
	@PostMapping("/product")
	public String add(@ModelAttribute("product") Product product, MultipartFile upload_box, RedirectAttributes redirectAttributes) throws Exception {
		Product savedProduct = addService.saveProduct(product, upload_box);
		
		redirectAttributes.addAttribute("id", savedProduct.getId());
		return "redirect:/product/{id}";
	}
	
//	@GetMapping("/product")
//	public String productPage(@PathVariable Long id, Model model) {
//		return "contents/product";
//	}
	
	// 상품 리스트
	@GetMapping("/productList")
	public String prodcutList(@RequestParam("productCategory") String productCategory, Product product, Model model) {
		List<Product> productList = addService.findProducts(productCategory);
		
		model.addAttribute("productList", productList);
		return "/contents/productList";
	}
	
	// 상품 금액 업데이트
	@PostMapping("/new_price")
	public String priceUpdate(Product product, Long new_price, RedirectAttributes redirectAttributes) {
		addService.priceUpdate(product, new_price);
		
		redirectAttributes.addAttribute("id", product.getId());
		
		return "redirect:/product/{id}";
		
	}
	
//	@GetMapping
//	public String productList(Model model, String productCategory) {
//		List<Product> productList = addService.findProducts(productCategory);
//		model.addAttribute("productList", productList);
//		
//		return "/contents/productList";
//	}

	
//	@PostMapping("/price")
//	public String price(Model model) {
//		Product product = new Product();
//		product.setProductPrice(model)
//	}
	
}
