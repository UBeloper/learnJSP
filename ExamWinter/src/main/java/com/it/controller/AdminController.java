package com.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.AdminVO;
import com.it.service.AdminService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin")
public class AdminController {
	
	@Setter(onMethod_ = @Autowired)
	private AdminService service;

	@GetMapping("/login")
	public void callLoginPage() {
		
	}
	
	@PostMapping("/login")
	public String loginpagetolist(AdminVO admin, HttpSession session) {
		log.info(admin);
		boolean chk = service.auth(admin);
		log.info(chk);
		if (chk == true) {
			admin = service.read(admin);
			session.setAttribute("a_id", admin.getA_id()); //세션변수 생성
			session.setAttribute("a_name", admin.getA_name()); //세션변수 생성
			log.info("인증성공");
			return "redirect:/product/list";
			
		} else {
			log.info("인증실패");
			return "redirect:/admin/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login";
	}
	
}
