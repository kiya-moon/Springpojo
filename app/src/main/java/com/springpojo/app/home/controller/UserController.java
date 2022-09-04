//package com.springpojo.app.home.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.springpojo.app.DTO.Users;
//import com.springpojo.app.repository.UserRepository;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/login")
//public class UserController {
//	
//    private final UserRepository userRepository;
//
//    @GetMapping("/signup")
//    public String addForm(@ModelAttribute("users") Users users) {
//        return "login/signup";
//    }
//
//    @PostMapping("/signup")
//    public String save(@Validated @ModelAttribute Users users
//            , BindingResult bindingResult) {
////        if (bindingResult.hasErrors()) {
////            return "login/signup";
////        }
//
//        userRepository.save(users);
//        System.out.println("5");
//        return "redirect:/";
//    }
//}
