package com.springpojo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springpojo.app.DTO.Users;

public interface LoginRepository extends JpaRepository<Users, String>{
	Optional<Users> findUsersByUserId(String userId);

}
