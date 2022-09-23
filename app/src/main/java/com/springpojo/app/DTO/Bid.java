package com.springpojo.app.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter(value = AccessLevel.NONE)
public class Bid {
	
	// 경매참여번호
	@Id @GeneratedValue
	private Long BidJoinNum;
	
	// FK
	@ManyToOne
	@JoinColumn(name="USERID")
	private Users users;
	
	// FK
	@ManyToOne
	@JoinColumn(name="PRODUCT_NAME")
	private Product product;
	
	private int BidPrice;

}
