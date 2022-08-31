package com.springpojo.app.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String SESSION_ID = "sessionId";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("supportsParameter 실행"); // 캐시에 저장되어 supportsParameter는 한번만 실행

        // @Login 커스텀 어노테이션 여부 확인
        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);

        // sessionId는 문자열이므로 String 타입인지 확인
        boolean hasStringType = String.class.isAssignableFrom(parameter.getParameterType());

        // 두 개 다 만족해야지 해당 ArgumentResolver가 지원하는 타입
        return hasLoginAnnotation && hasStringType;

    }

    @Override
    public Object resolveArgument(MethodParameter parameter
            , ModelAndViewContainer mavContainer
            , NativeWebRequest webRequest
            , WebDataBinderFactory binderFactory) throws Exception {

        log.info("resolveArgument 실행");

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = request.getSession(false);

        if (session == null) {
            return null;
        }

        // 세션 내 해당 속성이 없을 경우 null
        // 있으면 sessionId 반환
        Object users = session.getAttribute(SessionConstant.LOGIN_USERS);

        return users;
    }
}
