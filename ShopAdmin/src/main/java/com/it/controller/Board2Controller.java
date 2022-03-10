package com.it.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.Board2VO;
import com.it.domain.PageDTO;
import com.it.domain.PageViewDTO;
import com.it.service.Board2Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board2/")
public class Board2Controller {
	@Setter(onMethod_ = @Autowired)
	private Board2Service service;
	
	@GetMapping("/list")
	public void list(Model model, PageDTO page) {  
		
//		(@RequestParam("user") String user, 
//		        @RequestParam("age") int age)
//		아래의 얘네도 주석 //		model.addAttribute("user", user); 
//								model.addAttribute("age", age);
		
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
//		model.addAttribute("user", user); 
//		model.addAttribute("age", age);
		
		// localhost:8080/board/list?user=홍길동&age=30
		
//		log.info("user : " + user); // 단일변수 넘기기 test
//		log.info("age : " + age); // test
		
	}
	
	@GetMapping("/insert")
	public void insert() {
		//페이지를 호출만 함
	}
	
	@PostMapping("/insert")
	public void insert2(HttpServletRequest request) {
		DiskFileUpload upload = new DiskFileUpload(); // 파일전송 컴포넌트 객체 생성
		
		try {
		List items = upload.parseRequest(request); // 웹브라우저 전송 객체 생성해서 업로드 컴포넌트
		Iterator params = items.iterator(); // 반복자(ArrayList화 -> arraylist객체로 변신) 생성
		
		log.info("request : " + request);
		log.info("items : " + items);
		log.info("params : " + params); 
		log.info("params.Next() : " + params.next());
		log.info(items.size());
		
		// *저장위치*
		//product 폴더 -> 우클릭 -> properties
		String filepath = "C:\\MyWorkSpace\\learnJsp\\pds";
		//String p_code = "";
		
		Board2VO board = new Board2VO();
		
		while(params.hasNext()) { // form 객체가 있을경우
			FileItem item = (FileItem)params.next(); // 폼객체를 변수에 저장
			
			if(item.isFormField()) { // 파일 형식이 아니라면
				// p_code = item.getString();
				String fieldname = item.getFieldName();
				String fieldvalue = item.getString("utf-8");
				log.info("==================");
				log.info("fieldname : " + fieldname);
				log.info("fieldvalue : " + fieldvalue);
				
				  if(fieldname.equals("b_subject")) { 
					  board.setB_subject(fieldvalue); 
					  } else if(fieldname.equals("b_name")) {
						  board.setB_name(fieldvalue);
					  } else if  (fieldname.equals("b_contents")) {
						  board.setB_contents(fieldvalue); 
						 }
				 
				
			}else { // 바이너리 파일이라면
				log.info("순서");
				String fname = item.getName();
				log.info("fname : " + fname);
				
				if(fname != "") {
					board.setB_file(fname);
				 File file = new File(filepath + "/" + fname); //파일객체 생성
				 item.write(file);
				}
				
			}
		}
		log.info(board);
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	
	
	
	/* 시작
	
	@GetMapping("/view")
	public void view(Board2VO board, Model model, PageDTO page) {
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
	public void update(Board2VO board, Model model, PageDTO page) {
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
	public String update(Board2VO board, PageDTO page) {
		log.info("== PostMapping /update ==");
		service.update(board); //업데이트
		log.info(board);
		log.info(page);
		return "redirect:/board2/view?b_num=" + board.getB_num() + "&pageNum=" + page.getPageNum();
	} 
	
	@GetMapping("/delete")
	public String delete(Board2VO board) {
		log.info("------------- 삭제 -----------------");
		service.delete(board);
		return "redirect:/board2/list";
	}
	
	끝 */

}
