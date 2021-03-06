package com.it.mapper;

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
public class BoardMapperTest {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	// @Test
	public void testGetList() {
		PageDTO page = new PageDTO(3, 10);
		mapper.getList(page).forEach(board -> log.info(board)); //레코드만큼 반복하는 람다식
	}
	
	//@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setB_subject("게시판테스트입니다.");
		board.setB_name("홍길동");
		board.setB_contents("게시판입니다.~~~~~");
		mapper.insert(board);
		//log.info(board);
	}
	
	//@Test
	public void testRead() {
		BoardVO board = new BoardVO();
		board.setB_num(2);  //2번을 VO객체에 저장
		
		board = mapper.read(board); //read 메서드호출해서 객체 반환
		log.info(board);
	}
	
	//@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setB_num(2);
		board.setB_subject("게시판 수정합니다.");
		board.setB_name("홍길동수정");
		board.setB_contents("게시판입니다.~~~~~수정");
		mapper.update(board);
	}
	
	//@Test
	public void testDelete() {
		BoardVO board = new BoardVO();
		board.setB_num(5);
		mapper.delete(board);
	}

}




