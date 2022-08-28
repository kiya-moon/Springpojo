package com.springpojo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

		List<Users> findAll();
		
		Users findByUserId(String UserId);
}
