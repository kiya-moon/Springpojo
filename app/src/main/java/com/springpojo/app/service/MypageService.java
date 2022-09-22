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

	public Long updateUser(Users updateParam) {
		mypageRepository.save(updateParam);
		return updateParam.getId();
	}
	
	public Users findById(Long id) {
		return mypageRepository.findById(id);
	}
	
	// 입찰목록조회
	public CartList getcart(Long BidJoinNum, Long userid){
		return mypageRepository.getcart(BidJoinNum,userid);
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
