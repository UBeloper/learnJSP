package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.CartmainVO;
import com.it.domain.CartsubVO;
import com.it.domain.OrderdetailDTO;
import com.it.domain.OrdermainVO;
import com.it.domain.OrdermemberDTO;
import com.it.domain.OrdersubVO;
import com.it.mapper.CartMapper;
import com.it.mapper.OrderMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class OrderServiceImpl implements OrderService {

	@Setter(onMethod_ = @Autowired)
	private OrderMapper ordermapper;
	
	@Setter(onMethod_ = @Autowired)
	private CartMapper cartmapper;
	
	/* 전부처리!! */
	@Override
	public OrdermainVO orderproc(CartmainVO cartmain) { //om_code 반환 (주문리스트에서 사용)
		// 1. 주문 main을 insert
		// 2. cm_code를 사용하여 장바구니 sub 조회
			// cm_code를 이용해서 cartsub 내용을 뽑아내는 메서드를 찾아서
		// System.out.println("이쯤의 cartmain : " + cartmain);

		OrdermainVO ordermain = new OrdermainVO();
		
		ordermain.setM_id(cartmain.getM_id());
		
		ordermapper.insertMain(ordermain);
		
		ordermain = ordermapper.readMainID(ordermain); // 역순으로 조회하여 가장 큰 om_code
		
		// System.out.println("이쯤의 ordermain : " + ordermain);
		
		List<CartsubVO> cartsub = cartmapper.getListCart(cartmain);		
		for (CartsubVO item : cartsub) { // (뽑아낼 변수설정 : List 변수 이름) 
										 // 장바구니에 있는 모든 상품들을 insert
			// 3. om_code 조회
			OrdersubVO ordersub = new OrdersubVO();
			ordersub.setOm_code(ordermain.getOm_code());
			ordersub.setP_code(item.getP_code());
			ordersub.setOs_cnt(item.getCs_cnt());
			
			 // System.out.println("이쯤의 ordersub : " + ordersub);
			
			// 4. ordersub에 insert
			ordermapper.insertSub(ordersub);
		}
		// 5. 장바구니 sub 삭제(cm_code활용)
			cartmapper.deletesuball(cartmain);
		// 6. 장바구니 main 삭제(cm_code활용)
			cartmapper.deleteMain(cartmain);
			
			// om_code를 반환			
			return ordermain;
	}

	@Override
	public List<OrderdetailDTO> getOrderdetail(OrdermainVO ordermain) {
		return ordermapper.getOrderdetail(ordermain);
	}

	@Override
	public OrdermainVO readMainID(OrdermainVO ordermain) {
		return ordermapper.readMainID(ordermain);
	}

	@Override
	public OrdermemberDTO getOrdertotal(OrdermainVO ordermain) {
		return ordermapper.getOrdertotal(ordermain);
	}

	   
}
