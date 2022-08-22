package com.springpojo.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Product;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
//public interface AddRepository extends JpaRepository<Product, Long>{
//	
//	@Query("select p from ProductVO p")
//	
//}
public class AddRepository {

	@PersistenceContext
	private final EntityManager em;
	
	public void save(Product product) {
		if(product.getId() == null) {
			em.persist(product);
		}else {
			em.merge(product);
		}
	}
	
	public List<Product> findAll() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}
}