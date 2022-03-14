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
	
	public PageViewDTO(PageDTO page, int total) {
		this.page = page;
		this.total = total;
		
		this.endPage = (int)Math.ceil(page.getPageNum() / (double)page.getPageAmount() ) * 10;
		this.startPage = this.endPage - 10 + 1;
		
		this.realEndPage = (int)Math.ceil(total / page.getPageAmount());
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEndPage;
				
	}
}
