package com.it.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTest {
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	//@Test
	public void testRead() {

	}
	
	//@Test
	public void testAuth() {
		MemberVO member = new MemberVO();
		member.setM_id("tiger");
		member.setM_passwd("1234");
		service.auth(member);
	}
	
	//@Test
	public void testGetList() {
		service.getList().forEach(member -> log.info(member));
	}
	
	//@Test
	public void testInsert() {

	}

	//@Test
	public void testUpdate() {
	}
	
	//@Test
	public void testDelete() {

	}

}
