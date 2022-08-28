package com.springpojo.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.User;

@Repository
public class MypageRepository {

	private static final Map<Long, User> store = new HashMap<>();
	private static long sequence = 0L;
	
	// 저장
	 public User save(User User) {
		User.setUserId2(++sequence);
		store.put(User.getUserId2(), User);
		return User;
	}
	
	// id로 찾기
	public User findById(Long UserId2) {
		return store.get(UserId2);
	}
	
	// 전체 검색
	public List<User> findAll(){
		return new ArrayList<User>(store.values());
	}
	
	// 수정
	public void update(Long UserId2, User updateParam) {
		User findUser = findById(UserId2);
		findUser.setUserId(updateParam.getUserId());
		findUser.setUserPw(updateParam.getUserPw());
		findUser.setUserName(updateParam.getUserName());
		findUser.setUserBirth(updateParam.getUserBirth());
		findUser.setUserEmail(updateParam.getUserEmail());
		findUser.setUserPhone(updateParam.getUserPhone ());
	}


}
