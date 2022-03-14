package com.it.domain;

import lombok.Data;

@Data
public class PageDTO {
	private int pageNum;
	private int pageAmount;
	
	public PageDTO() {
		this.pageNum = 1;
		this.pageAmount = 10;
	}
	
	public PageDTO(int pageNum, int pageAmount) {
		this.pageNum = pageNum;
		this.pageAmount = pageAmount;
	}

}
