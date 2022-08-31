package com.springpojo.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Users;

@Repository
public class MypageRepository {

	private static final Map<Long, Users> store = new HashMap<>();
	private static long sequence = 0L;
	
	// 저장
	 public Users save(Users User) {
		User.setId(++sequence);
		store.put(User.getId(), User);
		return User;
	}
	
	// id로 찾기
	public Users findById(Long UserId2) {
		return store.get(UserId2);
	}
	
	// 전체 검색
	public List<Users> findAll(){
		return new ArrayList<Users>(store.values());
	}
	
	// 수정
	public void update(Long UserId2, Users updateParam) {
		Users findUser = findById(UserId2);
		findUser.setUserId(updateParam.getUserId());
		findUser.setUserPw(updateParam.getUserPw());
		findUser.setUserName(updateParam.getUserName());
		findUser.setUserBirth(updateParam.getUserBirth());
		findUser.setUserEmail(updateParam.getUserEmail());
		findUser.setUserPhone(updateParam.getUserPhone ());
	}
}
