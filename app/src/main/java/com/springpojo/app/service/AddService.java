package com.springpojo.app.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

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
	Calendar cal = Calendar.getInstance();
	LocalTime date = LocalTime.now().withNano(0);
	DateFormat df = new SimpleDateFormat();
	// 물품등록
	public Long saveProduct(Product product) {
		addRepository.save(product);
		product.setStartDate(date);
		System.out.println(product.getProductDate());
		if(product.getProductDate().equals("day")) {
			product.setEndDate(date.plusHours(1));
		}
		System.out.println(product.getEndDate());
		return product.getId();
	}
	
	// 전체 물품 조회
	public List<Product> findProducts(){
		return addRepository.findAll();
	}
	
}
