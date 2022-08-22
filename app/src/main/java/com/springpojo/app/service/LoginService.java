//package com.springpojo.app.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.springpojo.app.DTO.User;
//import com.springpojo.app.repository.UserRepository;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class LoginService {
//
//	@Autowired
//	private final UserRepository userRepository;
//	
////	public List<User> login(User user) {
////		
//////		Optional<User> userId =  userRepository.findById(user.getUserId());
////		List<User> list = userRepository.findUser(user.getUserId(), user.getUserPw());
////		
////		return list;
////	}
//	
//	public User loginUser(String UserId, String UserPw) {
//		User user = userRepository.selectUserInfo(UserId, UserPw);
//		return user;
//	}
//
//	
////	/*
////	 * @return null 로그인 실패
////	 */
////	
////	public User login(String UserId, String UserPw) {
////		return userRepository.findById(UserId)
////				.filter(m -> m.getUserPw().equals(UserPw))
////				.orElse(null);
////	}
//}
