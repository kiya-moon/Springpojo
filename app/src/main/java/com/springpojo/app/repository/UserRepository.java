package com.springpojo.app.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import com.springpojo.app.DTO.Users;

import java.util.*;

@Slf4j
@Repository
public class UserRepository {

    private static Map<Long, Users> userStorage = new HashMap<>();

    private static long sequence = 0L;

    public Users save(Users users) {
        users.setId(++sequence);

        log.info("save: users = {}", users);

        userStorage.put(users.getId(), users);

        return users;
    }

    public Users findById(Long id) {
        return userStorage.get(id);
    }

    public Optional<Users> findByLoginId(String userId) {
        return findAll().stream()
                .filter(users -> users.getUserId().equals(userId))
                .findFirst();

//        List<Member> members = findAll();
//
//        for (Member member : members) {
//            if (member.getLoginId().equals(loginId)) {
//                return Optional.of(member);
//            }
//        }
//
//        return Optional.empty();
    }

    public List<Users> findAll() {
        return new ArrayList<>(userStorage.values());
    }

    public void clearStorage() {
        userStorage.clear();
    }
}
