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
@RequestMapping("/admin/")
public class AdminController {

	@Setter(onMethod_ = @Autowired)
	private AdminService service;
	
	@GetMapping("/login")
	public void loginpage() {
		
	}
	
	@PostMapping("/login")
	public String loginauth(AdminVO admin, HttpSession session) {
//		boolean chk = service.auth(admin);
		if(service.auth(admin) == true) {
			session.setAttribute("a_id", admin.getA_id());
			log.info(admin.getA_id() + "님 환영합니다!");
			return "redirect:/";
		} else {
			log.info("인증실패");
			return "redirect:/admin/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
