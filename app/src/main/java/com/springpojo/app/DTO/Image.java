//package com.springpojo.app.DTO;
//
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter @Setter(value = AccessLevel.NONE)
//public class Image {
//	@Id
//	private String ImgCopyName;
//	
//	// FK
//	@ManyToOne
//	@JoinColumn(name="USERID")
//	private Users users;
//
//	private String ImgName;
//	private String ImgRoute;
//	
//		
//}
//