package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.ProductVO;
import com.it.mapper.ProductMapper;

import lombok.Setter;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	public List<ProductVO> getList() {
		return mapper.getList();
	}

	public void insert(ProductVO product) {
		mapper.insert(product);
	}
	
	public ProductVO read(ProductVO product) {
		return mapper.read(product);
	}
	
	public void update(ProductVO product) {
		mapper.update(product);
	}
	
	public void delete(ProductVO product) {
		mapper.delete(product);
	}
}
