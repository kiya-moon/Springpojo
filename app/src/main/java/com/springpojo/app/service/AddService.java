package com.springpojo.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Product;
import com.springpojo.app.repository.AddRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class AddService {

	private final AddRepository addRepository;
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// 물품등록
	public Product saveProduct(Product product) {
		LocalDateTime date = LocalDateTime.now().withNano(0);
		addRepository.save(product);
		product.setStartDate(date);
		System.out.println(product.getStartDate());
		if(product.getProductDate().equals("day")) {
			product.setEndDate((date.plusDays(1)).toString().replace("T", " "));
		}else if(product.getProductDate().equals("3days")) {
			product.setEndDate((date.plusDays(3)).toString().replace("T", " "));
		}else if(product.getProductDate().equals("week")) {
			product.setEndDate((date.plusDays(7)).toString().replace("T", " "));
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
        
//        System.out.println(startDateTime);
//        System.out.println(endDateTime);
//       
//        Date startTime = null;
//        Date endTime = null;
//
//        try {
//            startTime = timeFormat.parse(startDateTime);
//            endTime = timeFormat.parse(endDateTime);
//            System.out.println(startTime);
//            System.out.println(endTime);
//        } catch (Exception e) {
//        }
//       System.out.println(startTime.getTime());
//       System.out.println(endTime.getTime());
//        long calcBetweenTime = endTime.getTime() - startTime.getTime();
//        long sec = calcBetweenTime % 1000;
//        
//        long secForMin = calcBetweenTime / 1000;
//        long min = secForMin % 60;
//        long minForHour = secForMin / 60;
//        long hour = minForHour / 60;
        
//        StringBuffer sb = new StringBuffer();
//        sb.append(hour).append(":");
//        if((min+"").length() == 1) {
//            sb.append("0").append(min).append(":");
//        }
//        if((sec+"").length() == 1) {
//            sb.append("0").append(sec);
//        }
//        product.setCellPeriod(sb.toString());
//
//        System.out.println(product.getCellPeriod());
		return product;
	}
	
	// 전체 물품 조회
	public List<Product> findProducts(String productCategory){
		return addRepository.findAll(productCategory);
	}
	
	// 특정 상품 조회
	public Product findById(Long id) {
		System.out.println("1");
		return addRepository.findById(id);
	}
	
	
}
