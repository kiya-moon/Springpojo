package com.springpojo.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springpojo.app.DTO.Users;

public interface UserRepository extends JpaRepository<Users, String>{

   @Query("select u from Users u where userid = :userid")
   Users findByUserId(String userid);

}
