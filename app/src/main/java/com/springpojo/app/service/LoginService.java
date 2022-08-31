package com.springpojo.app.service;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    /**
     * @return null 로그인 실패
     */
    public Users login(String userId, String userPw) {
        Optional<Users> optionalUsers = userRepository.findByLoginId(userId);

        return optionalUsers
                .filter(users -> users.getUserPw().equals(userPw))
                .orElse(null);

//        Member member = optionalMember.get();
//
//        if (member.getPassword().equals(password)) {
//            return member;
//        } else {
//            return null;
//        }
    }
}




















