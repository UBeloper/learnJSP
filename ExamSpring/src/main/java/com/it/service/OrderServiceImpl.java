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

@Service
public class OrderServiceImpl implements OrderService {
	
	@Setter(onMethod_ = @Autowired)
	private OrderMapper ordermapper;
	
	@Setter(onMethod_ = @Autowired)
	private CartMapper cartmapper;

	@Override
	public OrdermainVO readMainID(OrdermainVO ordermain) {
		return ordermapper.readMainID(ordermain);
	}

	@Override
	public OrdermainVO orderproc(CartmainVO cartmain) {
		
		OrdermainVO ordermain = new OrdermainVO();
		ordermain.setM_id(cartmain.getM_id());
		ordermapper.insertMain(ordermain);
		ordermain = ordermapper.readMainID(ordermain);
		// ordermain에 가장 최근 주문(limit 1) 담김
		
		// 카트서브내용 오더서브에 담기
		List<CartsubVO> cartsub = cartmapper.getListCart(cartmain);
		for(CartsubVO item : cartsub) {
			OrdersubVO ordersub = new OrdersubVO();
			ordersub.setOm_code(ordermain.getOm_code());
			ordersub.setP_code(item.getP_code());
			ordersub.setOs_cnt(item.getCs_cnt());
			
			ordermapper.insertSub(ordersub);
		}
		
		cartmapper.deletesuball(cartmain);
		cartmapper.deleteMain(cartmain);
		
		return ordermain;
		
	}

	@Override
	public List<OrderdetailDTO> getOrderdetail(OrdermainVO ordermain) {
		return ordermapper.getOrderdetail(ordermain);
	}

	@Override
	public OrdermemberDTO getOrdertotal(OrdermainVO ordermain) {
		return ordermapper.getOrdertotal(ordermain);
	}
	
}
