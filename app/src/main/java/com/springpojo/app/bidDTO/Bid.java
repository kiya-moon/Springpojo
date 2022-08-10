package com.springpojo.app.bidDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.springpojo.app.productDTO.Product;
import com.springpojo.app.userDTO.User;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Bid {
	
	// 경매참여번호
	@Id @GeneratedValue
	private Long BidJoinNum;
	
	// FK
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;
	
	// FK
	@ManyToOne
	@JoinColumn(name="PRODUCT_NAME")
	private Product product;
	
	private int BidPrice;

}
