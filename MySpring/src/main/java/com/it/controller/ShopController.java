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
import com.it.service.MemberService;
import com.it.service.OrderService;
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
	
	@Setter(onMethod_ = @Autowired)
	private OrderService orderservice;

	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", productservice.getList());
	}

	@PostMapping("/cart")
	public String cart(CartsubVO cartsub, HttpSession session) {
		String m_id = (String) session.getAttribute("m_id");
		if (m_id != null) { // 장바구니 처리 진행
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id); // VO에 사용자의 세션정보를 저장
			cartservice.cartInsert(cartmain, cartsub); // 서비스계층 호출
//			log.info(m_id + "님이 로그인 중");
			return "redirect:/shop/cartinfo";
			// redirect -> 컨트롤러로 다시 돌아오라는 뜻

		} else { // 리다이렉션
			return "redirect:/member/login";
//			log.info("로그인 안됨");
		}
	}

	@GetMapping("/cartinfo")
	public String cartinfo(HttpSession session, Model model) {
		// ★ 
		// 어떤건 redirect하고 어떤건 redirect안해도
		// String을 써야한다!
		// 다른 폴더로 가야하는 경우 있으면 절대경로로 써주면 된다.
		
		// 로그인 상태 확인
		String m_id = (String) session.getAttribute("m_id");
		String m_name = (String) session.getAttribute("m_name");
		
		if (m_id != null) { // 접속되어 있다는 뜻이고,
			// 세션아이디를 이용해서 cm_code를 조회해야 함
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id);
			cartmain = cartservice.readMainID(cartmain);

			if (cartmain != null) { // 해당 id 장바구니가 있느냐 없느냐.
//				int cm_code = cartmain.getCm_code(); // 로그인 된 사용자의 아이디를 사용하는 cm_code
				// 가방이 파라미터라 뽑아낼 필요 없었는데 함.
				// 장바구니에 내용이 없는 경우.
				log.info("장바구니 내용 있음");

				// cm_code를 이용해서 getListCart 를 조회 -> 뿌려주기
//				cartservice.getListCart(cartmain).forEach(x -> log.info(x)); // 디버깅용
				model.addAttribute("list", cartservice.getListCartDetail(cartmain));
				
				// mapper.xml에 total만 갖고있으므로 이왕 넘기는거 다 불러올 수 있게끔.
				CartmemberDTO cartmember = cartservice.getCartTotal(cartmain);
				cartmember.setCm_code(cartmain.getCm_code());
				cartmember.setM_id(m_id);
				cartmember.setM_name(m_name);
				
				model.addAttribute("cartmember", cartmember);
				model.addAttribute("cm_code", cartmain.getCm_code());
				// delete에 사용할 cm_code를 받아옴. 장바구니 세부항목 삭제시 필요.
				
			} else {
				log.info("장바구니 내용 없음");
				
			}

			log.info("로그인 상태 : " + m_id);
//			return "redirect:/shop/cartinfo";
			return "shop/cartinfo";
			
			
			// 자체적으로 메서드를 훑고나서 그냥 페이지만 return vs 메서드를 훑고 내려오는거(redirect) ==>>
			// 위의 IF문부터 쭉하고 밑에 내려온거니까 REDIRECT하면 "또" 컨트롤러의 메서드를 훑는거기 때문에 부적절
			// 즉 자기자신에게 return direct하는거자체가 redirect가 맞지 않지 당연히.
			
		} else {
			log.info("로그아웃 상태");
//			return "redirect:/member/login"; //컨트롤러의 메서드를 호출 후에 JSP로
			return "redirect:/member/login";
			// 컨트롤러 통과여부가 헷갈리면 redirect써도 상관 없음.
		}

	}
	
	
	@PostMapping("/cartupdate")
	public String cartupdate(CartsubVO cartsub) {
		cartservice.updateSub(cartsub);
		return "redirect:/shop/cartinfo";
	}
	
	
	  @GetMapping("/cartdelete") 
	  public String cartdelete(CartsubVO cartsub) {
//		  log.info(cartsub); // cm_code가 같이 넘어오도록 위의 cartinfo에 cm_code를 알 수있는 model.addAttribute추가
		  cartservice.deleteSub(cartsub);
		  
		  return "redirect:/shop/cartinfo";
		  
	  }
	  
	  @GetMapping("/cartdeleteall")
	  public String cartdeleteall(CartmainVO cartmain) {
		  log.info(cartmain);
		  cartservice.deletesuball(cartmain);
		  return "redirect:/shop/cartinfo";
		  
	  }
	  
	  @GetMapping("/orderinfo")
	  public String order(HttpSession session, CartmainVO cartmain, Model model) {
		  String m_id = (String)session.getAttribute("m_id");
		  String m_name = (String)session.getAttribute("m_name");
		 			
		  if (m_id != null) { 

		  cartmain.setM_id(m_id);
		  OrdermainVO ordermain = orderservice.orderproc(cartmain);
		  
//		  orderservice.orderproc(cartmain); // 이런식에서 ->
		  // -> orderproc의 반환타입을 OrdermainVO로 바꿔서 om_code를 반환하는 방법 사용
		  // => 서류 하나 떼러간김에 다른 것도 떼어오기
		  
		  /* 위의 한줄에 이건 무의미 */
		  // OrdermainVO ordermain = new OrdermainVO();
		  // ordermain.setM_id(m_id);
		  // ordermain = orderservice.readMainID(ordermain);
		  
		  OrdermemberDTO ordermember = new OrdermemberDTO();
		  ordermember.setOm_total(orderservice.getOrdertotal(ordermain).getOm_total());
		  ordermember.setOm_code(ordermain.getOm_code());
		  ordermember.setM_name(m_name);
		  ordermember.setM_id(m_id);
		  
		  
//		  List<OrderdetailDTO> orderdetail = orderservice.getOrderdetail(ordermain);
//		  model.addAttribute("list", orderdetail);
//		  그냥 한줄로 하자.
		  model.addAttribute("list", orderservice.getOrderdetail(ordermain));
		 
		  model.addAttribute("ordermember", ordermember);
		  
		  } else {
			  return "/member/login";
		  }
		  
		  return "/shop/orderinfo";
	  }
	 

}
