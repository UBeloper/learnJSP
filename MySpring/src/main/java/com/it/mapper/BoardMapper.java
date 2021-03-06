package com.it.mapper;

import java.util.List;

import com.it.domain.BoardVO;
import com.it.domain.PageDTO;

public interface BoardMapper {
	public List<BoardVO> getList(PageDTO page);
	// 아무것도 안줬다면 1과 10으로 생성이 된다.(디폴트 생성자)
	
	public void insert(BoardVO board);
	
	public BoardVO read(BoardVO board);
	
	public void update(BoardVO board);
	
	public void delete(BoardVO board);
	
	public int getTotalCount();
	
}
