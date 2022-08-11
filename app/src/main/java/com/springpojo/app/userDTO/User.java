package com.springpojo.app.userDTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springpojo.app.bidDTO.Bid;
import com.springpojo.app.bidDTO.Like;
import com.springpojo.app.productDTO.Image;
import com.springpojo.app.productDTO.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data : @Setter Getter ToString 통합하여 불러오는 lombok
//@Data : @Setter Getter ToString 통합하여 불러오는 lombok
@Data
@AllArgsConstructor	// 모든 파라미터가 있는 생성자 생성
@NoArgsConstructor	// 기본 생성자 생성
@Table(name = "USERS")
@Entity
public class User {
	
	@Id
	@Column(name = "USERID", unique = true, nullable = false)
	private String UserId;
	
	@Column(name = "USERPW", nullable = false)
	private String UserPw;
	
	@Column(name = "USERNAME", nullable = false)
	private String UserName;	
	
	@Column(name = "USERBIRTH", nullable = false)
	private String UserBirth;	
	
	@Column(name = "USEREMAIL", nullable = false)
	private String UserEmail;
	
	@Column(name = "USERPHONE", nullable = false)
	private String UserPhone;
	
	@OneToMany(mappedBy = "user")
	private List<Bid> bid = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Product> product = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Image> image = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Like> like = new ArrayList<>();
	
	public User(String userId, String userPw, 
			String userName, String userBirth, 
			String userEmail, String userPhone) {
		this.UserId = userId;
		this.UserPw = userPw;
		this.UserName = userName;
		this.UserBirth = userBirth;
		this.UserEmail = userEmail;
		this.UserPhone = userPhone;
	}
	
}
