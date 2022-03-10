package com.it.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.AdminVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private AdminMapper mapper;
	
	// @Test
	public void readtest() {
		AdminVO adm = new AdminVO();
		adm.setA_id("admin");
		adm.setA_passwd("tiger123");
		// log.info(adm);
		adm = mapper.read(adm);
		log.info(adm);
		
	}
}
