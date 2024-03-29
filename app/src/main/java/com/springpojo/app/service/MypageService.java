package com.springpojo.app.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Product;
import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.MypageRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class MypageService {

	private LocalDateTime local = LocalDateTime.now();;

	private final MypageRepository mypageRepository;

	public Users findById(String userId) {
		System.out.println(userId);
		return mypageRepository.findById(userId);
	}

	// 회원탈퇴
	public int delete(HttpSession session, String userId) throws Exception {
		return mypageRepository.delete(session, userId);
	}

	// 상품 호출(입찰중인 물건)
	public List<Product> bid(String userId) {
		System.out.println("2222");
		return mypageRepository.bid(userId);
	}

	// 관심 상품
	public List<Product> like(String userId) {
		System.out.println("likeSE");
		return mypageRepository.like(userId);
	}

	// 판매물품
	public List<Product> sellProduct(String userId) {
		System.out.println("sellSE");
		return mypageRepository.sellProduct(userId);
	}

	// 낙찰물품

	public List<Product> successfulBid(HttpSession session){
		System.out.println("낙찰 서비스");
		
		return mypageRepository.successfulBid(session);
	}

}