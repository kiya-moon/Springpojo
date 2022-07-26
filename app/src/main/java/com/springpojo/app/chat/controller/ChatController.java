package com.springpojo.app.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ChatController {
	@GetMapping("/chat/icon")
	public String clickIcon() {
		return "chat/icon";
	}
	
	@GetMapping("/chat")
	public String chatGET() {
		log.info("@ChatController, chatGET()");
		
		return "chat";
	}
}
