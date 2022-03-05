package com.it.mapper;

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
public class MemberMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	// @Test
	public void readtest() {
		MemberVO member = new MemberVO();
		member.setM_id("tiger");
		
		member = mapper.read(member);
		log.info(member);
		
	}
	
	// @Test
	public void getListTEST() {
		mapper.getList().forEach(x -> log.info(x));
	}

}
