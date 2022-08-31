package com.springpojo.app.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Users;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
public class UserRepository {

    private static Map<Long, Users> userStorage = new HashMap<>();

    private static long sequence = 0L;
    
//	@PersistenceContext
//	private EntityManager em;

    public Users save(Users users) {
    	System.out.println("1");
        users.setId(++sequence);
        System.out.println(users.getId());

        System.out.println("2");
        log.info("save: users = {}", users);
        
        System.out.println("3");
        userStorage.put(users.getId(), users);
//        em.persist(userStorage.put(users.getId(), users));
        
        System.out.println(userStorage);
        System.out.println(userStorage.toString());
        System.out.println("유저아이디"+users.getUserId());
        System.out.println("4");
        System.out.println(users);
    	
//		if(users.getId() == null) {
//			em.persist(users);
//		}
		
		return users;
    }

    public Users findById(Long id) {
    	System.out.println(id);
        return userStorage.get(id);
    }

    public Optional<Users> findByLoginId(String userId) {
    	System.out.println("findby" + userId);
        return findAll().stream()
                .filter(users -> users.getUserId().equals(userId))
                .findFirst();
    }

    public List<Users> findAll() {
        return new ArrayList<>(userStorage.values());
    }

    public void clearStorage() {
        userStorage.clear();
    }
}
