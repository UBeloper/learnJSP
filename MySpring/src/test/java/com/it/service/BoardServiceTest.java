package com.it.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.BoardVO;
import com.it.domain.PageDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	//@Test
	public void testRead() {
		BoardVO board = new BoardVO();
		board.setB_num(1);
		board = service.read(board);
		log.info(board);
	}
	
	// @Test
	public void testGetList() {
		PageDTO page = new PageDTO();
		service.getList(page).forEach(board -> log.info(board));
	}
	
	//@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setB_subject("게시판입력테스트...");
		board.setB_name("이도령");
		board.setB_contents("테스트입니다.");
		service.insert(board);
		log.info(board);
	}

	//@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setB_num(7);
		board.setB_subject("게시판입력테스트...수정");
		board.setB_name("이도령수정");
		board.setB_contents("테스트입니다.수정");
		service.update(board);
		log.info(board);
	}
	
	//@Test
	public void testDelete() {
		BoardVO board = new BoardVO();
		board.setB_num(7);
		service.delete(board);
		log.info(board);
	}
	

}
