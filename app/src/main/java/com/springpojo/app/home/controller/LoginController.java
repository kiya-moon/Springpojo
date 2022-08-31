package com.springpojo.app.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springpojo.app.DTO.Users;
import com.springpojo.app.service.LoginService;
import com.springpojo.app.session.LoginForm;
import com.springpojo.app.session.SessionConstant;
import com.springpojo.app.session.SessionManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/login";
    }

    // @PostMapping("/login")
    public String login(@Validated @ModelAttribute("login") LoginForm form
            , BindingResult bindingResult
            , HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Users users = loginService.login(form.getUserId(), form.getUserPw());

        if (users == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");

            return "login/login";
        }

        // 로그인 성공 처리
        // 쿠키에 시간 정보를 주지 않으면 세션 쿠키 (브라우저 종료 시 모두 종료)
        Cookie cookie = new Cookie("usersId", String.valueOf(users.getId()));
        response.addCookie(cookie);

        return "redirect:/";
    }

    // @PostMapping("/login")
    public String loginV2(@Validated @ModelAttribute("loginForm") LoginForm form
            , BindingResult bindingResult
            , HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Users users = loginService.login(form.getUserId(), form.getUserPw());

        if (users == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");

            return "login/login";
        }

        // 로그인 성공 처리

        // 세션 관리자를 통해 세션을 생성하고 회원 데이터 보관
        sessionManager.createSession(users, response);

        return "redirect:/";
    }

    // @PostMapping("/login")
    public String loginV3(@Validated @ModelAttribute("loginForm") LoginForm form
            , BindingResult bindingResult
            , HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Users users = loginService.login(form.getUserId(), form.getUserPw());

        if (users == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");

            return "login/login";
        }

        // 로그인 성공 처리
        // 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        // 세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConstant.LOGIN_USERS, users);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginV4(@Validated @ModelAttribute("loginForm") LoginForm form
            , BindingResult bindingResult
            , @RequestParam(defaultValue = "/") String redirectURL
            , HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Users users = loginService.login(form.getUserId(), form.getUserPw());

        if (users == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");

            return "login/login";
        }

        // 로그인 성공 처리
        // 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        // 세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConstant.LOGIN_USERS, users);

        return "redirect:/"; 
    }

//    // @PostMapping("/logout")
//    public String logout(HttpServletResponse response) {
//        expireCookie(response, "memberId");
//
//        return "redirect:/";
//    }
//
//    // @PostMapping("/logout")
//    public String logoutV2(HttpServletRequest request) {
//        sessionManager.expireCookie(request);
//
//        return "redirect:/";
//    }

    @PostMapping("/logout")
    public String logoutV3(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);

        response.addCookie(cookie);
    }
}