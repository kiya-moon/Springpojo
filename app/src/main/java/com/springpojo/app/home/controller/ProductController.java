package com.springpojo.app.home.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springpojo.app.DTO.Bid;
import com.springpojo.app.DTO.Like;
import com.springpojo.app.DTO.Product;
import com.springpojo.app.DTO.Users;
import com.springpojo.app.service.AddService;
import com.springpojo.app.service.LikeService;
import com.springpojo.app.service.MypageService;

@Controller
public class ProductController {
   private final AddService addService;
   private final MypageService mypageService;
   private final LikeService likeService;
   
   @Autowired
   public ProductController(AddService addService, MypageService mypageService, LikeService likeService) {
      this.addService = addService;
      this.mypageService = mypageService;
      this.likeService = likeService;
   }

   
   // 이미지 불러오기
   @GetMapping("/upload/{id}")
   @ResponseBody
   public Resource img(@PathVariable("id") Long id, Model model) throws IOException {
      System.out.println("이미지 컨트롤러");
      Product product = addService.findById(id);
      System.out.println(product.getImgPath());
      System.out.println();
      return new UrlResource("file:" + product.getImgPath());
   }
   
   // 상품등록페이지 이동
   @GetMapping("/add")
   public String addProduct(Model model) {
      model.addAttribute("Product", new Product());
      return "contents/addProduct";
   }
   
   // 상품 페이지
   @GetMapping("/product/{id}")
   public String product(@PathVariable Long id, Model model, HttpSession session) throws Exception {
	   String userId = (String)session.getAttribute("userId");
	   String likeChk = "";
      System.out.println("3");
      Product product = addService.findById(id);
      Optional<Like> result = likeService.likeChk(userId, id);
      if(result.isPresent()) {	// 객체에 값이 있으면 = null이 아니면
    	  likeChk = "Y";
		}else {	// null이면
			likeChk = "N";
		}
      model.addAttribute("likeChk",likeChk);
      System.out.println(product.getImgPath());
      model.addAttribute("product", product);
      List<Like> likeCnt = likeService.likeCnt(id);
      int likeCnts = likeCnt.size();
      System.out.println("likeCnt1");
      model.addAttribute("likeCnt", likeCnts);
      System.out.println(likeCnts);
      return "contents/product";
   }
   

   // 상품 등록
   @PostMapping("/product")
   public String add(@ModelAttribute("product") Product product, MultipartFile upload_box, RedirectAttributes redirectAttributes, HttpSession httpSession) throws Exception {
      String userId = (String)httpSession.getAttribute("userId");
      
      Users users = mypageService.findById(userId);
      product.setUsers(users);
      product.setProductCeller(users.getUserName());
      
      Product savedProduct = addService.saveProduct(product, upload_box);

      redirectAttributes.addAttribute("id", savedProduct.getId());
      return "redirect:/product/{id}";
   }

   
   // 상품 리스트
   @GetMapping("/productList")
   public String prodcutList(@RequestParam("productCategory") String productCategory, Product product, Model model) {
      List<Product> productList = addService.findProducts(productCategory);
      
      System.out.println(productList);
      
      long dday = new Date().getTime();
      
      for (int i = productList.size()-1; i >= 0; i--) {
         long end = (java.sql.Timestamp.valueOf(productList.get(i).getEndDate())).getTime();
         long calc = dday - end;
         System.out.println("i = " + i);
         
         if(end - dday <= 0) {
            System.out.println("if문 안에 몇 번 들어와? : " + i);
            productList.remove(i);
         }
      }
      
      System.out.println(productList);
      
      model.addAttribute("productList", productList);
      return "/contents/productList";
   }
   
   // 좋아요
   @PostMapping("/updateLike/{id}")
   @ResponseBody
//	public Optional<Like> likeChk(@PathVariable Long id, HttpSession session, Model model) throws Exception{
//		System.out.println(1);
//		System.out.println(session.getAttribute("userId"));
//		String userId = (String)session.getAttribute("userId");
//		
//		Optional<Like> result = likeService.likeChk(userId, id);
//		System.out.println(result);
//		model.addAttribute("likeImg",result);
//		
//		// like가 null이면 like에 저장
//		// like가 null이 아니면 like에서 삭제
//		if(result.isPresent()) {	// 객체에 값이 있으면 = null이 아니면
//			likeService.remove(userId, id);
//		}else {	// null이면
//			likeService.insert(userId, id);
//		}
//		return result;
//	}
   public Long likeChk(@PathVariable Long id, HttpSession session, Model model) throws Exception{
	   String userId = (String)session.getAttribute("userId");
	   Long likeChk = likeService.likeChkTest(id, userId);
	   model.addAttribute("likeChk", likeChk);
	   
		// like가 null이면 like에 저장
		// like가 null이 아니면 like에서 삭제
		if(likeChk==1) {	// 객체에 값이 있으면 = null이 아니면
			likeService.remove(userId, id);
		}else {	// 0이면
			likeService.insert(userId, id);
		}
	   
	   return likeChk;
   }
   
   @GetMapping("/updateLike/{id}")
   @ResponseBody
   public Long likeCnt(@PathVariable Long id, HttpSession session, Model model) throws Exception{
//	   String userId = (String)session.getAttribute("userId");
//	   List<Like> likeCnt = likeService.likeCnt(id);
//	   int likeCnts = likeCnt.size();
//	   
//	   Optional<Like> result = likeService.likeChk(userId, id);
//		System.out.println("찜횟수?");
//		
//		// like가 null이면 like에 저장
//		// like가 null이 아니면 like에서 삭제
//		if(result.isPresent()) {	// 객체에 값이 있으면 = null이 아니면
//			likeService.likeCnt(id);
//			System.out.println(likeCnts);
//		}else {	// null이면
//			likeService.likeCnt(id);
//			System.out.println(likeCnts+"2");
//		}
//	   System.out.println("들어와라아아아");
//	   return likeCnts;
	   Long likeCnt = likeService.likeCntTest(id);
	   System.out.println("likeCnt" + likeCnt);
	   model.addAttribute("likeCnt", likeCnt);
	   
	   return likeCnt;
	   
   }

 // 상품 금액 업데이트
	@PostMapping("/updatePrice/{id}")
	public String priceUpdate(@PathVariable Long id, Long checkPrice, RedirectAttributes redirectAttributes, HttpSession httpSession) throws Exception {
		// 세션 아이디와 프로덕트 등록 아이디 비교해서 해당하는 아이디가 있을 경우 참여 불가
		// 로그인 안하고 경매 참여버튼 눌렀을 때 예외처리
		
		// 상품 금액 업데이트
		addService.priceUpdate(id, checkPrice);
		
		// BID에 저장
		Bid bid = new Bid();
		
		String userId = (String)httpSession.getAttribute("userId");
		System.out.println(userId);
		Users users = mypageService.findById(userId);
		System.out.println(users);
		bid.setUsers(users);
		
		Product product = addService.findById(id);
		bid.setProduct(product);
		System.out.println(product);
		
		bid.setBidPrice(checkPrice);
		
		addService.bidUpdate(bid, userId, id);
		
		redirectAttributes.addAttribute("id", id);
		
		return "redirect:/product/{id}";
  }	
}
