package com.it.mapper;

import java.util.List;

import com.it.domain.OrderdetailDTO;
import com.it.domain.OrdermainVO;
import com.it.domain.OrdermemberDTO;
import com.it.domain.OrdersubVO;

public interface OrderMapper {
	
	public void insertMain(OrdermainVO ordermain);
	public void insertSub(OrdersubVO ordersub);
	
	public OrdermainVO readMainID(OrdermainVO ordermain);
	
	public List<OrderdetailDTO> getOrderdetail(OrdermainVO ordermain);
	public OrdermemberDTO getOrdertotal(OrdermainVO ordermain);
	
}
