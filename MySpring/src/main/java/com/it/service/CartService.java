package com.it.service;

import com.it.domain.CartmainVO;
import com.it.domain.CartsubVO;

public interface CartService {
	
	public void cartInsert(CartmainVO cartmain, CartsubVO cartsub);
		
	/*
	 * public List<CartmainVO> getListMain(); public List<CartsubVO> getListSub();
	 * 
	 * public CartmainVO readMain(); public CartsubVO readSub();
	 */
	
}