package com.springpojo.app.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

// @Data : @Setter Getter ToString 통합하여 불러오는 lombok
@Entity
@Table(name = "USERS")
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
	
	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserPw() {
		return UserPw;
	}

	public void setUserPw(String userPw) {
		UserPw = userPw;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserBirth() {
		return UserBirth;
	}

	public void setUserBirth(String userBirth) {
		UserBirth = userBirth;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getUserPhone() {
		return UserPhone;
	}

	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}
	
	public User(@NotEmpty String userId, @NotEmpty String userPw, 
			@NotEmpty String userName, @NotEmpty String userBirth, 
			@NotEmpty String userEmail, @NotEmpty String userPhone) {
		this.UserId = userId;
		this.UserPw = userPw;
		this.UserName = userName;
		this.UserBirth = userBirth;
		this.UserEmail = userEmail;
		this.UserPhone = userPhone;
	}
	
	public User() {}
}
