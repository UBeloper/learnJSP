package com.it.mapper;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.CartdetailDTO;
import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CartMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private CartMapper mapper;
	
	
	// @Test
	public void getListTest() {
		CartmainVO cartmain = new CartmainVO(); 
		CartsubVO cartsub = new CartsubVO();
		
		mapper.getListSub().forEach(x->log.info(x));
		mapper.getListMain().forEach(x->log.info(x));
	}
	
	// @Test
	public void insertTest() {		
		CartmainVO cartmain = new CartmainVO();
		cartmain.setM_id("tiger");
		
		CartsubVO cartsub = new CartsubVO();		
		cartsub.setCm_code(1001); //tiger's cm_code
		cartsub.setP_code(1004);
		cartsub.setCs_cnt(2);
		
		log.info(cartsub);
		log.info(cartmain);
		/* mapper.insertMain(cartmain); */
		mapper.insertSub(cartsub);
	}
	
	// @Test
	public void updateSubTest() {
	}
	
	// @Test
	public void deleteSubTest() {
		CartsubVO cartsub = new CartsubVO();
		cartsub.setCs_code(1008);
		
		mapper.deleteSub(cartsub);
	}
	
	// @Test
	public void deletemainTest() {
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(1001);
		mapper.deleteMain(cartmain);
	}
	
	// @Test
	public void testCartDetail() {
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(1003);
		
		List<CartdetailDTO> cartdetail = mapper.getListCartDetail(cartmain);
//		log.info(cartdetail);
		cartdetail.forEach(x -> log.info(x));
						
	}
	
	
	// @Test
	public void testCartTotal() {
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(1003);
		
		CartmemberDTO cartmember = mapper.getCartTotal(cartmain);
		log.info(cartmember);
	}
}
