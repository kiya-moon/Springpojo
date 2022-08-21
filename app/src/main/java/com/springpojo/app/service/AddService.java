package com.springpojo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Product;
import com.springpojo.app.repository.AddRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddService {

	private final AddRepository addRepository;
	
	@Transactional
	public void saveProduct(Product product) {
		addRepository.save(product);
		System.out.println("productService");
	}
	
	public List<Product> findProducts(){
		return addRepository.findAll();
	}
	
}
