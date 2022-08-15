package com.springpojo.app.bidDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springpojo.app.productDTO.Product;
import com.springpojo.app.userDTO.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="LIKE")
public class Like {
	// 관심상품순서...?
	@Id
	@GeneratedValue
	private Long LikeNum;
	// FK
		@ManyToOne
		@JoinColumn(name="USERID")
		private User user;
		
		// FK
		@ManyToOne
		@JoinColumn(name="PRODUCT_NAME")
		private Product product;
}
