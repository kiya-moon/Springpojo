package com.springpojo.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.UserRepository;

@Controller
public class UserController {

   private UserRepository userRepository;

   public UserController(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @RequestMapping("/signup")
   public String ereate(Users users) {
      this.userRepository.save(users);
      return "redirect:/";
   }
}
