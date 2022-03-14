package com.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;
import com.it.domain.OrdermainVO;
import com.it.domain.OrdermemberDTO;
import com.it.service.CartService;
import com.it.service.OrderService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/shop/")
public class ShopController {

	@Setter(onMethod_ = @Autowired)
	private CartService cartservice;
	
	@Setter(onMethod_ = @Autowired)
	private OrderService orderservice;
	
	@PostMapping("/cart")
	public String cartInsert(HttpSession session, CartsubVO cartsub) {
		String m_id = (String)session.getAttribute("m_id");
		log.info(m_id);
		log.info(cartsub);
		
		if(m_id != null) {
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id);
			cartservice.cartInsert(cartmain, cartsub); // cm_code랑 p_code, cs_cnt
			return "redirect:/shop/cartinfo";
			
		} else {
			return "redirect:/member/login";
		}
		
		}
	
	@GetMapping("/cartinfo")
	public String getCartinfoPage(Model model, HttpSession session) {
		String m_id = (String)session.getAttribute("m_id");
		String m_name = (String)session.getAttribute("m_name");
		
		if(m_id != null) { //접속중
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id);
			cartmain = cartservice.readMainID(cartmain);
			
			if(cartmain != null) { //카트에 상품이 있으면 => 리스팅하기
				model.addAttribute("list", cartservice.getListCartDetail(cartmain));
				
				CartmemberDTO cartmember = cartservice.getCartTotal(cartmain);
				cartmember.setCm_code(cartmain.getCm_code());
				cartmember.setM_id(m_id);
				cartmember.setM_name(m_name);
				
				model.addAttribute("cartmember", cartmember);
				model.addAttribute("cm_code", cartmain.getCm_code());
				
			} else { //상품이 없으면
				log.info("장바구니 내용 없음!");
			}
			
			return "/shop/cartinfo";
			
		
		}else {
			return "redirect:/member/login";
		}
	}
	
	@PostMapping("/cartupdate")
	public String cartupdate(CartsubVO cartsub) {
		cartservice.updateSub(cartsub);
		return "redirect:/shop/cartinfo";
	}
	
	@GetMapping("/cartdelete") 
	public String cartdelete(CartsubVO cartsub) {
		  cartservice.deleteSub(cartsub);
		  
		  return "redirect:/shop/cartinfo";
	  }
	
	@GetMapping("/cartdeleteall")
	  public String cartdeleteall(CartmainVO cartmain) {
		  cartservice.deletesuball(cartmain);
		  return "redirect:/shop/cartinfo";
		  
	 }
	
	@GetMapping("/orderinfo")
	public String order(HttpSession session, CartmainVO cartmain, Model model) {
		String m_id = (String)session.getAttribute("m_id");
		String m_name = (String)session.getAttribute("m_name");
		
		if(m_id != null) {
			cartmain.setM_id(m_id);
			OrdermainVO ordermain = orderservice.orderproc(cartmain);
			
			OrdermemberDTO ordermember = new OrdermemberDTO();
			ordermember.setOm_total(orderservice.getOrdertotal(ordermain).getOm_total());
			ordermember.setM_id(m_id);
			ordermember.setM_id(m_name);
			ordermember.setOm_code(ordermain.getOm_code());
			
			model.addAttribute("list", orderservice.getOrderdetail(ordermain));
			model.addAttribute("ordermember", ordermember);
		
		} else {
			return "/member/login";
		}
		return "shop/orderinfo";
	}
	
	
	
	
	
}
