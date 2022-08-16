package com.springpojo.app.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter(value = AccessLevel.NONE)
public class Product {

	// 상품번호 -> PK
	@Id @GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long id;
	
	// 유저아이디 -> FK
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	private Long productPrice;
	private String productCategory;
	// 이미지는 이미지 DB에서 받아올 예정
//	private String productImage;
	private LocalDateTime productDate;
	private String productText;
	private Long likeCount;
	private String productCeller;
	// Date인지 잘 모르겠지만 일단 넣어둠
	private Date productEnddate;
	
	@OneToMany(mappedBy = "product")
	private List<Bid> bid = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<Like> like = new ArrayList<>();
}
