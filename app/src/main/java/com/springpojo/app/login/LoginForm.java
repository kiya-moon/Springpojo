package com.springpojo.app.login;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginForm {

	@NotEmpty
	private String UserId;
	
	@NotEmpty
	private String UserPw;

}
