package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.PageDTO;
import com.it.domain.ProductVO;
import com.it.mapper.ProductMapper;

import lombok.Setter;

@Service
public class ProductServiceImpl implements ProductService {

	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	
	@Override
	public ProductVO read(ProductVO product) {
		return mapper.read(product);
	}
	
	@Override
	public void insert(ProductVO product) {
		mapper.insert(product);
	}
	
	@Override
	public List<ProductVO> getList(PageDTO page) {
		return mapper.getList(page);
	}
	
	@Override
	public void update(ProductVO product) {
		mapper.update(product);
	}
	
	@Override
	public void delete(ProductVO product) {
		mapper.delete(product);
	}

	@Override
	public int getTotalCount() {
		
		return mapper.getTotalCount();
	}
	
	

	

}
