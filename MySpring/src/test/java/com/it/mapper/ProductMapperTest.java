package com.it.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.ProductVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductMapperTest {
	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	//@Test
	public void testGetList() {
		mapper.getList().forEach(product -> log.info(product)); //레코드만큼 반복하는 람다식
	}
	
	//@Test
	public void testInsert() {
		ProductVO product = new ProductVO();
		product.setP_name("삼성냉장고200리터");
		product.setP_price(2000000);
		mapper.insert(product);
		
	}
	
	//@Test
	public void testRead() {

	}
	

}
