package com.springpojo.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

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
		if (product.getId() == null) {
			// insert 역할
			em.persist(product);
		} else {
			// update 역할
			em.merge(product);
		}
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
	public Product update(Long new_price) {
		System.out.println("업데이트 레파지토리 도착");
		return (Product) em.createQuery("update p set p.productPrice = :new_price where p.id = :id", Product.class);
	}
	
	
}
