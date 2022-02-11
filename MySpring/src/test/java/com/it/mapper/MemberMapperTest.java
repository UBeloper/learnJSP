package com.it.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	//@Test
	public void testGetList() {
		mapper.getList().forEach(member -> log.info(member)); //레코드만큼 반복하는 람다식
	}
	
	//@Test
	public void testInsert() {
		
	}
	
	//@Test
	public void testRead() {

	}
	
	//@Test
	public void testUpdate() {

	}
	
	//@Test
	public void testDelete() {

	}

}
