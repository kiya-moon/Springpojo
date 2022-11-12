package com.springpojo.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Bid;
import com.springpojo.app.DTO.Product;
//import com.springpojo.app.DTO.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AddRepository {

	@PersistenceContext
	private final EntityManager em;
	
	// Product 등록
	public void save(Product product) {
		em.persist(product);
	}
	 
	// 특정 상품 조회
	public Product findById(Long id) {
		return em.createQuery("select p from Product p where p.id = :id", Product.class).setParameter("id", id)
				.getSingleResult();
	}

	// 카테고리별 상품 가져오기
	public List<Product> findAll(String productCategory) {
		return em.createQuery("select p from Product p where p.productCategory = :productCategory order by p.id", Product.class)
				.setParameter("productCategory", productCategory)
				.getResultList();
	}

	// 상품 가격 업데이트
	public void update(Long id, Long checkPrice) {
		System.out.println("업데이트 레파지토리 도착");
		em.createQuery("update Product p set p.productPrice = :checkPrice where p.id = :id").setParameter("checkPrice", checkPrice).setParameter("id", id).executeUpdate();
	}

	// 경매 참가 업데이트
	public void bidUpdate(Bid bid, String userId, Long id) {
		// 기존에 비드가 업다면 저장 있다면 업데이트
		System.out.println("여기에 오나여?");
		
		// DB에 없으면
		Long exist = em.createQuery("select count(b) from Bid b where b.users.userId = :userId and b.product.id = :id", Long.class).setParameter("userId", userId).setParameter("id", id).getSingleResult();
		System.out.println(exist);
		if(exist == 0) {
			System.out.println("트랜잭션 테스트");
			em.persist(bid);
		}else {
			System.out.println("업데이트");
			em.createQuery("update Bid b set b.bidPrice = :bidPrice where b.users.userId = :userId and b.product.id = :id")
				.setParameter("bidPrice", bid.getBidPrice())
				.setParameter("userId", userId)
				.setParameter("id", id)
				.executeUpdate();
		}
	}

	public void reduceLike(Long id) {
		
		
	}

	public void updateLike(Long id) {
		
		
	}
}
