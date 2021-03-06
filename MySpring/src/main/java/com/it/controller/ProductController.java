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

import com.it.domain.ProductVO;
import com.it.service.ProductService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/product/")
public class ProductController {
	@Setter(onMethod_ = @Autowired)
	private ProductService service;
	
	@GetMapping("/list")
	public void list(Model model) {  //Model 객체는 VO객체를 저장해서 jsp 파일로 전송, 현재는 비어있음
		//list.jsp 에 데이터를 전달해야 함
		model.addAttribute("list", service.getList());  //getList로 조회한 모든 내용을 list변수로 전달
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	@PostMapping("/insert")
	public String insert(ProductVO product) {
		//log.info(product);
		service.insert(product);
		return "redirect:/product/list";
	}
	
	@GetMapping("/view")
	public void view(ProductVO product, Model model) {
		product = service.read(product);
		model.addAttribute("product", product);
	}
	
	@GetMapping("/imgupload")
	public void imgupload(ProductVO product, Model model) {
		log.info(product);
		model.addAttribute("p_code", product.getP_code());
	}

	@PostMapping("/imgupload")
	public void imgupload(HttpServletRequest request) {
		DiskFileUpload upload = new DiskFileUpload(); // 파일전송 컴포넌트 객체 생성
		
		try {
		List items = upload.parseRequest(request); // 웹브라우저 전송 객체 생성해서 업로드 컴포넌트
		Iterator params = items.iterator(); // 반복자 생성
				
		// *저장위치*
		String imgpath = "C:\\MyWorkSpace\\learnJsp\\MySpring\\src\\main\\webapp\\resources\\product";
		String p_code = "";
		
		
		while(params.hasNext()) { // form 객체가 있을경우
			FileItem item = (FileItem)params.next(); // 폼객체를 변수에 저장
			log.info("item : " + item);
			
			if(item.isFormField()) { // 파일 형식이 아니라면
				p_code = item.getString();
				log.info("p_code : " + p_code);
//				log.info("상품코드 : " + item); // item 확인하기 위해 내가 찍어봄.

				
			}else { // 바이너리 파일이라면
				
				File imgfile = new File(imgpath + "/" + p_code + ".jpg"); //파일객체 생성
				item.write(imgfile);

//				log.info("이미지파일 : " + item); // 확인위해 그냥 찍어본 것.
	
//				String data = item.getName(); // 파일 이름이라면 getName으로 출력
//				log.info(data);
				
			}
		}
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}
