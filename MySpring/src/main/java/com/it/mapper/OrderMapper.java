package com.it.mapper;

import com.it.domain.OrdermainVO;
import com.it.domain.OrdersubVO;

public interface OrderMapper {
	
	public void insertMain(OrdermainVO ordermain);
	public void insertSub(OrdersubVO ordersub);
	
	public OrdermainVO readMainID(OrdermainVO ordermain);
	
//	public void update(OrdermainVO ordermain);
//	public void delete(OrdermainVO ordermain);
	
//	public List<OrdermainVO> getList();
//	public OrdermainVO read(OrdermainVO ordermain);
	
}
