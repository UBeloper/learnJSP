package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member/")
public class BookController {
	
	@GetMapping("/login")
	public void callLoginPage() {
		// 로그인 페이지 호출
	}
	
	@GetMapping("/join")
	public void callJoinPage() {
		// 회원가입 페이지 호출
	}
	
}
