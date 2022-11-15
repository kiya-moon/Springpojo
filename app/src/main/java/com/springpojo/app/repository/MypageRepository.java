package com.springpojo.app.repository;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Join;
import com.springpojo.app.DTO.Product;
import com.springpojo.app.DTO.Users;

import javassist.expr.NewArray;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MypageRepository {
   
   @PersistenceContext
   private final EntityManager em;
   
   // 특정 회원 찾기
   public Users findById(String userId) {
      System.out.println(userId);
      return em.createQuery("select u from Users u where u.userId = :id", Users.class).setParameter("id", userId).getSingleResult();
   }
   
   // 회원탈퇴
   public int delete(HttpSession session, String userId) {
      Object logId = session.getAttribute("userId");   // 세션에 저장된 값 불러와서 Object에 저장
      String logGetId = (String)logId;   // Object의 값을 String 값으로 변환
      String jpql = " delete from Users u where u.userId = :id";
      Query query = (Query) em.createQuery(jpql).setParameter("id", logGetId);
      System.out.println(logGetId);
      int rows = query.executeUpdate();
      return rows;
   }
   
   // 회원정보 수정
   public void changeUsers(Users updateParam) {
	   System.out.println("레파1");
	   em.createQuery("update Users u set u.userBirth =:userBirth, u.userEmail=:userEmail, u.userName=:userName, u.userPhone=:userPhone, u.userPw=:userPw where u.userId = :userId ")
	   .setParameter("userBirth", updateParam.getUserBirth()).setParameter("userEmail", updateParam.getUserEmail()).setParameter("userName", updateParam.getUserName()).setParameter("userPhone", updateParam.getUserPhone()).setParameter("userPw", updateParam.getUserPw()).setParameter("userId", updateParam.getUserId()).executeUpdate();
	   System.out.println("레파2");
   }
   // 입찰중인 상품
   public List<Product> bid(String userId) {
	   LocalDateTime local = null;
	   System.out.println("345");
	   return em.createQuery("select p from Product p where 1=1 and p.endDate >= :sysdate and p.id in (select b.bidJoinNum from Bid b where b.users.userId = :userId)").setParameter("sysdate", local.now(Clock.systemDefaultZone())).setParameter("userId", userId).getResultList();
   }
   
   // 관심상품
   public List<Product> like(String userId) {
	   System.out.println("likeRe");
	   return em.createQuery("select p from Product p where 1=1 and p.endDate >= sysdate and  p.id in (select l.product.id from Like l where l.users.userId = :userId)").setParameter("userId", userId).getResultList();
   }
   
   // 판매 물품
   public List<Product> sellProduct(String userId) {
	   System.out.println("sellRe");
	   return em.createQuery("select p from Product p where p.users.userId = :userId").setParameter("userId", userId).getResultList();
   }
   
   // 낙찰 물품
   public List<Join> successfulBid(){
	   System.out.println("낙찰R");
	   return em.createQuery("select p.imgPath, p.productName, p.users.userId as celler, p.endDate, p.productPrice from Product p where 1=1 and p.productPrice in (select max(b.bidPrice) from bid b)").getResultList();
   }
   
}