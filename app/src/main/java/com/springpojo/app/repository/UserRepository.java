package com.springpojo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springpojo.app.DTO.User;

public interface UserRepository extends JpaRepository<User, String>{

}
