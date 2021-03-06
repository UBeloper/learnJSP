package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.CartdetailDTO;
import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;
import com.it.mapper.CartMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CartServiceImpl implements CartService {

	@Setter(onMethod_ = @Autowired)
	private CartMapper mapper;

	@Override
	public void cartInsert(CartmainVO cartmain, CartsubVO cartsub) {
		CartmainVO cm = new CartmainVO();
		cm = mapper.readMainID(cartmain); // 세션 아이디를 인수로 조회하여 결과 얻기

		if (cm == null) { // cartmain에 해당사용자의 레코드 1개를 신규생성해야 함.
			
			mapper.insertMain(cartmain);
			// cm_code가 생성되었으나 조회해봐야 알 수 있음.
			cm = mapper.readMainID(cartmain); // 해당사용자로 신규 추가 후 조회

			cartsub.setCm_code(cm.getCm_code()); // 조회한 신규 cm_code를 cartsub에 추가
			mapper.insertSub(cartsub);
			// '최초'담기니까 중복 체크과정이 필요없음.

		} else { // 이미 최소 1개는 카트에 상품이 존재한다는 의미

			cartsub.setCm_code(cm.getCm_code()); // 조회한 신규 cm_code를 cartsub에 추가

			CartsubVO cs = new CartsubVO();
			cs = mapper.readSubProduct(cartsub);

			if (cs == null) { // 기존상품이 장바구니에 없다면
				mapper.insertSub(cartsub);
			} else {
				cs.setCs_cnt(cs.getCs_cnt() + cartsub.getCs_cnt()); // 기존 + 신규
				mapper.updateSub(cs);
			}
		}
	}

	@Override
	public CartmainVO readMainID(CartmainVO cartmain) {
		cartmain = mapper.readMainID(cartmain); // 특정사용자 ID로 조회
		return cartmain;
	}

	@Override
	public List<CartsubVO> getListCart(CartmainVO cartmain) {
		return mapper.getListCart(cartmain);
	}

	@Override
	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain) {
		return mapper.getListCartDetail(cartmain);
	}

	@Override
	public CartmemberDTO getCartTotal(CartmainVO cartmain) {
		return mapper.getCartTotal(cartmain);
	}

	@Override
	public void updateSub(CartsubVO cartsub) {
		mapper.updateSub(cartsub);	
	}

	@Override
	public void deleteSub(CartsubVO cartsub) {
		mapper.deleteSub(cartsub);
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(cartsub.getCm_code());
		List<CartsubVO> tmp = mapper.getListCart(cartmain);
		
		if(tmp.size() == 0) { //장바구니에 상품이 1개도 없음
			mapper.deleteMain(cartmain);
		}	
		
		 // 확인용
		  List<CartsubVO> tmp2 = mapper.getListCart(cartmain);
		  System.out.println("tmp2 : " + tmp2);
		  System.out.println("tmp2.size() : " + tmp.size()); //확인용
		
		
		/*
		 * if(tmp.size() < 1) { mapper.deleteMain(cartmain); }
		 */
		// 이게 맞다. tmp는 List형태이므로 아무것도 없을 때 0 
	}

	@Override
	public void deleteMain(CartmainVO cartmain) {
		mapper.deleteMain(cartmain);	
	}

	@Override
	public void deletesuball(CartmainVO cartmain) {
		mapper.deletesuball(cartmain);
		mapper.deleteMain(cartmain);
		
	}
	 

	
	
	
}
