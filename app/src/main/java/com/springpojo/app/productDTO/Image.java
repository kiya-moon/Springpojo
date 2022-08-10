package com.springpojo.app.productDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.springpojo.app.userDTO.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Image {
	@Id
	private String ImgCopyName;
	
	// FK
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;

	private String ImgName;
	private String ImgRoute;
	
		
}

