package com.it.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.service.ProductService;

import lombok.Setter;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Setter(onMethod_ = @Autowired)
	private ProductService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
				
		String m_id = (String)session.getAttribute("m_id");
		model.addAttribute("m_id", m_id);
		model.addAttribute("list", service.getList());
		
		return "index";
	}
	
}
