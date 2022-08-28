//package com.springpojo.app.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Repository;
//
//import com.springpojo.app.DTO.Product;
//import com.springpojo.app.DTO.User;
//
//import lombok.RequiredArgsConstructor;
//
//@Repository
//@RequiredArgsConstructor
//public class AddRepository  {
//
//	@PersistenceContext
//	private final EntityManager em;
//	
//	// Product Repository
//	public  void save(Product product) {
//		if(product.getId() == null) {
//			em.persist(product);
//		}else {
//			em.merge(product);
//		}
//	}
//	
//	public List<Product> findAll() {
//		return em.createQuery("select p from Product p", Product.class).getResultList();
//	}
//	
//}

