package com.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.MemberVO;
import com.it.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/")
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	
	@GetMapping("/login")
	public void getloginpage() {
		
	}
	
	@PostMapping("/login")
	public String logincheck(MemberVO member, HttpSession session) {
		boolean loginchk;
		loginchk = service.auth(member);
		
		if(loginchk == true) {
			session.setAttribute("m_id", member.getM_id());
			log.info("LOGIN 세션생성");
			return "redirect:/";
		} else {
			log.info("인증실패");
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/regist")
	public void getregistpage() {
		
	}
	
	
	
}
