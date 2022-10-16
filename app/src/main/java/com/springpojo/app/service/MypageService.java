package com.springpojo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.CartList;
import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.MypageRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class MypageService {
	
	private final MypageRepository mypageRepository;

	public String updateUser(Users updateParam) {
		mypageRepository.save(updateParam);
		return updateParam.getUserId();
	}
	
	public Users findById(String userId) {
		System.out.println(userId);
		return mypageRepository.findById(userId);
	}
	
	// 입찰목록조회
	public CartList getcart(Long BidJoinNum, String userId){
		return mypageRepository.getcart(BidJoinNum,userId);
	}
	
//	// 아래는 개발대기예정 안할확률높음
//	/* 카트 추가 */
//	public int addCart(CartList cartList) {
//		return 0;
//	}
//	
//	/* 카트 삭제 */
//	public int deleteCart(int cartId) {
//		return 0;
//	}
//	
//	/* 카트 수량 수정 */
//	public int modifyCount(CartList cartList) {
//		return 0;
//	}
//	
//	/* 카트 확인 */
//	public CartList checkCart(CartList cartList) {
//		return null;
//	}
}
