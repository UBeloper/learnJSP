package com.it.domain;

import lombok.Data;

@Data
public class PageDTO {
	private int pageNum;
	private int pageAmount;
	
	// 정보가 아무것도 안들어오면, 이걸로 디폴트로 생성되게끔
	// 디폴트 생성자
	public PageDTO() {
//		this(1, 10);
		 this.pageNum = 1;
		 this.pageAmount = 10;
	}
	
	
	// 객체를 생성하여 파라미터로 받아오는 생성자
	public PageDTO(int pageNum, int pageAmount) {
		this.pageNum = pageNum;
		this.pageAmount = pageAmount;
		
	}
	
	
	
	
	
}
