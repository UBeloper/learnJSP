package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.domain.BoardVO;
import com.it.domain.PageDTO;
import com.it.domain.PageViewDTO;
import com.it.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/")
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model, PageDTO page, @RequestParam("user") String user, 
			        @RequestParam("age") int age) {  //Model 객체는 VO객체를 저장해서 jsp 파일로 전송, 현재는 비어있음
												     //list.jsp 에 데이터를 전달해야 함
		
		// ******** 단일변수를 넘기고 싶을 때 @RequestParam("") vartype varname ********
		// public void list(Model model, PageDTO page, @RequestParam("user") String user, 
		//                  @RequestParam("age") int age)
		
		// 객체로 넘기면, 일단 객체 통째로 넘겨지기때문에 오류날 우려가 없다(일단 객체로 넘겨지고 빈값이 있다 정도로 취급). 안정적.
		// 저대로 해서 null값이면 오류가 나기때문에 if문을 사용해서 컨트롤해줘야한다. 널일경우 이렇게 아닐경우 저렇게.
				
		model.addAttribute("list", service.getList(page));  //getList로 조회한 모든 내용을 list변수로 전달
		
		int total = service.getTotalCount(); // 전체 레코드 개수
		log.info(total);
		PageViewDTO pageview = new PageViewDTO(page, total);
		log.info("pageview :: " + pageview);
		model.addAttribute("pageview", pageview);
		model.addAttribute("user", user); 
		model.addAttribute("age", age);
		
		// localhost:8080/board/list?user=홍길동&age=30
		
//		log.info("user : " + user); // 단일변수 넘기기 test
//		log.info("age : " + age); // test
		
	}
	
	@GetMapping("/insert")
	public void insert() {
		//페이지를 호출만 함
	}
	
	@PostMapping("/insert")
	public String insert(BoardVO board) {
		log.info("-----------글쓰기 시작--------------------");
		log.info(board);
		//테이블에 입력
		service.insert(board);
		//리스트로 이동(return 사용)
		log.info("-----------글쓰기 완료--------------------");
		
		return "redirect:/board/list";  //controller 를 통해서 이동
	}
	
	@GetMapping("/view")
	public void view(BoardVO board, Model model, PageDTO page) {
//		log.info("---------------읽기 전--------------------");
//		log.info(board);
		board = service.read(board);
		log.info("== GetMapping /view == ");
		log.info(board);
		log.info(page);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
	}
	
	@GetMapping("/update")
	public void update(BoardVO board, Model model, PageDTO page) {
//		log.info("-------------업데이트를 위한 번호 ------------------");
//		log.info(board);
		board = service.read(board);  //번호만 사용하여 조회
		log.info("== GetMapping /update ==");
		log.info(board);
		log.info(page);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
	}
	
	@PostMapping("/update")
	public String update(BoardVO board, PageDTO page) {
		log.info("== PostMapping /update ==");
		service.update(board); //업데이트
		log.info(board);
		log.info(page);
		return "redirect:/board/view?b_num=" + board.getB_num() + "&pageNum=" + page.getPageNum();
	} 
	
	@GetMapping("/delete")
	public String delete(BoardVO board) {
		log.info("------------- 삭제 -----------------");
		service.delete(board);
		return "redirect:/board/list";
	}
		
}
