package com.it.mapper;

import java.util.List;

import com.it.domain.ProductVO;

public interface ProductMapper {
	public List<ProductVO> getList();
	public ProductVO read(ProductVO product);
	public void insert(ProductVO product);
	public void delete(ProductVO product);
	public void update(ProductVO product);
	
}
