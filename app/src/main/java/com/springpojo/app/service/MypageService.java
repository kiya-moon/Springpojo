package com.springpojo.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Bid;
import com.springpojo.app.DTO.Product;
import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.MypageRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class MypageService {
   
   private final MypageRepository mypageRepository;
   private HttpSession session;

   public Users findById(String userId) {
      System.out.println(userId);
      return mypageRepository.findById(userId);
   }
   
   // 회원탈퇴
   public int delete(HttpSession session, String userId) throws Exception{
      return mypageRepository.delete(session, userId);
   }

   public List<Product> product(String userId){
	   System.out.println("2222");
	   return mypageRepository.product(userId);
   }
   
//   public List<Bid> bid(String userId){
//	   System.out.println("33333");
//	   return mypageRepository.bid(userId);
//   }
}