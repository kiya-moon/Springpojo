package com.springpojo.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springpojo.app.DTO.User;
import com.springpojo.app.repository.UserRepository;
import com.springpojo.app.service.LoginService;
import com.springpojo.app.session.SessionManager;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

	private final LoginService loginService;
	private final UserRepository userRepository;
	// 세션
	private final SessionManager sessionManager;

	
//	// 로그인
//	@PostMapping("login")
//	public String loginId(@ModelAttribute User user) {
//
//		loginService.loginUser(user);
//		
//		return "redirect:/";
//		
//	}
	
//	@GetMapping("login")
//	public String loginForm(@ModelAttribute("LoginForm") LoginForm form) {
//		return "login/login";
//	}

//	// 직접 만든 세션 사용
//	@PostMapping("login")
//	@RequestMapping(value="/", method=RequestMethod.POST)
//	public String loginV2(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
//			HttpServletResponse response) {
//
//		User loginUser = loginService.login(form.getUserId(), form.getUserPw());
//
//		if (loginUser == null) {
//			bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
//			return "login/login";
//		}
//
//		// 로그인 성공 처리
//
//		// 세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
//		sessionManager.createSession(loginUser, response);
//
//		return "redirect:/";
//
//	}
	
//	@PostMapping("/login")
//	public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
//	                          HttpServletRequest request){
//
//	        if (bindingResult.hasErrors()){
//	            return "login/loginForm";
//	        }
//
//	        User loginMember = loginService.login(form.getUserId(), form.getUserPw());
//
//	        if (loginMember == null){
//	            bindingResult.reject("loginFali", "아이디 또는 비번이 맞지 않습니다.");
//	            return "login/login";
//	        }
//
//	        // 로그인 성공 처리
//	        // 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
//	        HttpSession session = request.getSession();
//	        // 세션에 로그인 회원 정보 보관
//	        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
//	        return "redirect:/";
//	}
//	
//	@PostMapping("/logout")
//	public String logout(HttpServletRequest request){
//	        // 세션을 삭제한다.
//	        HttpSession session = request.getSession(false);
//	        if (session != null){
//	            session.invalidate();
//	        }
//	        return "redirect:/";
//	}
//	
//	
//	@GetMapping("/")
//	public String homeLogin(HttpServletRequest request, Model model) {
//
//	        // 세션이 없으면 home
//	        HttpSession session = request.getSession(false);
//	        if (session == null) {
//	            return "contents/home";
//	        }
//
//	        User loginMember = (User) session.getAttribute(SessionConst.LOGIN_MEMBER);
//
//	        // 세션에 회원 데이터가 없으면 home
//	        if (loginMember == null) {
//	            return "contents/home";
//	        }
//
//	        // 세션에 회원 데이터가 있으면 로그인한 유저를 위한 홈 화면으로 이동
//	        model.addAttribute("user", loginMember);
//	        return "contents/home";
//	}
	

//  // 서블릿 HTTP 세션 사용
////  @PostMapping("/login")
//  public String loginV3(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
//      if (bindingResult.hasErrors()) {
//          return "login/loginForm";
//      }
//
//      User loginUser = loginService.login(form.getUserId(), form.getUserPw());
//
//      if (loginUser == null) {
//          bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
//          return "login/loginForm";
//      }
//
//      // 로그인 성공 처리
//      // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성해서 반환
//      // getSession() : 디폴트가 true, false는 세션이 없을 때 새로 만들지 않고 null을 반환
//      HttpSession session = request.getSession();
//      // 세션에 로그인 회원 정보 보관
//      session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser);
//
//      return "redirect:/";
//  }

//	@PostMapping("/login")
//	public String loginV4(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
//			@RequestParam(defaultValue = "/") String redirectURL, HttpServletRequest request) {
//
//		if (bindingResult.hasErrors()) {
//			return "login/login";
//		}
//
//		User loginUser = loginService.login(form.getUserId(), form.getUserPw());
//
//		if (loginUser == null) {
//			bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
//			return "login/login";
//		}
//
//		// 로그인 성공 처리
//		// 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
//		HttpSession session = request.getSession();
//		// 세션에 로그인 회원 정보 보관
//		session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser);
//
//		return "redirect:" + redirectURL;
//
//	}

////  @PostMapping("/logout")
//	public String logout(HttpServletResponse response) {
//		expireCookie(response, "UserId");
//		return "redirect:/";
//	}
//
////  @PostMapping("/logout")
//	public String logoutV2(HttpServletRequest request) {
//		// 세션 만료 적용
//		sessionManager.expire(request);
//		return "redirect:/";
//	}

//	// 서블릿 HTTP 세션 사용
//	@PostMapping("/logout")
//	public String logoutV3(HttpServletRequest request) {
//		// getSession(false) 를 사용해야 함 (세션이 없더라도 새로 생성하면 안되기 때문)
//		HttpSession session = request.getSession(false);
//		if (session != null) {
//			session.invalidate();
//		}
//		return "redirect:/";
//	}

//	private void expireCookie(HttpServletResponse response, String cookieName) {
//		Cookie cookie = new Cookie(cookieName, null);
//		cookie.setMaxAge(0);
//		response.addCookie(cookie);
//	}
	
	
	
	
}