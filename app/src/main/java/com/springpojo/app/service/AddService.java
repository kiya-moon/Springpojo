package com.springpojo.app.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.springpojo.app.DTO.Bid;
import com.springpojo.app.DTO.Product;
import com.springpojo.app.repository.AddRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class AddService {

	private final AddRepository addRepository;
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Value("${file.dir}")
	private String fileDir;
	
	// 물품등록
	public Product saveProduct(Product product, MultipartFile upload_box) throws Exception {
		// 이미지 저장 처리
		String imgPath = fileDir;
		System.out.println("imgPath = " + fileDir);
		UUID uuid = UUID.randomUUID();
		String imgName = uuid + "_" + upload_box.getOriginalFilename();
		System.out.println("imgName = " + imgName);
		File saveImg = new File(imgPath, imgName);
//		Image saveImage = new Image(imgPath, filename);
		upload_box.transferTo(saveImg);
		product.setImgName(imgName);
		product.setImgPath(imgPath+imgName);
		System.out.println(product.getImgPath());
		
		// 날짜 저장
		LocalDateTime date = LocalDateTime.now().withNano(0);
		addRepository.save(product);
		product.setStartDate(date);
		System.out.println(product.getStartDate());
		if(product.getProductDate().equals("day")) {
			product.setEndDate(date.plusDays(1));
		}else if(product.getProductDate().equals("3days")) {
			product.setEndDate(date.plusDays(3));
		}else if(product.getProductDate().equals("week")) {
			product.setEndDate(date.plusDays(7));
		}
		
		
		String startDateTime = (product.getStartDate().toString()).replace("T", " ");
        String endDateTime = (product.getEndDate().toString()).replace("T", " ");

        long startTimeSet = 0L;
        Date startDate = new Date();
        Date endDate = new Date();
        
        try {
        	startTimeSet= Long.parseLong(System.currentTimeMillis()+"");
        	startDate.setTime(startTimeSet);
        	endDate = timeFormat.parse(endDateTime);
        	System.out.println(endDate);
        	System.out.println(startTimeSet);
        } catch (ParseException e) {
        	
        }
        System.out.println("경매 시작일 : " + startDateTime);
        System.out.println("경매 종료일 : " + endDateTime);
        
        long cellPeriod = (endDate.getTime() - startDate.getTime())/1000;
        long sec = cellPeriod % 60;
        long secForMin = cellPeriod / 60;
        long min = secForMin % 60;
        long minForHour = secForMin / 60;
        long hour = minForHour;
        
        System.out.println("남은 기간 : " + cellPeriod);
        System.out.println("초 : " + sec);
        System.out.println("분 : " + min);
        System.out.println("시 : " + hour);
        
        StringBuffer sb = new StringBuffer();
        sb.append(hour).append(":");
		if((min+"").length() == 1) {
			sb.append("0").append(min);
		} else {
			sb.append(min);
		}
		
		sb.append(":");
		
		if((sec+"").length() == 1) {
			sb.append("0").append(sec);
		} else {
			sb.append(sec);
		}
		System.out.println("남은 시간 : " + sb);
		product.setCellPeriod(sb);
		
		return product;
	}
	
	// 전체 물품 조회
	public List<Product> findProducts(String productCategory){
		return addRepository.findAll(productCategory);
}

	// 특정 상품 조회
	public Product findById(Long id) {
		System.out.println("asd");
    
		return addRepository.findById(id);
	}

	// 상품 금액 업데이트
	public Product priceUpdate(Long id, Long checkPrice) throws Exception {
		addRepository.update(id, checkPrice);
		
		Product product = new Product();
		
		return product;
	}

	// 경매 참여
	public Bid bidUpdate(Bid bid, String userId, Long id) throws Exception {
		addRepository.bidUpdate(bid, userId, id);
		return bid;
	}

	// 프로덕트의 likecnt--
	public void reduceLike(Long id) {
		addRepository.reduceLike(id);
	}

	// 프로덕트의 likecnt++
	public void updateLike(Long id) {
		addRepository.updateLike(id);
	}
	
}