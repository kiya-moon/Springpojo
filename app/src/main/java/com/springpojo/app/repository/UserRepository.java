package com.springpojo.app.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Users;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {
	private final EntityManager em;
	
	// 회원가입
	public void save(Users user) {
		if (user.getUserId() == null) {
			em.persist(user);
		} else {
			em.merge(user);
		}
	}
	
	// 아이디 중복체크
	public Optional<Users> idChk(String userId) throws Exception{
		System.out.println(3);
		List<Users> user = em.createQuery("select u from Users u where u.userId = :userId", Users.class).setParameter("userId", userId)
				.getResultList();
		return user.stream().findAny();
	}
	
	// 로그인
	public Users login(String userId) throws Exception{
		System.out.println(3);
		Users user = em.createQuery("select u from Users u where u.userId = :userId", Users.class)
				.setParameter("userId", userId).getSingleResult();
		return user;
	}
	
	// 아이디 찾기
	public String findId(String userName, String userPhone) throws Exception {
		
		try {
			return em.createQuery("select u.userId from Users u where u.userName = :userName and u.userPhone = :userPhone", String.class)
					.setParameter("userName", userName).setParameter("userPhone", userPhone).getSingleResult();
			
		} catch(Exception e) {
			String id = null;
			return id;
		}
		
		
	}
	
	// 비밀번호 찾기
	public String findPw(String userId, String userName, String userPhone) throws Exception {
		try {
		return em.createQuery("select u.userPw from Users u where u.userId = :userId and u.userName = :userName and u.userPhone = :userPhone", String.class)
				.setParameter("userId", userId).setParameter("userName", userName).setParameter("userPhone", userPhone).getSingleResult();
		} catch(Exception e) {
			String pw = null;
			return pw;
		}
	}
}

