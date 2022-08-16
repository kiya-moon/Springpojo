package com.springpojo.app.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter(value = AccessLevel.NONE)
@Table(name="LIKES")
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
