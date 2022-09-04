//package com.springpojo.app.DTO;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@SequenceGenerator(name = "SPRING_SEQ_GENERATOR", sequenceName = "IMG_SEQ", initialValue = 1, allocationSize = 1)
//public class Image {
//	// static/uploadImg에 저장
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPRING_SEQ_GENERATOR")
//	@Column(name = "IMG_ID")
//	private Long id;
//
//	private String ImgName;
//	
//	private String ImgPath;
//
//	// FK
//	@ManyToOne
//	@JoinColumn(name = "PRODUCT_ID")
//	private Product product;
//
//}
