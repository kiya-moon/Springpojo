package com.springpojo.app.product;

import java.time.LocalDateTime;

public class Product {

	private Long id;
	private String productName;
	private Long productPrice;
	private String productCategory;
	private String productImage;
	private LocalDateTime productDate;
	private String productEx;
	private Long productCnt;
	private String productCeller;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public LocalDateTime getProductDate() {
		return productDate;
	}
	public void setProductDate(LocalDateTime productDate) {
		this.productDate = productDate;
	}
	public String getProductEx() {
		return productEx;
	}
	public void setProductEx(String productEx) {
		this.productEx = productEx;
	}
	public Long getProductCnt() {
		return productCnt;
	}
	public void setProductCnt(Long productCnt) {
		this.productCnt = productCnt;
	}
	public String getProductCeller() {
		return productCeller;
	}
	public void setProductCeller(String productCeller) {
	
		this.productCeller = productCeller;
	}
	
	public Product(Long id, String productName, Long productPrice, String productCategory, String productImage,
			LocalDateTime productDate, String productEx, Long productCnt, String productCeller) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productImage = productImage;
		this.productDate = productDate;
		this.productEx = productEx;
		this.productCnt = productCnt;
		this.productCeller = productCeller;
	}
	
	
}
