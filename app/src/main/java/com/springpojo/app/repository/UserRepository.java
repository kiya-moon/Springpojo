package com.springpojo.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("select u from Users u where u.USERID=:UserId and u.USERPW=:UserPw")
	User selectUserInfo(@Param("UserId")String UserId, @Param("UserPw")String UserPw);
	
};
