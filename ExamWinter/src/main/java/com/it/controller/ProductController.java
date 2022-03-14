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
	public void callListPage(Model model) {  //Model 객체는 VO객체를 저장해서 jsp 파일로 전송
		model.addAttribute("list", service.getList());  //getList로 조회한 모든 내용을 list변수로 전달
	}
	
	@GetMapping("/view")
	public void callViewPage(ProductVO product, Model model) {
		log.info(product);
		model.addAttribute("product", service.read(product));
	}
	
	@GetMapping("/insert")
	public void callInsertView() {
		
	}
	
	@PostMapping("insert")
	public String insert(ProductVO product) {
		service.insert(product);	
		return "redirect:/product/list";
	}
	
//	@PostMapping("/insert")
//	public String insert(HttpServletRequest request) {
//		DiskFileUpload upload = new DiskFileUpload(); // 파일전송 컴포넌트 객체 생성
//		
//		try {
//		List items = upload.parseRequest(request); // 웹브라우저 전송 객체 생성해서 업로드 컴포넌트
//		Iterator params = items.iterator(); // 반복자(ArrayList화 -> arraylist객체로 변신) 생성
//		
//		String filepath = "C:\\MyWorkSpace\\learnJsp\\ExamWinter\\src\\main\\webapp\\resources\\product";
//		String p_code = "";
//		
//		ProductVO product = new ProductVO();
//		
//		while(params.hasNext()) { // form 객체가 있을경우
//			FileItem item = (FileItem)params.next(); // 폼객체를 변수에 저장
//			
//			if(item.isFormField()) { // 파일 형식이 아니라면
//				p_code = item.getString();
//				String fieldname = item.getFieldName();
//				String fieldvalue = item.getString("utf-8");
//				log.info("==================");
//				log.info("fieldname : " + fieldname);
//				log.info("fieldvalue : " + fieldvalue);
//				
//				  if(fieldname.equals("p_name")) { 
//					  product.setP_name(fieldvalue); 
//					  } else if(fieldname.equals("p_price")) {
//						  Integer price = Integer.parseInt(fieldvalue);
//						  product.setP_price(price);
//					  } 				 
//				
//			}else { // 바이너리 파일이라면
//				log.info("순서");
//				String fname = item.getName();
//				log.info("fname : " + fname);
//				
//				if(fname != "") {
//					product.setP_file(fname);
//					File file = new File(filepath + "/" + fname); 
//					//파일객체(Capitano.jpg) 생성
//				 //	File(String pathname) 입력한 pathname(파일명 포함) 경로 파일의 객체를 생성한다.
//				 item.write(file);
//				}
//				
//			}
//		}
//		
//		log.info(product);
//		service.insert(product);
//		return "redirect:/product/list";
//		
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		return "redirect:/product/list";
//		
//	}
	
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
		
//		log.info("items : " + items);
//		log.info("params : " + params);
//		log.info("params.Next() : " + params.next());
		
//		log.info(items.size());
		
		// *저장위치*
		//product 폴더 -> 우클릭 -> properties
		String imgpath = "C:\\MyWorkSpace\\learnJsp\\ExamWinter\\src\\main\\webapp\\resources\\product";
		String p_code = "";
		
		
		while(params.hasNext()) { // form 객체가 있을경우
			FileItem item = (FileItem)params.next(); // 폼객체를 변수에 저장
			
			if(item.isFormField()) { // 파일 형식이 아니라면
				p_code = item.getString();
				
//				log.info("상품코드 : " + item); // item 확인하기 위해 내가 찍어봄.
				
//				String data = item.getString();
//				log.info(data);
				
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
	
	@PostMapping("/view")
	public void viewUpdate(ProductVO product) {
		log.info(product);
//		service.update(product);
	}
	
}
