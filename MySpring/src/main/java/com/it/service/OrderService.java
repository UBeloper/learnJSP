package com.it.service;

import java.util.List;

import com.it.domain.CartmainVO;
import com.it.domain.OrderdetailDTO;
import com.it.domain.OrdermainVO;
import com.it.domain.OrdermemberDTO;

public interface OrderService {
	
	public OrdermainVO orderproc(CartmainVO cartmain);
	
	public List<OrderdetailDTO> getOrderdetail(OrdermainVO ordermain);
	
	public OrdermainVO readMainID(OrdermainVO ordermain);
	
	public OrdermemberDTO getOrdertotal(OrdermainVO ordermain);
	
}
