package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/list")
	public void getMembersPage(Model model) {
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/delete")
	public String deleteMember(MemberVO member) {
//		service.delete(member);
		log.info(member);
		return "redirect:/member/list";
	}
}
