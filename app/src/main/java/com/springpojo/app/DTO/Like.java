package com.springpojo.app.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor	// 모든 파라미터가 있는 생성자 생성
@NoArgsConstructor	// 기본 생성자 생성
@SequenceGenerator(name="SPRING_SEQ_GENERATOR",
					sequenceName = "LIKE_SEQ",
					initialValue = 1, allocationSize = 1)
@Table(name="LIKES")
public class Like {
	// 관심상품순서...?
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "SPRING_SEQ_GENERATOR")
	private Long LikeNum;
	
	// FK
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="USERID")
	private Users users;
	
	// FK
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
}
