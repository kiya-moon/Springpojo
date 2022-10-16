package com.springpojo.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.CartList;
import com.springpojo.app.DTO.Users;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MypageRepository {
	
	@PersistenceContext
	private final EntityManager em;
	
	// 특정 회원 찾기
	public Users findById(String userId) {
		System.out.println(userId);
		return em.createQuery("select u from Users u where u.userId = :id", Users.class).setParameter("id", userId).getSingleResult();
	}
	
	// 마이페이지 회원정보 업데이트
	public void save(Users updateParam) {
//		Users updateUser = findById(id);
//		updateUser.setUserPw(updateParam.getUserPw());
//		updateUser.setUserEmail(updateParam.getUserEmail());
//		updateUser.setUserBirth(updateParam.getUserBirth());
//		updateUser.setUserName(updateParam.getUserName());
//		updateUser.setUserPhone(updateParam.getUserPhone());
//		
//		em.persist(updateUser);
		
		em.merge(updateParam);
		
		// return updateUser >> return 하려면 void > Users로 변경해야 하는데 필요한지 모르겠음
	}
	
	// +
	//카트목록조회
	
	//입찰중인 물건번호 조회
	public CartList getcart (Long BidJoinNum, String userId) {
		return (CartList) em.createQuery("select * from CartList c "
				+ "where BidJoinNum = #{BidJoinNum} and userid = #{userId}");
	}
	
	// 낙찰된 물품목록
	
	// 관심상품목록
	
	// 판매물품 등록목록
	
	
	
}












