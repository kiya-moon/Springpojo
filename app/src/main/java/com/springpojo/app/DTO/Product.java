package com.springpojo.app.DTO;
	
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor	// 모든 파라미터가 있는 생성자 생성
@NoArgsConstructor	// 기본 생성자 생성
@SequenceGenerator( name="PRODUCT_SEQ_GENERATOR",
					sequenceName = "PRODUCT_SEQ",
					initialValue = 1, allocationSize = 1)
public class Product {

	// 상품번호 -> PK
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "PRODUCT_SEQ_GENERATOR")
	@Column(name = "PRODUCT_ID")
	private Long id;
	
	// 유저아이디 -> FK
//	@ManyToOne
//	@JoinColumn(name="USERID")
//	private User user;
	private String productName;
	
	private Long productPrice;
	private String productCategory;
	// 이미지는 이미지 DB에서 받아올 예정
//	private String productImage;
	private LocalDateTime startDate;
	private String productDate;
	@Column(nullable=true, length=500)
	private String productText;
//	@Column(nullable=true)
	// likecount는 like 테이블에서 prodcut_name을 count
//	private int likeCount;
//	@Column(nullable=true)
//	private String productCeller;
//	// Date인지 잘 모르겠지만 일단 넣어둠
//	@Column(nullable=true)
	private LocalDateTime endDate;
	private StringBuffer cellPeriod;
	@OneToMany(mappedBy = "product")
	private List<Bid> bid = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<Like> like = new ArrayList<>();

	
}
