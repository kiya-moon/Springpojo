package com.springpojo.app.DTO;
	
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@DynamicInsert
@AllArgsConstructor	// 모든 파라미터가 있는 생성자 생성
@NoArgsConstructor	// 기본 생성자 생성
@SequenceGenerator( name="SPRING_SEQ_GENERATOR",
					sequenceName = "PRODUCT_SEQ",
					initialValue = 1, allocationSize = 1)
public class Product {

	// 상품번호 -> PK
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "SPRING_SEQ_GENERATOR")
	@Column(name = "PRODUCT_ID")
	private Long id;
	
	// 유저아이디 -> FK
	@ManyToOne
	@JoinColumn(name="USERID")
	private Users users;

	private String productName;
	
	private Long productPrice;
	private String productCategory;
	private LocalDateTime startDate;
	private String productDate;
	
	@Column(nullable=true, length=500)
	private String productText;
	private String productCeller;
	private LocalDateTime endDate;
	private StringBuffer cellPeriod;

	private String imgName;
	private String imgPath;
	
	@Column
	private int likeCnt = 0;

	@OneToMany(mappedBy = "product")
	private List<Bid> bid = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<Like> like = new ArrayList<>();

	
}
