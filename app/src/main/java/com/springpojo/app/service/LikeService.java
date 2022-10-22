package com.springpojo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpojo.app.DTO.Like;
import com.springpojo.app.DTO.Product;
import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.AddRepository;
import com.springpojo.app.repository.LikeRepository;
import com.springpojo.app.repository.MypageRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class LikeService {
	
	private final LikeRepository likeRepository;
	private final MypageRepository mypageRepository;
	private final AddRepository addRepository;
	
	public Optional<Like> likeChk(String userId, Long id) throws Exception{
		System.out.println(2);
		
		return likeRepository.likeChk(userId, id);
	}

	// like에서 삭제
	public void remove(String userId, Long id) {
			System.out.println("removeservice");
		likeRepository.remove(userId, id);
		System.out.println("after rm service");
	}

	// like에 등록
	public void insert(String userId, Long id) {
		Users users = mypageRepository.findById(userId);
		Product product = addRepository.findById(id);
		
		Like like = new Like();
		like.setProduct(product);
		like.setUsers(users);
		
		likeRepository.insert(like);
	}
	
	public List<Like> likeCnt(long id) throws Exception {
		System.out.println("likeCnt2");
		return likeRepository.likeCnt(id);
	}
}
