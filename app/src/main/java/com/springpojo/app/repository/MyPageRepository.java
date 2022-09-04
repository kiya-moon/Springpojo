package com.springpojo.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Users;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyPageRepository {
	
	@PersistenceContext
	private final EntityManager em;
	
	// 특정 회원 찾기
	public Users findById(Long id) {
		return em.createQuery("select u from Users u where u.id = :id", Users.class).setParameter("id", id).getSingleResult();
	}
	
	// 마이페이지 회원정보 업데이트
	public void save(Long id, Users updateParam) {
		Users updateUser = findById(id);
		updateUser.setUserPw(updateParam.getUserPw());
		updateUser.setUserEmail(updateParam.getUserEmail());
		updateUser.setUserBirth(updateParam.getUserBirth());
		updateUser.setUserName(updateParam.getUserName());
		updateUser.setUserPhone(updateParam.getUserPhone());
		
		em.persist(updateUser);
		
		// return updateUser >> return 하려면 void > Users로 변경해야 하는데 필요한지 모르겠음
	}
	
	
	
}
