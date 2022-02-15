package com.it.mapper;

import java.util.List;

import com.it.domain.CartmainVO;
import com.it.domain.CartsubVO;

public interface CartMapper {
	public List<CartmainVO> getListMain();
	public List<CartsubVO> getListSub();
	
	public List<CartsubVO> getListCart();
	
	public void insertMain(CartmainVO cartmain);
	public void insertSub(CartsubVO cartsub);
	
	public CartmainVO readMain(CartmainVO cartmain);
	public CartsubVO readSub(CartsubVO cartsub);
	
	
	public CartmainVO readMainID(CartmainVO cartmain);
	
	public CartsubVO readSubProduct(CartsubVO cartsub);
	
	public void updateMain(CartmainVO cartmain);
	public void updateSub(CartsubVO cartsub);
	
	public void deleteMain(CartmainVO cartmain);
	public void deleteSub(CartsubVO cartsub);
	
	
	
}
