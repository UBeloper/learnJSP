package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.service.MemberService;
import com.it.service.ProductService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/shop/")
public class ShopController {
	
	@Setter(onMethod_ = @Autowired)
	private ProductService productservice;
	
	@Setter(onMethod_ = @Autowired)
	private MemberService memberservice;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", productservice.getList());
	}

}
