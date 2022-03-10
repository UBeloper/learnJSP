package com.it.mapper;

import java.util.List;

import com.it.domain.Board2VO;
import com.it.domain.PageDTO;

public interface Board2Mapper {
	
	public List<Board2VO> getList(PageDTO page);
	// 아무것도 안줬다면 1과 10으로 생성이 된다.(디폴트 생성자)
	
	public void insert(Board2VO board);
	
	public Board2VO read(Board2VO board);
	
	public void update(Board2VO board);
	
	public void delete(Board2VO board);
	
	public int getTotalCount();

}
