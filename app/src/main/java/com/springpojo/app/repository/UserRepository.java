package com.springpojo.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
//	@Query("select u from USERS u where USERID = ?")
//	List<User> findUser(String UserId, String UserPw);
	
	@Query("select u from UserVO u where u.userId=:userId and u.password=:password")
	User selectUserInfo(@Param("userId")String UserId, @Param("UserPw")String UserPw);
};
	
////	@Query("select u from User u where UserId = :UserId and UserPw = :UserPw")
////	User findUser(String UserId, String UserPw);
//
////	private final EntityManager em ; 
//	
//	private static Map<Long, User> store = new HashMap<>(); // static 사용
//	private static long sequence = 0L; // static 사용
//
////	public UserRepository(EntityManager em) {
////		this.em = em;
////	}
//	
//	public User save(User user) {
//		
//		System.out.println("22222");
//		user.setId(++sequence);
////		em.persist(user);
//		
//		
//		return user;
//	}
//
//	public User findById(Long id) {
//		System.out.println("33333");
//		return store.get(id);
//	}
//
//	public Optional<User> findByUserId(String UserId) {
//		
//		System.out.println("444444");
//		return findAll().stream()
//				.filter(m -> m.getUserId().equals(UserId))
//				.findFirst();
//	}
//
//	public List<User> findAll() {
//		
//		System.out.println("555555");
//		
//		return new ArrayList<>(store.values());
//	}
//
//	public void clearStore() {
//		
//		System.out.println("66666666");
//		store.clear();
//	}
