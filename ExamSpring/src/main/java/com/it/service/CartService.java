package com.it.service;

import java.util.List;

import com.it.domain.CartdetailDTO;
import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;

public interface CartService {

	public void cartInsert(CartmainVO cartmain, CartsubVO cartsub);
	
	public CartmainVO readMainID(CartmainVO cartmain);
	
	public List<CartsubVO> getListCart(CartmainVO cartmain);
	
	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain);

	public CartmemberDTO getCartTotal(CartmainVO cartmain);
	
	public void updateSub(CartsubVO cartsub);
	
	public void deleteSub(CartsubVO cartsub);
	
	public void deleteMain(CartmainVO cartmain);
	
	public void deletesuball(CartmainVO cartmain);
	
	public int cartCnt(CartmainVO cartmain);
}
