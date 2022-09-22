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
	
	@GetMapping("/product/{id}")
	public String product(@PathVariable Long id, Model model) {
		System.out.println("3");
		Product product = addService.findById(id);
		System.out.println(product.getImgPath());
		model.addAttribute("product", product);
		return "contents/product";
	}
	
	// 상품 등록
//	@PostMapping("/product")
//	public String add(Product product, Long id) {
//		addService.saveProduct(product);
//		return "contents/product";
//	}
	// 상품 등록
	@PostMapping("/product")
	public String add(@ModelAttribute("product") Product product, MultipartFile upload_box, RedirectAttributes redirectAttributes) throws Exception {
		Product savedProduct = addService.saveProduct(product, upload_box);
		System.out.println(product.getImgPath());
		redirectAttributes.addAttribute("id", savedProduct.getId());
		return "redirect:/product/{id}";
	}
	
	@GetMapping("/product")
	public String productPage(@PathVariable Long id, Model model) {
		return "contents/product";
	}
	
	// 상품 리스트
	@GetMapping("/productList")
	public String prodcutList(@RequestParam("productCategory") String productCategory, Product product, Model model) {
		System.out.println(productCategory);
		List<Product> productList = addService.findProducts(productCategory);
		
		model.addAttribute("productList", productList);
		return "/contents/productList";
	}
	
	
	
//	@PostMapping("/delete")
//	@ResponseBody
//	public Product delete(@RequestBody Product product) {
//		System.out.println("aaaaa");
//		Product deleteProduct = addService.deleteProduct(product);
//		
//		return product;
//	}
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
