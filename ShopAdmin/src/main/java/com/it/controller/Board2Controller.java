package com.it.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void list(Model model, PageDTO page/*, @RequestParam("user") String user, @RequestParam("age") int age)*/) {  
		
//		(@RequestParam("user") String user, 
//		        @RequestParam("age") int age)
//		아래의 얘네도 주석 //		model.addAttribute("user", user); 
//								model.addAttribute("age", age);
		
		// ******** 단일변수를 넘기고 싶을 때 @RequestParam("") vartype varname ********
		// public void list(Model model, PageDTO page, @RequestParam("user") String user, @RequestParam("age") int age)
		
		// 객체로 넘기면, 일단 객체 통째로 넘겨지기때문에 오류날 우려가 없다(일단 객체로 넘겨지고 빈값이 있다 정도로 취급). 안정적.
		// 저대로 해서 null값이면 오류가 나기때문에 if문을 사용해서 컨트롤해줘야한다. 널일경우 이렇게 아닐경우 저렇게.
				
		model.addAttribute("list", service.getList(page));  //getList로 조회한 모든 내용을 list변수로 전달
		
		int total = service.getTotalCount(); // 전체 레코드 개수
		log.info(total);
		PageViewDTO pageview = new PageViewDTO(page, total);
		log.info("pageview :: " + pageview);
		model.addAttribute("pageview", pageview);
		/* model.addAttribute("user", user); 
		model.addAttribute("age", age); */
		
		// localhost:8080/board/list?user=홍길동&age=30
		
		/* log.info("user : " + user); // 단일변수 넘기기 test
		log.info("age : " + age); // test */
		
	}
	
	@GetMapping("/insert")
	public void insert() {
		//페이지를 호출만 함
	}
	
	@PostMapping("/insert")
	public String insert2(HttpServletRequest request) {
		DiskFileUpload upload = new DiskFileUpload(); // 파일전송 컴포넌트 객체 생성
		
		try {
		List items = upload.parseRequest(request); // 웹브라우저 전송 객체 생성해서 업로드 컴포넌트
		Iterator params = items.iterator(); // 반복자(ArrayList화 -> arraylist객체로 변신) 생성
		
//		log.info("request : " + request);
//		log.info("items : " + items);
//		log.info("params : " + params); 
//		log.info("params.Next() : " + params.next());
//		log.info(items.size());
		
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
				 File file = new File(filepath + "/" + fname); //파일객체(Capitano.jpg) 생성
				 //	File(String pathname) 입력한 pathname(파일명 포함) 경로 파일의 객체를 생성한다.
				 item.write(file);
				}
				
			}
		}
		
		log.info(board);
		service.insert(board);
		return "redirect:/board2/list";
		
		} catch (Exception e) {
			System.out.println(e);
			
		}
		
		return "redirect:/board2/list";
		
	}
	
	@GetMapping("/download")
	public void download(Board2VO board, HttpServletResponse response) {
		/* - request 기본 객체와는 정반대로 웹 브라우저에 보내는 응답 정보를 담는다. */
		/* response => HTTP 응답 정보(요청 처리 결과)를 제공하는 인터페이스 */
		/* request => HTTP 요청 정보(클라이언트 요청, 쿠키, 세션 등)를 제공하는 인터페이스 */
		
		board = service.read(board);
		
		try {
			String filepath = "C:\\MyWorkSpace\\LearnJsp\\pds\\" + board.getB_file();
//			File file = new File(filepath + "\\" + board.getB_file()); //   "/"와 "\\"의 구분?
			File file = new File(filepath); // filepath에 board.getB_file()까지 추가해서 완전한 경로를 갖추었으니 위에꺼 주석
			
			String newName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"); // 다운로드파일 한글깨짐문제처리
			
			// 웹페이지가 아닌 파일객체를 클라이언트에 전송한다는 지시어
			// 기본적으로 text/html을 전송하는데, 파일도 함께 보낸 느낌.
			// 클라이언트 웹브라우저에 파일 다운로드 처리됨
			
//			log.info("newName : " + newName);
			
			response.setHeader("Content-Disposition", "attachment;filename=" + newName); // file.getName() -> newName변수
			log.info("response : " + response);
			
			log.info("file : " + file);
			FileInputStream fis = new FileInputStream(filepath); // 객체를 생성할 때 데이터를 읽어올 파일을 지정
			OutputStream out = response.getOutputStream(); 	
			// 바이트단위 파일처리 
			
			
//			log.info("out : " + out);
			
			int read = 0; // 1024 단위로 읽은 바이트 수 // 처음에는 못 읽었다고 가정하고
			byte[] buffer = new byte[1024]; // 임의로 조정 가능 // 성능에 따라 임의로 다르게 할 수 있는 것.
											/* 내용이 있는 부분 <= 읽은 실체 */
			
			
			while((read = fis.read(buffer)) != -1) // -1 반환 : 더 이상 못 읽으면 <== 파일 끝에 도달했을 경우
			{
				out.write(buffer, 0, read); // buffer를 쓰는데, 0부터 read까지 읽으세요.
											// 로컬로 보내는 것이아닌 브라우저 서버로 보내는 것.
				log.info(read);
			}
			
			
		} catch(Exception e) {
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
