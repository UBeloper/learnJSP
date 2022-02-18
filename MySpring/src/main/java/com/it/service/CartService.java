package com.it.service;

import java.util.List;

import com.it.domain.CartdetailDTO;
import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;

public interface CartService {
	
	public void cartInsert(CartmainVO cartmain, CartsubVO cartsub);
	
	// 장바구니에서 특정 id로 cmcode를 조회하는 쿼리
	public CartmainVO readMainID(CartmainVO cartmain);
	
	public List<CartsubVO> getListCart(CartmainVO cartmain);
	
	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain);

	public CartmemberDTO getCartTotal(CartmainVO cartmain);
		
	/*
	 * public List<CartmainVO> getListMain(); public List<CartsubVO> getListSub();
	 * 
	 * public CartmainVO readMain(); public CartsubVO readSub();
	 */
	
}
