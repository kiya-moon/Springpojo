package com.springpojo.app.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor	// 모든 파라미터가 있는 생성자 생성
@NoArgsConstructor	// 기본 생성자 생성
@Table(name = "USERS")
//@SequenceGenerator(
//        name = "USER_SEQ_GENERATOR",
//        sequenceName = "USER_SEQ",
//        initialValue = 1,
//        allocationSize = 1
//)
@Entity
public class User {
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,
//					generator = "USER_SEQ_GENERATOR")
//	private Long id;
	
	@Id
	@Column(name = "USERID", unique = true, nullable = false)
	@NotEmpty
	private String UserId;
	
	@Column(name = "USERPW", nullable = false)
	@NotEmpty
	private String UserPw;
	
	@Column(name = "USERNAME", nullable = false)
	@NotEmpty
	private String UserName;	
	
	@Column(name = "USERBIRTH", nullable = false)
	@NotEmpty
	private String UserBirth;	
	
	@Column(name = "USEREMAIL", nullable = false)
	@NotEmpty
	private String UserEmail;
	
	@Column(name = "USERPHONE", nullable = false)
	@NotEmpty
	private String UserPhone;
	
//	private String UserRole;		// 유저 권한
	
	@OneToMany(mappedBy = "user")
	private List<Bid> bid = new ArrayList<>();
	
//	@OneToMany(mappedBy = "user")
//	private List<Product> product = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Image> image = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Like> like = new ArrayList<>();
	
	public User(String UserId, String UserPw, 
			String UserName, String UserBirth, 
			String UserEmail, String UserPhone) {
		this.UserId = UserId;
		this.UserPw = UserPw;
		this.UserName = UserName;
		this.UserBirth = UserBirth;
		this.UserEmail = UserEmail;
		this.UserPhone = UserPhone;
	}
	
}
