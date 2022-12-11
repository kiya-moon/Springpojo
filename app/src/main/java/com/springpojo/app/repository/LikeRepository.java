package com.springpojo.app.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Like;
import com.springpojo.app.DTO.Product;
import com.springpojo.app.DTO.Users;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LikeRepository {
	
	@PersistenceContext
	private final EntityManager em;
	
//	public void save(Like like) {
//		if (like.getLikeNum() == null) {
//			em.persist(like);
//		} else {
//			em.merge(like);
//		}
//	}
	
	public void remove(String userId, Long id) {
		em.createQuery("delete from Like l where l.users.userId = :userId and l.product.id = :id")
				.setParameter("userId", userId).setParameter("id", id).executeUpdate();
	}
	
	public void insert(Like like) {
		em.persist(like);
	}
	
	public Optional<Like> likeChk(String userId, Long id) throws Exception{
		System.out.println(3);
		List<Like> likes = em.createQuery("select l from Like l where l.users.userId = :userId and l.product.id = :id", Like.class)
				.setParameter("userId", userId).setParameter("id", id)
				.getResultList();
		return likes.stream().findAny();
	}
	
	public List<Like> likeCnt(long id) throws Exception{
		System.out.println("likeCnt3");
		return em.createQuery("select l from Like l where l.product.id = :id", Like.class)
				.setParameter("id", id).getResultList();
	}

	public Long likeCntTest(Long id) {
		return em.createQuery("select count(l) from Like l where l.product.id = :id", Long.class)
				.setParameter("id", id).getSingleResult();
	}

	public Long likeChkTest(Long id, String userId) {
		// TODO Auto-generated method stub
		return em.createQuery("select count(l) from Like l where l.product.id = :id and l.users.userId = :userId", Long.class)
				.setParameter("id", id).setParameter("userId", userId).getSingleResult();
	}
	
	
//	public Like findList(Users user, Product product) {
//		
//		return em.createQuery("select * from like l from l.user : user and l.product : product", Like.class)
//				.setParameter("user", user).setParameter("product", product).getSingleResult();
//	}
	
//	public int likeList(long id, String userId) {
//		
//		return (int)em.createQuery("select count(l) from likes l where l.product_id= :id and l.userid = :userId")
//				.setParameter("id",id).setParameter("userId", userId).getSingleResult();
//	}

}