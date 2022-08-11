package com.springpojo.app.user.repository;

import com.springpojo.app.userDTO.User;

public interface UserRepository {
	
	int overlappedID(User user) throws Exception;
}
