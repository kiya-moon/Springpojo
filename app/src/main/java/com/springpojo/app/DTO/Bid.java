package com.springpojo.app.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator( name="SPRING_SEQ_GENERATOR",
					sequenceName = "BID_SEQ",
					initialValue = 1, allocationSize = 1)
public class Bid {
	
	// 경매참여번호
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "SPRING_SEQ_GENERATOR")
	private Long bidJoinNum;
	
	// FK
	@ManyToOne
	@JoinColumn(name="USERID")
	private Users users;
	
	// FK
	@ManyToOne
	@JoinColumn(name="PRODUCT_NAME")
	private Product product;
	
	private Long bidPrice;

}
