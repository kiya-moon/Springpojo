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

	// Product Repository
	public void save(Product product) {
		if (product.getId() == null) {
			em.persist(product);
		} else {
			em.merge(product);
		}
	}
	
	// 특정 상품 조회
	public Product findById(Long id) {
		return em.createQuery("select p from Product p where p.id = :id", Product.class).setParameter("id", id)
				.getSingleResult();
	}

	public List<Product> findAll(String productCategory) {
		return em.createQuery("select p from Product p where p.productCategory = :productCategory order by p.id", Product.class)
				.setParameter("productCategory", productCategory)
				.getResultList();
	}
	
	
}
