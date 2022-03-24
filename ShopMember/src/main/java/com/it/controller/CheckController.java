package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.CheckVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/")
public class CheckController {

	@GetMapping
	public String getCheckPage() {
		return "home";
	}
	
	@PostMapping("/check")
	public String checkLogic(CheckVO check, Model model) {
		log.info(check);
		model.addAttribute("check", check);
		return "home";
	}
	
	
}
