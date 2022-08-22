package com.springpojo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Product;
import com.springpojo.app.repository.AddRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AddService {

	private final AddRepository addRepository;
	
	// 물품등록
	public Long saveProduct(Product product) {
		addRepository.save(product);
		return product.getId();
	}
	
	// 전체 물품 조회
	public List<Product> findProducts(){
		return addRepository.findAll();
	}
	
}
