package com.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.CartmainVO;
import com.it.domain.CartsubVO;
import com.it.service.CartService;
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

	@Setter(onMethod_ = @Autowired)
	private CartService cartservice;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", productservice.getList());
	}

	@PostMapping("/cart")
	public String cart(CartsubVO cartsub, HttpSession session) {
		String m_id = (String)session.getAttribute("m_id");
		if(m_id != null) { // 장바구니 처리 진행
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id); // VO에 사용자의 세션정보를 저장
			cartservice.cartInsert(cartmain, cartsub); // 서비스계층 호출
//			log.info(m_id + "님이 로그인 중");
			return "redirect:/shop/cartinfo"; 
			//redirect -> 컨트롤러로 다시 돌아오라는 뜻
			
		} else { // 리다이렉션
			return "redirect:/member/login";
//			log.info("로그인 안됨");
		}
	}
	
	@GetMapping("/cartinfo")
	public void cartinfo() {
	// 세션아이디를 이용해서 cm_code를 조회해야 함
	// cm_code를 이용해서 getListCart 를 조회 -> 뿌려주기
		
	}
	
	
}
