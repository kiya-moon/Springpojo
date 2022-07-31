package com.springpojo.app.chat.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

// 핸들러를 이용해 WebSocket을 호라성화하기 위한 Config
// @EnableWebSocket > WebSocket 활성화

@Configuration
@RequiredArgsConstructor
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	private final ChatHandler chatHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// /chat > WebSocket에 접속하기 위한 EndPoint
		// CORS : setAllowedOrigins("*"); > 도메인이 다른 서버에서도 접속 가능하도록 해준다.
		/*
		 * CORS(Cross-Origin Resource Sharing, 교차 출처 리소스 공유)
		 * 추가 HTTP 헤더를 사용하여, 한 출처에서 실행중인 웹 어플리케이션에 
		 * 다른 출처의 선택 자원이 접근할 수 있도록 권한을 부여하라고 브라우저에 알려주는 체제
		 */
		registry.addHandler(chatHandler, "ws/chat").setAllowedOrigins("*");
	}
	
	// 여기까지가 클라이언트가 ws://localhost:9090/chat으로 커넥션을 연결하고 메세지 통신을 할 수 있는 준비를 마친 것
}
