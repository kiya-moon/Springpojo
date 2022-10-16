package com.springpojo.app.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 모든 파라미터가 있는 생성자 생성
@NoArgsConstructor // 기본 생성자 생성
@SequenceGenerator(name = "SPRING_SEQ_GENERATOR", sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1)
@Entity
public class Users {

	@Id
	@Column(unique = true, nullable = false)
	@NotEmpty
	private String userId;

	@NotEmpty
	private String userPw;

	@NotEmpty
	private String userName;

	@NotEmpty
	private String userBirth;

	@NotEmpty
	private String userEmail;

	@NotEmpty
	private String userPhone;

//	private String UserRole;		// 유저 권한

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
	private List<Bid> bid = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
	private List<Product> product = new ArrayList<>();

//	@OneToMany(mappedBy = "users")
//	private List<Image> image = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
	private List<Like> like = new ArrayList<>();

	public Users(String userId, String userPw, String userName, String userBirth, String userEmail, String userPhone) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}

}
