package com.it.domain;

import lombok.Data;

@Data
public class PageViewDTO {
	private int startPage;
	private int endPage;
	private int realEndPage;
	private boolean prev;
	private boolean next;

	private int total;
	
	PageDTO page;
	// 이 정보로 나머지 변수를 계산해야하니까.
	
	
	/*
	 * public PageViewDTO() { // 디폴트 생성자 this.startPage = 1; this.endPage =
	 * page.getPageAmount();
	 * 
	 * }
	 */
	 
	
	public PageViewDTO(PageDTO page, int total) {
		this.page = page;
		this.total = total;
				
		this.endPage = (int)Math.ceil(page.getPageNum() / (double)page.getPageAmount() ) * 10;
		// 10, 20, 30 ...
		this.startPage = this.endPage - 10 + 1;
		// 1, 11, 21 ...
		
		this.realEndPage = (int)Math.ceil(total / (double)page.getPageAmount());
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		this.prev = this.startPage > 1;  // 최소한 시작이 11페이지일 경우 참 (페이지 그룹 째로 이동)
		this.next = this.endPage < this.realEndPage;
		
		
	}
	
}
